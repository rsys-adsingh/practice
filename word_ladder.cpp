#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <queue>

class Solution {
public:
    int ladderLength(std::string beginWord, std::string endWord, std::vector<std::string>& wordList) {
        // 1. Put all words into a set for O(1) average lookup time
        std::unordered_set<std::string> dict(wordList.begin(), wordList.end());

        // 2. If endWord is not in the dictionary, no transformation is possible
        if (dict.find(endWord) == dict.end()) {
            return 0;
        }

        // 3. Queue for BFS: stores {current_word, current_step_count}
        std::queue<std::pair<std::string, int>> q;
        q.push({beginWord, 1});

        // 4. Start BFS
        while (!q.empty()) {
            std::string word = q.front().first;
            int steps = q.front().second;
            q.pop();

            // Check if we reached the target
            if (word == endWord) {
                return steps;
            }

            // 5. Generate all possible neighbors (words differing by 1 character)
            for (int i = 0; i < word.size(); i++) {
                char originalChar = word[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    word[i] = c; // Try replacing the character

                    // If the new word exists in the dictionary
                    if (dict.count(word)) {
                        dict.erase(word);      // Mark as visited by removing from set
                        q.push({word, steps + 1});
                    }
                }
                word[i] = originalChar; // Backtrack to original word for next index
            }
        }

        return 0; // No path found
    }
};

int main() {
    Solution solver;
    std::string begin = "hit";
    std::string end = "cog";
    std::vector<std::string> words = {"hot", "dot", "dog", "lot", "log", "cog","aditya"};

    int result = solver.ladderLength(begin, end, words);
    std::cout << "Shortest transformation length: " << result << std::endl;

    return 0;
}

/*
The Word Ladder problem is a classic application of graph theory, specifically designed to find the shortest transformation sequence between a starting word and a target word.

Problem Breakdown
Given two words, beginWord and endWord, and a dictionary wordList, you must find the length of the shortest transformation sequence such that:

Every adjacent pair of words in the sequence differs by exactly one letter.

Every transformed word must exist in the wordList (except for the beginWord).

If no such sequence exists, return 0.

Why Breadth-First Search (BFS)?
This problem can be modeled as an unweighted graph:

Nodes: Each word in the wordList.

Edges: An edge exists between two nodes if the words differ by exactly one character.

Goal: Find the shortest path from beginWord to endWord.

In any unweighted graph, BFS is the most efficient algorithm to find the shortest path because it explores all neighbors at distance 1, then distance 2, and so on. The first time we reach the endWord, we are guaranteed to have found the shortest path.
*/