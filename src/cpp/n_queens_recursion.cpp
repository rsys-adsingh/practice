#include <iostream>
using namespace std;

bool isSafe(int** board, int row, int col, int n) {
    // Check this column on upper side
    for (int i = 0; i < row; i++)
        if (board[i][col] == 1)
            return false;

    // Check upper diagonal on left side
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if (board[i][j] == 1)
            return false;

    // Check upper diagonal on right side
    for (int i = row, j = col; i >= 0 && j < n; i--, j++)
        if (board[i][j] == 1)
            return false;

    return true;
}

bool solveNQUtil(int **board, int row, int n) {
    if (row >= n)
        return true;

    for (int col = 0; col < n; col++) {
        if (isSafe(board, row, col, n)) {
            board[row][col] = 1;

            if (solveNQUtil(board, row + 1, n))
                return true;

            board[row][col] = 0; // BACKTRACK
        }
    }
    return false;
}

void solveNQ(int n) {
    // Create a 2D array to represent the board
    int** board = new int*[n+1];
    for (int i = 0; i < n+1; ++i)
        board[i] = new int[n+1]();

    if (solveNQUtil(board, 0, n))
        cout << "Solution exists" <<endl;
    else
        cout << "No solution exists" <<endl;

    // Free allocated memory
    for (int i = 0; i < n+1; ++i)
        delete[] board[i];
    delete[] board;
}

int main() {
    int n;
    cout<< "Enter the number of queens: ";
    cin>> n;
    solveNQ(n);
    return 0;
}