//  largest.cpp
//  Demonstrates a recursive function for finding the largest
//  element in an array.
//
// ENSF 337 - Fall 2018 - LAB 10G


#include <iostream>
#include <assert.h>
using namespace std;



int largest_element(const int *a, int begin, int past_end);
// REQUIRES
//    begin >= 0.  begin < past_end.
//    Array elements a[begin] ... a[past_end - 1] exist.
// PROMISES
//    Returns largest value among a[begin] ... a[past_end - 1].

int main()
{
  int arr[] = { -5, -10, -16, -3, -7 };
  int largest;

  largest = largest_element( arr, 0, sizeof(arr) / sizeof(int) );
  cout << "Largest element in arr is " << largest << ".\n";
  const char* pc = "abc";
    char c;
    char *const cp = * c;
  return 0;
}

int largest_element(const int *a, int begin, int past_end)
{
  int result;
  int mid;
  int left_large;
  int right_large;

  assert(begin >= 0);
  assert(begin < past_end);
  
  if (past_end - begin == 1)
    result = a[begin];
  else {
    mid = (begin + past_end) / 2; 
    left_large = largest_element(a, begin, mid);
    right_large = largest_element(a, mid, past_end);
    if (left_large >= right_large)
      result = left_large;
    else
      result = right_large;
  }

  // point one

  return result;
}
