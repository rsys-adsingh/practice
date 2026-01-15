#include <stdio.h>
#include <pthread.h>

// Shared resources
int count = 0;
pthread_mutex_t mtx = PTHREAD_MUTEX_INITIALIZER; // Static initialization

void* inc_mutex(void* arg) {
for (int i = 0; i < 100000; i++) {
// Lock before accessing shared state
pthread_mutex_lock(&mtx); 
count++; 
// Unlock immediately after
pthread_mutex_unlock(&mtx); 
}
return NULL;
}

int main() {
pthread_t t1, t2;

// Create two threads running the same function
pthread_create(&t1, NULL, inc_mutex, NULL);
pthread_create(&t2, NULL, inc_mutex, NULL);

pthread_join(t1, NULL);
pthread_join(t2, NULL);

printf("Mutex Final Count: %d\n", count); // Should be 200000
pthread_mutex_destroy(&mtx);
return 0;
}