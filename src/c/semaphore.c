#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

int count = 0;
sem_t sem;

void* inc_semaphore(void* arg) {
for (int i = 0; i < 100000; i++) {
// Wait (decrement) - blocks if value is 0
sem_wait(&sem); 

count++;

// Post (increment) - signals waiting threads
sem_post(&sem); 
}
return NULL;
}

int main() {
pthread_t t1, t2;

// Initialize semaphore:
// 0 = shared between threads of the same process
// 1 = initial value (unlocked)
sem_init(&sem, 0, 1); 

pthread_create(&t1, NULL, inc_semaphore, NULL);
pthread_create(&t2, NULL, inc_semaphore, NULL);

pthread_join(t1, NULL);
pthread_join(t2, NULL);

printf("Semaphore Final Count: %d\n", count);
sem_destroy(&sem);
return 0;
}