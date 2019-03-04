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
    char alphanum[SIZE];
    char *alphanumptr = alphanum;
    char *ptr = str;
   // char *alphastart = alphanum;
    while(*ptr)
    {
        if((*ptr >= 'a' && *ptr <= 'z') || (*ptr >= 'A' && *ptr <= 'Z') || (*ptr >= '0' && *ptr <= '9'))
        {
           *alphanumptr = *ptr;
           alphanumptr++;
        }
        ptr++;
    }
   *alphanumptr = '\0';
   strcpy(str, alphanum);
   


}

int is_palindrome (const char *str)
{
    int i=0,len = strlen(str);
    int j = len-1;
    char ch,chr;
   while(str[i])
   {
        ch = str[i];
        chr = str[j];
          if(ch >= 'A' && ch <= 'Z')
            ch += 32;
          if(chr >= 'A' && chr <= 'Z')
            chr += 32;
          if(chr != ch)
            return 0;
        i++;
        j--;
   }
   return 1;
}



    // char ch, chr,*end,*start = str;
    // end = &str[strlen(str)-1];
    // while(*start)
    // {
    //       ch = *start;
    //       chr = *end;
    //       if(ch >= 'A' && ch <= 'Z')
    //         ch += 32;
    //       if(chr >= 'A' && chr <= 'Z')
    //         chr += 32;
    //       if(chr != ch)
    //         return 0;

    //     end--;
    //     start++;
    // }
    // return 1;

