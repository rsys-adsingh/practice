#include <iostream>
#include <vector>
#include <queue>

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

// Custom comparator for the priority queue
struct compare {
    bool operator()(ListNode* a, ListNode* b) {
        // We want a Min-Heap, so return true if a's value is greater than b's
        return a->val > b->val;
    }
};

class Solution {
public:
    ListNode* mergeKLists(std::vector<ListNode*>& lists) {
        // Priority queue to store the heads of the lists
        std::priority_queue<ListNode*, std::vector<ListNode*>, compare> pq;

        // 1. Initialize: Push the head of each non-empty list into the heap
        for (ListNode* listHead : lists) {
            if (listHead != nullptr) {
                pq.push(listHead);
            }
        }

        // 2. Dummy node to simplify result list construction
        ListNode dummy(0);
        ListNode* tail = &dummy;

        // 3. Process the heap
        while (!pq.empty()) {
            // Get the smallest node from the heap
            ListNode* smallestNode = pq.top();
            pq.pop();

            // Add it to our merged list
            tail->next = smallestNode;
            tail = tail->next;

            // If this node has a neighbor, push it into the heap
            if (smallestNode->next != nullptr) {
                pq.push(smallestNode->next);
            }
        }

        return dummy.next;
    }
};

// Helper function to print the list
void printList(ListNode* node) {
    while (node) {
        std::cout << node->val << " -> ";
        node = node->next;
    }
    std::cout << "NULL" << std::endl;
}

int main() {
    // Example: [[1,4,5],[1,3,4],[2,6]]
    ListNode* l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode* l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode* l3 = new ListNode(2, new ListNode(6));

    std::vector<ListNode*> lists = {l1, l2, l3};
    
    Solution sol;
    ListNode* result = sol.mergeKLists(lists);
    
    printList(result); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> NULL

    return 0;
}