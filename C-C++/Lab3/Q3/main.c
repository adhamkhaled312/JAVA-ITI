#include <stdio.h>

double power(long long x, long long y);

int main(void) {
    printf("%lf\n", power(10, -5));
    printf("%lf\n", power(2, 3));
    printf("%lf\n", power(5, 0));
    return 0;
}

double power(long long x, long long y) {
    if (y == 0)
        return 1.0; 

    if (y > 0)
        return x * power(x, y - 1);
    else
        return 1.0 / power(x, -y);
}
