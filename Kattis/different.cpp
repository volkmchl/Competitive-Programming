#include <bits/stdc++.h>

typedef unsigned long long int  uint64;

int main(){
    uint64 a, b;
    while(scanf("%llu %llu", &a, &b) == 2)
        printf("%llu\n", a >b ? a - b : b - a);

    return 0;
}
