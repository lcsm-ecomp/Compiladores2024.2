#include <stdio.h>

int main() {
    int total,x,y;
    total = 0;
    y = 5000;
    while (y>0) {
       x=5000;
       while (x>0) {
          total = total + x+y;
          x = x - 1;
       }
       y = y - 1;
    }
    printf("total = %d\n",total);


}