#include <stdio.h>
#include <stdlib.h>

int main() {
	int age,n;
	double wage;
	char gender;
	
	printf("please enter your age, wage and gender: ");
	n = scanf("%d%lf%c",&age,&wage,&gender);
	
	if(n != 3)
	{
		printf("no");
		exit(1);
	}
	
	printf("age: %d wage: %6.3f gender: %c",age,wage,gender);
	return 0;
}