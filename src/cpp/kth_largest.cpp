#include <iostream>
#include <vector>
#include <queue>

class KthLargest {
private:
    // Min-heap to store only the 'k' largest elements
    std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;
    int k_size;

public:
    // Initializes the object with the integer k and the stream of integers nums
    KthLargest(int k, std::vector<int>& nums) {
        k_size = k;
        for (int x : nums) {
            add(x);
        }
    }

    // Appends the integer val to the stream and returns the kth largest element
    int add(int val) {
        minHeap.push(val);

        // If heap size exceeds k, remove the smallest element
        if (minHeap.size() > k_size) {
            minHeap.pop();
        }

        // The top of the min-heap is the kth largest element
        return minHeap.top();
    }
};

/**
 * Example Usage:
 */
int main() {
    std::vector<int> nums = {4, 5, 8, 2};
    KthLargest* kthLargest = new KthLargest(3, nums);
    
    std::cout << kthLargest->add(3) << std::endl;   // returns 4
    std::cout << kthLargest->add(5) << std::endl;   // returns 5
    std::cout << kthLargest->add(10) << std::endl;  // returns 5
    std::cout << kthLargest->add(9) << std::endl;   // returns 8
    std::cout << kthLargest->add(4) << std::endl;   // returns 8

    delete kthLargest;
    return 0;
}

/*
To find the $k^{th}$ Largest Element in a Stream, the most efficient approach is using a Min-Priority Queue (Min-Heap) of fixed size $k$.
Logic and StrategyWhy a Min-Heap? * To find the $k^{th}$ largest element, we need to keep track of the $k$ largest elements seen so far.
In a Min-Heap of size $k$, the smallest of these "top $k$" elements will be at the root (the top).
Since it is the smallest of the $k$ largest elements, it is mathematically the $k^{th}$ largest element of the entire stream.
Maintaining the Heap:When a new number arrives, we add it to the Min-Heap.If the heap size exceeds $k$, we pop the top element (the overall smallest).
The remaining $k$ elements in the heap are the current $k$ largest values.
*/