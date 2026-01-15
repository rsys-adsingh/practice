#include <iostream>
#include <queue>
#include <vector>

class MedianFinder {
private:
    // Max-heap to store the smaller half of the numbers
    std::priority_queue<int> leftMaxHeap; 
    
    // Min-heap to store the larger half of the numbers
    std::priority_queue<int, std::vector<int>, std::greater<int>> rightMinHeap;

public:
    MedianFinder() {}

    // Adds a number from the data stream to the data structure
    void addNum(int num) {
        // Step 1: Add to Max-Heap
        leftMaxHeap.push(num);

        // Step 2: Balancing - Move the largest of the left to the right
        rightMinHeap.push(leftMaxHeap.top());
        leftMaxHeap.pop();

        // Step 3: Maintain size property (Left size >= Right size)
        if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.push(rightMinHeap.top());
            rightMinHeap.pop();
        }
    }

    // Returns the median of all elements read so far
    double findMedian() {
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            // Odd number of elements: median is the top of the larger heap
            return static_cast<double>(leftMaxHeap.top());
        } else {
            // Even number of elements: median is the average of both tops
            return (leftMaxHeap.top() + rightMinHeap.top()) / 2.0;
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */

int main() {
    MedianFinder mf;
    mf.addNum(1);
    mf.addNum(2);
    std::cout << "Median: " << mf.findMedian() << std::endl; // Output: 1.5
    mf.addNum(3);
    std::cout << "Median: " << mf.findMedian() << std::endl; // Output: 2.0
    return 0;
}