#include <iostream>
#include <vector>
#include <queue>
#include <string>

// 1. Define the Task structure
struct Task {
    int id;
    int priority;
    std::string description;

    // 2. Custom Comparator
    // We want the Priority Queue to act as a Max-Heap based on priority.
    // In C++ priority_queue, the "operator<" defines the priority.
    // The task with the "highest" value according to this operator is moved to the top.
    bool operator<(const Task& other) const {
        // If priorities are equal, you could secondary-sort by ID (FIFO)
        if (this->priority == other.priority) {
            return this->id > other.id; // Lower ID gets higher priority for tie-breaks
        }
        return this->priority < other.priority;
    }
};

class TaskScheduler {
private:
    std::priority_queue<Task> pq;

public:
    // Add a task to the scheduler
    void scheduleTask(int id, int priority, std::string desc) {
        Task newTask = {id, priority, desc};
        pq.push(newTask);
        std::cout << "Scheduled Task " << id << " (Priority: " << priority << ")\n";
    }

    // Execute the highest priority task
    void executeNext() {
        if (pq.empty()) {
            std::cout << "No tasks in the scheduler.\n";
            return;
        }

        Task current = pq.top();
        pq.pop();

        std::cout << ">> Executing Task " << current.id 
                  << ": " << current.description 
                  << " [Priority " << current.priority << "]\n";
    }

    bool hasTasks() {
        return !pq.empty();
    }
};

int main() {
    TaskScheduler scheduler;

    // Adding tasks in random order
    scheduler.scheduleTask(101, 2, "Low priority cleanup");
    scheduler.scheduleTask(102, 10, "CRITICAL: Security Patch");
    scheduler.scheduleTask(103, 5, "Feature update");
    scheduler.scheduleTask(104, 10, "CRITICAL: Database Backup");

    std::cout << "\n--- Starting Execution ---\n";

    while (scheduler.hasTasks()) {
        scheduler.executeNext();
    }

    return 0;
}
/*
1. The Priority Queue LogicThe core of the scheduler is std::priority_queue<Task>.Insertion (push): Takes $O(\log N)$ time. The heap property is maintained so the "largest" element (highest priority) stays at the top.Extraction (top and pop): Accessing the top is $O(1)$, and removing it is $O(\log N)$.
2. Handling Tie-BreaksIn the operator<, I added a check for cases where priorities are equal
This ensures that if two tasks have the same priority, the one with the smaller ID (presumably added earlier) is treated as having higher priority.
 This mimics a First-In-First-Out (FIFO) behavior for equal-priority tasks.
 3. Complexity AnalysisTime Complexity: $O(\log N)$ for both adding and fetching the next task.Space Complexity: $O(N)$ to store $N$ tasks in the heap.
*/