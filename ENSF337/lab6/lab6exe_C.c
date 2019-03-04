// ENSF 337 - fall 2018 - lab 6 - exercise C
// M. Moussavi
// lab6exe_C.c

#include <stdio.h>
#include <stdlib.h>
#include "lab6exe_C.h"

int main(void) {
    char input_filename[30] = "lab6exe_C.txt";
    char output_filename[30]= "lab6exe_C_output.txt";
    IntVector intVec;
    intVec.number_of_data = 0;
    
    read_text_file(&intVec, input_filename);
    
    display_single_column(&intVec);
    
    display_multiple_column(&intVec, 4, output_filename);
    
    return 0;
}

void read_text_file (IntVector* vec, const char* input_filename){
    int nscan;
    FILE *fp = fopen (input_filename, "r");
    
    if(fp == NULL){
        fprintf(stdout, "Sorry cannot open the text file %s.\n", input_filename);
        exit(1);
    }
    
    do{
        nscan = fscanf(fp,"%d", &vec->storage[vec->number_of_data]);
        if(nscan == 1)
            (vec->number_of_data)++;
        else if (nscan != EOF){
            fprintf(stderr, "Invalid data in %s.\n", input_filename);
            exit(1);
        }
    }while ((nscan != EOF) & (vec->number_of_data < MAX_CAPACITY));
    
    fclose(fp);
}

void display_single_column(const IntVector* intV){
    int i;
    for (i = 0; i < intV ->number_of_data; i++ )
        printf("%10d\n", intV ->storage[i]);
}

void display_multiple_column(const IntVector *intV, int col, const char* output_filename)
{
    FILE *fp = fopen (output_filename, "w");
    int i = 0;
    if(intV ->number_of_data < col)
    {
        while(intV ->number_of_data > i)
        {
            for(int j=0;j<intV -> number_of_data;j++)
            {
            fprintf(fp,"%10d", intV ->storage[i]);
            i++;
            }
        fprintf(fp,"\r\n");
        }
    }
    else{
        while(intV ->number_of_data > i)
        {
         for(int j=0;j<col;j++)
            {
            fprintf(fp,"%10d", intV ->storage[i]);
            i++;
            }
        fprintf(fp,"\r\n");
        }
    }
    fclose(fp);
}

