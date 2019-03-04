#include <stdio.h>
#include <stdlib.h>

void get_user_input(double* distance, double* speed);
void travel_time_hours_and_minutes(double distance, double speed, double *hours, double *minutes);
void display_info(double distance, double speed, double hour, double minutes);

int main(void)
{
	double s, v, h, m;
	get_user_input(&s ,&v);
	travel_time_hours_and_minutes(s ,v ,&h ,&m);
	display_info(s ,v ,h ,m);
	return 0;
}

void get_user_input(double* distance, double* speed)
{
	int test_s = 0;
	int test_v = 0;
	int n = 0;
	int n2 = 0;
	printf("\nPlease enter a distance in km: ");
	n = scanf("%lf", &*distance);
	if(n ==1)
	{
		test_s = fgetc(stdin);
		if (test_s != 10)
		{
			printf("Invalid Input ... Terminating Program\n");
			exit(1);
		}
	}
	printf("\nNow enter the vehicle's average speed (km/hr): ");
	n2 = scanf("%lf", &*speed);
	if(n2 == 1)
	{
		test_v = fgetc(stdin);
		if (test_v != 10)
		{
			printf("Invalid Input ... Terminating Program\n");
			exit(1);
		}
	}
}

void travel_time_hours_and_minutes(double distance, double speed, double *hours, double *minutes)
{
	*hours = distance/speed;
	*minutes = (*hours - (int)*hours)*60;
}

void display_info(double distance, double speed, double hour, double minutes)
{
	printf("You have travel %lf (km) with a speed of %lf in %d hour (s) and %lf minute (s)\n",distance ,speed ,(int)hour ,minutes);
}