//  power.cpp
//  Demonstrates a recursive function for raising a number
//  to an integer power.
//
// ENSF 337 - Fall 2018 - LAB 10

#include <cmath>
#include <cstdlib>
#include <iostream>
using namespace std;

int mult_count;
//  NOTE: mult_count is used by main, pow1 and pow2 to keep track of
//  the number of multiplications needed by pow1 or pow2.

double pow1(double x, int n);
// REQUIRES: 
//    n >= 0.
//    x to the n is not too small or too large to approximate as a double.  
// PROMISES:
//    Return value is an approximation to x to the n.

double pow2(double x, int n);
// REQUIRES: 
//    n >= 0.
//    x to the n is not too small or too large to approximate as a double.  
// PROMISES:
//    Return value is an approximation to x to the n.

int main()
{
  int k;
  double answer;

  cout << "This program will compute 10.0 to the k four different ways.\n";
  cout << "\nk must be >= 0.  Please enter k: ";
  cin >> k;
  if (cin.fail() || k < 0) {
    cout << "\nInput was not valid.  Program will be terminated.\n";
    exit(1);
  }

  // Show lots of digits in output of doubles.
  // On many computers, doubles are only precise to about
  // 17 decimal digits, so the final digit is probably junk.
  cout.precision(18);
  cout.setf(ios::showpoint);

  mult_count = 0;
  answer = pow1(10.0, k);
  cout << "pow1 says 10.0 to the power " << k
       << " is          " << answer << ".\n";
  cout << "pow1 used " << mult_count << " multiplications.\n\n";

  mult_count = 0;
  answer = pow2(10.0, k);
  cout << "pow2 says 10.0 to the power " << k
       << " is          " << answer << ".\n";
  cout << "pow2 used " << mult_count << " multiplications.\n\n";

  answer = pow(10.0, double(k));
  cout << "pow says 10.0 to the power " << k
       << " is           " << answer << ".\n\n";
  
  answer = exp( log(10.0) * k );
  cout << "Using exp and log, 10.0 to the power " << k
       << " is " << answer << ".\n\n";

  return 0;
}

double pow1(double x, int n)
{
  int i;
  double result = 1.0;

  for (i = 0; i < n; i++) {
    mult_count++;
    result *= x;
  }

  return result;
}


double pow2(double x, int n)
{
  double x_n_div_2;
  double result;

  switch( n ) {
  case 0:
    result = 1.0;
    break;
  case 1:
    result = x;
    break;
  default:
    x_n_div_2 = pow2(x, n / 2);

    // point one

    if (n % 2 == 0) {
      mult_count++;
      result = x_n_div_2 * x_n_div_2;
    }
    else {
      mult_count += 2;
      result = x_n_div_2 * x_n_div_2 * x;
    }
    break;
  }

  return result;
}
