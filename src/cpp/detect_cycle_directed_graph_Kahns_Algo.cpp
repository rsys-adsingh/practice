#include <iostream>
#include <vector>
#include <queue>

class Graph {
    int V;
    std::vector<std::vector<int>> adj;

public:
    Graph(int V) : V(V), adj(V) {}

    void addEdge(int u, int v) {
        adj[u].push_back(v);
    }

    bool isCyclic() {
        std::vector<int> inDegree(V, 0);

        // 1. Calculate in-degree of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj[i]) {
                inDegree[neighbor]++;
            }
        }

        // 2. Add all vertices with 0 in-degree to the queue
        std::queue<int> q;
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }

        int count = 0; // Count of nodes processed in topological order

        // 3. BFS traversal
        while (!q.empty()) {
            int curr = q.front();
            q.pop();
            count++;

            // For each neighbor, reduce in-degree
            for (int neighbor : adj[curr]) {
                inDegree[neighbor]--;

                // If in-degree becomes 0, add to queue
                if (inDegree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }

        // 4. If count of processed nodes is not V, there is a cycle
        return (count != V);
    }
};

int main() {
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 0); // Cycle: 0->1->2->0
    g.addEdge(2, 3);

    if (g.isCyclic()) {
        std::cout << "Cycle detected using Kahn's Algorithm." << std::endl;
    } else {
        std::cout << "No cycle detected." << std::endl;
    }

    return 0;
}


/*
Kahn’s Algorithm is a BFS-based approach to Topological Sorting. 
In a Directed Acyclic Graph (DAG), you can always find a linear ordering of vertices. 
However, if a graph contains a cycle, a complete topological sort is impossible because at least one node in the cycle will never have an in-degree of zero.
The Logic: In-Degree Approach In-Degree Calculation: Count how many edges point to each node.
Initial Queue: Push all nodes with an in-degree of 0 (no dependencies) into a queue.
Process and Reduce:Pop a node from the queue and increment a counter (representing a successful step in the topological sort).
For every neighbor of this node, reduce its in-degree by 1.If a neighbor's in-degree becomes 0, push it into the queue.
The Result: If the final counter equals the number of vertices $V$, the graph is a DAG. If the counter is less than $V$, it means some nodes were never processed because they were stuck in a cycle.

*/