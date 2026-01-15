#include <stdio.h>
#include <pthread.h>
#include <stdatomic.h>

// Atomic integer type
atomic_int count = 0; 

void* inc_atomic(void* arg) {
for (int i = 0; i < 100000; i++) {
// Atomic increment operation
atomic_fetch_add(&count, 1); 
}
return NULL;
}

int main() {
pthread_t t1, t2;

pthread_create(&t1, NULL, inc_atomic, NULL);
pthread_create(&t2, NULL, inc_atomic, NULL);

pthread_join(t1, NULL);
pthread_join(t2, NULL);

printf("Atomic Final Count: %d\n", count);
return 0;
}