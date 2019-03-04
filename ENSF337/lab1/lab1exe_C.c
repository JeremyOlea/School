
/* lab1exe_C.c
 * ENSF 337 Fall 2018 Lab 1 Exercise C
 *
 * Completed by:    Michael Jeremy Olea
 * Lab Section:     B01
 */

#include <stdio.h>
#include <stdlib.h>

int are_the_same(int x, int y, int z);
/* REQUIRES: x, y, and z are positive integers. 
 * PROMISES: returns 1 if all three artument are equal. Otherwise returns zero.
 */

int non_decreasing(int x, int y, int z);
/* REQUIRES: x, y, and z are positive integers.
 * PROMISES: returns 1, if: x <= y <= z. Otherwise returns zero.
 */
 

int main(void)
{
    int a, b, c, nscan;
    do{
        
        /* Get values for a, b, and c from user.    */
        /* Quit if the user enters garbage.     */
        printf("\nPlease enter a positive value for the int variable a: ");
        nscan = scanf("%d", &a);
        if (nscan != 1) {
            printf("Your input could not be converted to an int.  I quit.\n\n");
            exit(1);
        }
        
        if(a < 0) break;
        
        printf("\nPlease enter a positive value for the int variable b: ");
        nscan = scanf("%d", &b);
        if (nscan != 1) {
            printf("Your input could not be converted to an int.  I quit.\n\n");
            exit(1);
        }
        if(b < 0) break;
        
        printf("\nPlease enter a positive value for the int variable c: ");
        nscan = scanf("%d", &c);
        if (nscan != 1) {
            printf("Your input could not be converted to an int.  I quit.\n\n");
            exit(1);
        }
        
        if(c < 0) break;
       
        printf("The numbers are: a = %d, b = %d, c = %d.", a, b, c);

        if(are_the_same(a, b, c))
           printf(" They are the same\n\n");
        else
            printf(" They are NOT the same\n\n");
        
        
        // The following 4 lines must be uncommented by the students when testing
        // funciton non_decreasing
        
         if(non_decreasing (a, b, c))
            printf(" And they are in non-decreasing order\n\n");
         else
            printf(" And they are NOT in non-decreasing order\n\n");
        
    } while(1);
    
    printf("\nProgram terminated....");

    return 0;
}

int are_the_same(int x, int y, int z)
{
    if (x == y && x == z && y == z)
        return 1;
    return 0;
}

int non_decreasing(int x, int y, int z)
{
    if (x <= y && y <= z)
		return(1);
	else
        return 0;
}
