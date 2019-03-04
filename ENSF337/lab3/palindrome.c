/* File: palindrome.c
 *  ENSF 337 - Fall 2018
 *  Exercise E - Lab 3
 *  Abstract: The program receives a string (one or more words) and indicates
 *  if the string is a palindrome or not. Plaindrome is a phrase that spells the
 *  same from both ends
 */

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define SIZE 100


/* function prototypes*/
int is_palindrome (const char *str);
/* REQUIRES: str is pointer to a valid C string.
 * PROMISES: the return value is 1 if the string a is palindrome.*/


void strip_out(char *str);
/* REQUIRES: str points to a valid C string terminated with '\0'.
 * PROMISES: strips out any non-alphanumerical characters in str*/

int main(void)
{
    int p =0;
    char str[SIZE], temp[SIZE];
    
    fgets(str, SIZE, stdin);
    
    /* Remove end-of-line character if there is one in str.*/
    if (str[strlen(str) - 1] == '\n')
        str[strlen(str) - 1] = '\0';
    
    strcpy(temp,str);
    
    /* This loop is infinite if the string "done" never appears in the
     * input.  That's a bit dangerous, but OK in a test harness where
     * the programmer is controlling the input. */
    
    while(strcmp(str, "done") !=0) /* Keep looping unless str matches "done". */
    {
        
        strip_out(str);
        
        p = is_palindrome(str);
    
        
        if(!p)
            printf("\n \"%s\" is not a palindrome.", temp);
        else
            printf("\n \"%s\" is a palindrome.", temp);
        
        fgets(str, SIZE, stdin);
        
        /* Remove end-of-line character if there is one in str.*/
        if(str[strlen(str) - 1] == '\n')
            str[strlen(str) - 1]= '\0';
        strcpy(temp, str);
    }
    
    return 0;
}

void strip_out(char *str)
{
    char alphanum[256];
    int i;
    int k = 0;
    for(i=0; str[i];i++)
    {
        if((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z') || (str[i] >= '0' && str[i] <= '9'))
        {
            alphanum[k] = str[i];
            //printf("%c", alphanum[k]);
            k++;
        }
    }
    alphanum[k] = '\0';
  //printf("%s", alphanum);
    for(int ix=0;ix<strlen(alphanum);ix++)
  {
    str[ix] = alphanum[ix];
  }
 // printf("%s", str);
  str[strlen(alphanum)] = '\0';
    return;
}

int is_palindrome (const char *str)
{
    int correct = 0;
    char reverse[strlen(str)];
    char ch;
    char chr;
    for(int i=0, j=strlen(str); str[i];i++, j--)
    {
          reverse[i] = str[j-1];  
         // printf("%c", reverse[i]);
    }
        //printf("%s", reverse);
    for(int j=0;str[j];j++)
    {
        if( str[j] >= '0' && str[j] <= '9')
        {
            if(str[j] == reverse[j])
                correct++;
        }
        else 
        {
            ch = str[j];
            chr = reverse[j];
            if(ch >= 'A' && ch <= 'Z')
                ch = ch +32;
            if(chr >= 'A' && chr <= 'Z')
                chr = chr +32;
            if(ch == chr)
                correct++;
        }
        
    }
    if(correct == strlen(str))
    {
        return 1;
    }

    return 0;
}



