#include <iostream>
#include <thread>
#include <chrono>

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
std::cout << "Multithreaded example\n";

// Create two threads
std::thread t1(task1);
std::thread t2(task2);

// Wait for both threads to finish
t1.join();
t2.join();

std::cout << "All tasks completed\n";
return 0;
}