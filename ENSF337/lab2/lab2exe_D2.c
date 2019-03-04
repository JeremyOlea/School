/*
 *
 * lab2exe_D2.c
 * ENSF 337 - Lab 2 - Execise D - Part II
 *  This program lets you examine the behaviour of simple scanf calls
 *  in response to input errors.
 */

#include <stdio.h>

int main(void)
{
  int i = 333;
  double d = 1234.5;
  int n;

  printf("Please enter an integer followed by a double: ");
  n = scanf("%d%lf", &i, &d);
  printf("n is %d.\n", n);
  printf("i is %d.\n", i);
  printf("d is %f.\n", d);

  return 0;
}


//n=2 i=12 d=0.56
//n=2 i=5 d=0.12
//n=1 i=12 d=1234.5
//n=0 i=333 d=1234.5
//n=1 i=5 d=1234.5
//n=2 i=13 d=67.0
