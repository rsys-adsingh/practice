#include <iostream>
#include <vector>

class Graph {
    int V; // Number of vertices
    std::vector<std::vector<int>> adj; // Adjacency list

    // Helper function using DFS
    bool isCyclicUtil(int curr, std::vector<bool>& visited, std::vector<bool>& recStack) {
        if (!visited[curr]) {
            // Mark the current node as visited and part of recursion stack
            visited[curr] = true;
            recStack[curr] = true;

            // Recur for all vertices adjacent to this vertex
            for (int neighbor : adj[curr]) {
                // If neighbor is not visited and leads to a cycle
                if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recStack)) {
                    return true;
                }
                // If neighbor is already in the recursion stack, we found a back edge (cycle)
                else if (recStack[neighbor]) {
                    return true;
                }
            }
        }
        
        // Remove the vertex from recursion stack before returning
        recStack[curr] = false;
        return false;
    }

public:
    Graph(int V) : V(V), adj(V) {}

    void addEdge(int v, int w) {
        adj[v].push_back(w);
    }

    bool isCyclic() {
        std::vector<bool> visited(V, false);
        std::vector<bool> recStack(V, false);

        // Call the utility function for all unvisited vertices to handle disconnected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recStack)) return true;
            }
        }
        return false;
    }
};

int main() {
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 0); // This creates a cycle 0 -> 1 -> 2 -> 0
    g.addEdge(2, 3);

    if (g.isCyclic())
        std::cout << "Graph contains a cycle" << std::endl;
    else
        std::cout << "Graph doesn't contain a cycle" << std::endl;

    return 0;
}


/*
1. The Back Edge ConceptIf we encounter a node that is already in the recStack, it means we have found a path that circles back to one of its own ancestors. This is the definition of a cycle in a directed graph.
2. Handling Disconnected ComponentsThe isCyclic() function contains a loop that iterates through all vertices. This ensures that even if the graph has multiple separate "islands" of nodes, every node is checked for a potential cycle.
3. Time & Space ComplexityTime Complexity: $O(V + E)$, where $V$ is the number of vertices and $E$ is the number of edges. We visit each node and each edge exactly once.
Space Complexity: $O(V)$. We use two boolean arrays of size $V$ and the recursion stack can go up to $V$ levels deep in the worst case (a linear graph).
*/