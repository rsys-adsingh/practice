#include <stdio.h>

enum DayDefaultENUM { DAY_SUNDAY, DAY_MONDAY, DAY_TUESDAY, DAY_WEDNESDAY, DAY_THURSDAY, DAY_FRIDAY, DAY_SATURDAY };
enum DayExplicitENUM { EXPLICIT_SUNDAY=1, EXPLICIT_MONDAY, EXPLICIT_TUESDAY, EXPLICIT_WEDNESDAY, EXPLICIT_THURSDAY, EXPLICIT_FRIDAY, EXPLICIT_SATURDAY };

int main() {
    enum DayDefaultENUM today1 = DAY_WEDNESDAY;
    printf("Day number of Wednesday is: %d\n", today1);  //Output : 3

    enum DayExplicitENUM today2 = EXPLICIT_WEDNESDAY;
    printf("Day number of Wednesday is: %d\n", today2);  //Output : 4

    return 0;
}

/* enum DayDefaultENUM { SUNDAY, MONDAY, TUESDAY, ... };
enum DayExplicitENUM { SUNDAY=1, MONDAY, TUESDAY, ... };

compiler sees you declaring SUNDAY, MONDAY, TUESDAY, etc. twice, which is not allowed.

This redeclaration causes the compiler errors about "redeclaration of enumerator" because these names are part of the global enumerator namespace.
*/