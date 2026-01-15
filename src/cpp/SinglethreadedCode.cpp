#include <iostream>
#include <chrono>
#include <thread>

void task1() {
std::cout << "Task 1 is running\n";
std::this_thread::sleep_for(std::chrono::seconds(2)); // Simulate work
std::cout << "Task 1 completed\n";
}

void task2() {
std::cout << "Task 2 is running\n";
std::this_thread::sleep_for(std::chrono::seconds(2)); // Simulate work
std::cout << "Task 2 completed\n";
}

int main() {
std::cout << "Single-threaded example\n";
task1(); // Runs first
task2(); // Runs after task1 completes
return 0;
}