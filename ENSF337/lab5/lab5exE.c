// lab5exE.c
// ENSF 337- Fall 2018, Exercise E

#include "lab5exE.h"
#include <stdio.h>
#include <math.h>
#include<string.h>

int main(void)
{
    Point struct_array[10];
    int i;
    int position;
    
    populate_struct_array(struct_array, 10);
    
    printf("\nArray of Points contains: \n");
    
    for(i=0; i < 10; i++)
        display_struct_point(struct_array[i], i);
    
    
    printf("\nTest the search function");
    
    position = search(struct_array, "v0", 10);
    if(position != -1)
        printf("\nFound: struct_array[%d] contains %s", position,
               struct_array[position].label);
    else
        printf("\nstruct_array doesn't have label: %s.", "v0");
    
    position = search(struct_array, "E1", 10);
    if(position != -1)
        printf("\nFound: struct_array[%d] contains %s", position,
               struct_array[position].label);
    else
        printf("\nstruct_array doesn't have label: %s.", "E1");
    
    position = search(struct_array, "C5", 10);
    
    if(position != -1)
        printf("\nFound: struct_array[%d] contains %s", position,
               struct_array[position].label);
    else
        printf("\nstruct_array doesn't have label: %s.", "C5");
    
    position = search(struct_array, "B7", 10);
    if(position != -1)
        printf("\nFound: struct_array[%d] contains %s", position,
               struct_array[position].label);
    else
        printf("\nstruct_array doesn't have label: %s.", "B7");
    position = search(struct_array, "A9", 10);
    if(position != -1)
        printf("\nFound: struct_array[%d] contains %s", position,
               struct_array[position].label);
    else
        printf("\nstruct_array doesn't have label: %s.", "A9");
    position = search(struct_array, "E11", 10);
    if(position != -1)
        printf("\nFound: struct_array[%d] contains %s", position,
               struct_array[position].label);
    else
        printf("\nstruct_array doesn't have label: %s.", "E11");
    
    position = search(struct_array, "M1", 10);
    if(position != -1)
        printf("\nFound: struct_array[%d] contains %s", position,
               struct_array[position].label);
    else
        printf("\nstruct_array doesn't have label: %s.", "M1");
    
    printf("\n\nTesting the reverse function:");
    
    reverse(struct_array, 10);
    
    printf("\nThe reversed array is:");
    
    for(i=0; i < 10; i++)
        display_struct_point(struct_array[i], i);
    
    return 0;
}


void display_struct_point(const Point x , int i)
{
    printf("\nstruct_array[%d]: %s <%.2lf, %.2lf, %.2lf>\n",
           i, x.label, x.x, x.y, x.z);
}

void populate_struct_array(Point* array, int n)
{
    int i;
    char ch1 = 'A';
    char ch2 = '9';
    char ch3 = 'z';
    
    for( i = 0; i < 10; i++)
    {
        /* generating some random values to fill them elements of the array: */
        array[i].x = (7 * (i + 1) % 11) * 100 - i /2;
        array[i].y = (7 * (i + 1) % 11) * 120 - i / 3;
        array[i].z = (7 * (i + 1) % 11) * 150 - i /4;
        
        if(i % 2 == 0)
            array[i].label[0] = ch1++;
        else
            array[i].label[0] = ch3--;
        array[i].label[1] = ch2--;
        array[i].label[2] = '\0';
    }
}



int search(const Point* struct_array, const char* label, int n)
{
    // Students should complete the definiton of this function
    // NOTE: YOU ARE NOT ALLOWED TO USE LIBRARY FUNCTION strcmp IN THIS FUNCTION
    char copy[10];
    int i = 0;
    int length = 0;
    while(*label)
    {
        copy[i] = *label;
        label++;
        i++;
        length++;
    }
    copy[i] = '\0';
    for(int j = 0; j<n;j++)
    {
        int m = 0, correct = 0;
           while(copy[m] != '\0')
           {
               if((*struct_array).label[m] == copy[m])
               {
                    correct++;
               }
                m++;
           }
           if(correct == length)
           return j;

       struct_array++;
    }
    return -1;
}

void reverse (Point *a, int n)
{
    // Students should complete the definiton of this function
    Point temp;
    int j;
    for(int i=0; i<n/2;i++)
    {
        j = 0;
        while(a[i].label[j] != '\0')
        {
            temp.label[j] = a[i].label[j];
            j++;
        }
        temp.x = a[i].x;
        temp.y = a[i].y;
        temp.z = a[i].z;

        j = 0;
         while(a[i].label[j] != '\0')
        {
            a[i].label[j] = a[n-i-1].label[j];
            j++;
        }
        a[i].x = a[n-i-1].x;
        a[i].y = a[n-i-1].y;
        a[i].z = a[n-i-1].z;

        j = 0;
          while(a[n-i-1].label[j] != '\0')
        {
            a[n-i-1].label[j] = temp.label[j];
            j++;
        }
        a[n-i-1].x = temp.x;
        a[n-i-1].y = temp.y;
        a[n-i-1].z = temp.z;
    }
        
}

// strcpy(temp.label,a[i].label);
//         temp.x = a[i].x;
//         temp.y = a[i].y;
//         temp.z = a[i].z;

//         strcpy(a[i].label,a[n-i-1].label);
//         a[i].x = a[n-i-1].x;
//         a[i].y = a[n-i-1].y;
//         a[i].z = a[n-i-1].z;

//         strcpy(a[n-i-1].label,temp.label);
//         a[n-i-1].x = temp.x;
//         a[n-i-1].y = temp.y;
//         a[n-i-1].z = temp.z;
//     }