#include <iostream>
#include <unordered_map>
#include <list>

class LRUCache {
    int capacity;
    std::list<int> dq; // Stores keys, front = most recently used
    std::unordered_map<int, std::pair<int, std::list<int>::iterator>> ma;
    // key -> {value, iterator into dq}

public:
    LRUCache(int n) : capacity(n) {}

    int get(int key) {
        auto it = ma.find(key);
        if (it == ma.end()) return -1;

        // Move this key to the front (most recently used)
        dq.erase(it->second.second);
        dq.push_front(key);
        it->second.second = dq.begin();

        return it->second.first;
    }

    void put(int key, int value) {
        auto it = ma.find(key);

        if (it != ma.end()) {
            // Key already exists: remove its current position in list
            dq.erase(it->second.second);
        } else if ((int)dq.size() == capacity) {
            // Cache is full: evict LRU (back of list)
            int lruKey = dq.back();
            dq.pop_back();
            ma.erase(lruKey);
        }

        // Insert as most recently used
        dq.push_front(key);
        ma[key] = {value, dq.begin()};
    }
};

int main() {
    // Example usage:
    LRUCache cache(2); // capacity = 2

    cache.put(1, 1); // cache: {1=1}
    cache.put(2, 2); // cache: {2=2, 1=1}

    std::cout << cache.get(1) << "\n"; // returns 1, cache: {1=1, 2=2}

    cache.put(3, 3); // evicts key 2, cache: {3=3, 1=1}

    std::cout << cache.get(2) << "\n"; // returns -1 (not found)

    cache.put(4, 4); // evicts key 1, cache: {4=4, 3=3}

    std::cout << cache.get(1) << "\n"; // returns -1 (not found)
    std::cout << cache.get(3) << "\n"; // returns 3
    std::cout << cache.get(4) << "\n"; // returns 4

    return 0;
}
