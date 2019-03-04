

#include "read_input.h"

#include <math.h>
#include <string.h>
#include <stdio.h>

int read_real(char* digits, int n, double * num)
{
	if (get_string(digits, n) == EOF)
		return EOF;
	//printf("Input read");
	if (is_valid_double(digits))
	{
		*num = convert_to_double(digits);
		return 1;
	}

	return 0;

}


int is_valid_double(const char* digits)
{
	int valid = 1;
	int i;
	int decimal = 0;
	if (digits[0] == '+' || digits[0] == '-')
		i = 1;
	else
		i = 0;

	if (digits[i] == '\0')
		valid = 0;
	else
		while(digits[i] != '\0' && valid != 0)
		{
			if(digits[i] == '.')
				decimal++;
			if(decimal > 1)
				valid = 0;
			if((digits[i] < '0' || digits[i] > '9') && digits[i] != '.')
				valid = 0;
			i++;
		}

	return valid;

}


double convert_to_double(const char* digits)
{
	double sum = 0.0;
	double sum2 = 0.0;
	int i2 = 0;
	int i = 0;
	int negative = 0;
	if(digits[i] == '-')
	{
		i++;
		negative++;
	}
	if(digits[i] == '+')
		i++;
	while (digits[i] != '\0' && digits[i] != '.') {
		sum = 10 * sum + (digits[i] - '0');
		i++;
	}

	if (digits[i] != '\0')
	{
	
		i2 = i;
		while (digits[i2])
			i2++;

		i2--;
	
	    while(i2>i)
		{
			sum2 = (0.10 * sum2) + ((digits[i2] - '0') * 0.10);
		    i2--;
		}
	}
	if(negative == 1)
	sum = (sum + sum2)*(-1);
	else
	sum = sum +sum2; 

	return sum;
}