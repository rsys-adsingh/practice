#include <stdio.h>
#include <pthread.h>

int count = 0;
pthread_spinlock_t spin;

void* inc_spinlock(void* arg) {
for (int i = 0; i < 100000; i++) {
pthread_spin_lock(&spin); // Busy wait if locked
count++;
pthread_spin_unlock(&spin);
}
return NULL;
}

int main() {
pthread_t t1, t2;
// PTHREAD_PROCESS_PRIVATE means lock is not shared with other processes
pthread_spin_init(&spin, PTHREAD_PROCESS_PRIVATE);

pthread_create(&t1, NULL, inc_spinlock, NULL);
pthread_create(&t2, NULL, inc_spinlock, NULL);

pthread_join(t1, NULL);
pthread_join(t2, NULL);

printf("Spinlock Count: %d\n", count);
pthread_spin_destroy(&spin);
return 0;
}