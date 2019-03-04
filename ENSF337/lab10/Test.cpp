
#include <iostream>
#include <assert.h>
using namespace std;
#include <vector>
#include <string>

int a;
int main() {
//     vector <int> v1 = {11,23,99};
//     vector <int> v2 = {3};
//     v2 = v1;
//     for(int i = 0; i < (int)v2.size(); i++)
//     cout << v2.at(i) << " ";
//     return 0;

// string s1 = "893";
// s1 += "99";
// cout << s1.at(2) - s1.at(4);

// cout << a <<"\n";
// a = 1;
// cout << a;

char s1[] = "\0\0\0";
const char *s2 = s1;
const char *&s3 = s2;
*s1 = 'M';
cout << s1;

}

