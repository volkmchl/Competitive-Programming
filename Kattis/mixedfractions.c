#include <stdio.h>

int main(){
    while(1){
        int a,b;
        scanf("%d %d\n", &a,&b);
        if(a == 0 && b == 0) break;
        int division = a/b;
        int remainder = a-(b*(division));
        printf("%d %d / %d\n", division, remainder, b);
    }
}
