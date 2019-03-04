

#include <stdio.h>

// Students should add the defintion of macro LARGEST_OF_THREE here.
#define LARGEST_OF_THREE(x,y,z) (x > z && x > y ? (x) : y > z && y > x ? (y) : z > x && z > y ? (z) : (x))

int main(void)
{
    double x = 0.300, y = 0.500, z= 0.999;
    double largest = LARGEST_OF_THREE(x, y, z);
    printf("\nTest 1: the largest value is %f", largest);
    printf("\nTEST 2: the lagerst value is %f", LARGEST_OF_THREE(345, 99.8, 10));
    printf("\nTEST 3: the lagerst value is %f", LARGEST_OF_THREE(4, 9.8, 10.0));
    printf("\nTEST 4: the lagerst value is %f", LARGEST_OF_THREE(4.5, 4.5, 4.5));
    printf("\nTEST 5: the lagerst value is %f", LARGEST_OF_THREE(0.0, 0.0, 0.0));
    printf("\nTEST 6: the lagerst value is %f",
                                        LARGEST_OF_THREE(x * 10, y * 2 , z * 3));
    return 0;
}
