#include <stdio.h>
#include <pthread.h>

// Monitor Structure
typedef struct {
int count;
pthread_mutex_t mtx;
pthread_cond_t cv;
} CounterMonitor;

// Initialize Monitor
void monitor_init(CounterMonitor* mon) {
mon->count = 0;
pthread_mutex_init(&mon->mtx, NULL);
pthread_cond_init(&mon->cv, NULL);
}

// Monitor Method: Increment
void monitor_inc(CounterMonitor* mon) {
pthread_mutex_lock(&mon->mtx); // Enter Monitor

mon->count++;

// Optional: Signal others if they are waiting for a value change
pthread_cond_signal(&mon->cv);

pthread_mutex_unlock(&mon->mtx); // Exit Monitor
}

CounterMonitor global_monitor;

void* inc_monitor(void* arg) {
for (int i = 0; i < 100000; i++) {
monitor_inc(&global_monitor);
}
return NULL;
}

int main() {
pthread_t t1, t2;
monitor_init(&global_monitor);

pthread_create(&t1, NULL, inc_monitor, NULL);
pthread_create(&t2, NULL, inc_monitor, NULL);

pthread_join(t1, NULL);
pthread_join(t2, NULL);

printf("Monitor Count: %d\n", global_monitor.count);

// Cleanup
pthread_mutex_destroy(&global_monitor.mtx);
pthread_cond_destroy(&global_monitor.cv);
return 0;
}