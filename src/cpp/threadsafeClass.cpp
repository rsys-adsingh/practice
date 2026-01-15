#include <iostream>
#include <mutex>
#include <cstring>

class ThreadSafeMemoryManager {
private:
    void* memory;
    size_t currentSize;
    mutable std::mutex mtx;

public:
    ThreadSafeMemoryManager() : memory(nullptr), currentSize(0) {}

    ~ThreadSafeMemoryManager() {
        std::lock_guard<std::mutex> lock(mtx);
        if (memory) {
            free(memory);
            memory = nullptr;
        }
    }

    // Allocate memory
    bool allocate(size_t size) {
        std::lock_guard<std::mutex> lock(mtx);
        
        if (memory) {
            std::cerr << "Memory already allocated. Use reallocate() instead." << std::endl;
            return false;
        }

        memory = malloc(size);
        if (!memory) {
            std::cerr << "Memory allocation failed." << std::endl;
            return false;
        }

        currentSize = size;
        std::cout << "Allocated " << size << " bytes." << std::endl;
        return true;
    }

    // Reallocate memory if required size is greater than current size
    bool reallocate(size_t requiredSize) {
        std::lock_guard<std::mutex> lock(mtx);

        if (!memory) {
            std::cerr << "No memory allocated. Use allocate() first." << std::endl;
            return false;
        }

        if (requiredSize <= currentSize) {
            std::cout << "Current size (" << currentSize 
                      << " bytes) is sufficient for required size (" 
                      << requiredSize << " bytes)." << std::endl;
            return true;
        }

        void* newMemory = realloc(memory, requiredSize);
        if (!newMemory) {
            std::cerr << "Memory reallocation failed." << std::endl;
            return false;
        }

        memory = newMemory;
        currentSize = requiredSize;
        std::cout << "Reallocated to " << requiredSize << " bytes." << std::endl;
        return true;
    }

    size_t getSize() const {
        std::lock_guard<std::mutex> lock(mtx);
        return currentSize;
    }

    void* getMemory() const {
        std::lock_guard<std::mutex> lock(mtx);
        return memory;
    }
};

int main() {
    ThreadSafeMemoryManager manager;

    // Allocate initial memory
    manager.allocate(100);

    // Try to reallocate with smaller size (should not realloc)
    manager.reallocate(50);

    // Reallocate with larger size (should realloc)
    manager.reallocate(200);

    std::cout << "Current size: " << manager.getSize() << " bytes" << std::endl;

    return 0;
}