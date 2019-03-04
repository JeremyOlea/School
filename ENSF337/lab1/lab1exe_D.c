/*
*  lab1exe_D.c
*  ENSF - Fall 2018 Lab 1, exercise D
*  Completed by: Student Name
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define G 9.8   /* gravitation acceleration 9.8 m/s^2 */
#define PI 3.141592654

double degree_to_radian(double d);
double Projectile_travel_time(double a, double v);
double Projectile_travel_distance(double a, double v);
void create_table(double v);

void create_table(double v)
{
	int i;
	double a = 0, d, t;
	printf("Angle\t\tt\t\td\n");
	printf("(deg)\t\t(sec)\t\t(m)\n");
	for(i=0;i<19;i++)
	{
		t = Projectile_travel_time(a,v);
		d = Projectile_travel_distance(a,v);
		printf("%lf\t%lf\t%lf\n",a, t, d);
		a = a + 5;
	}
	
}

double degree_to_radian(double d)
{
	return(d*PI/180);
}

double Projectile_travel_time(double a, double v)
{
	double t;
	double b = degree_to_radian(a);
	t = (2*v*sin(b))/G;
	return t;
}

double Projectile_travel_distance(double a, double v)
{
	double d;
	double b = degree_to_radian(a);
	d = (v*v/G)*sin(2*b);
	return d;
}


int main(void)
{
    int n;
    double velocity;
    
    printf ("please enter the velocity at which the projectile is launched (m/sec): ");
    n = scanf("%lf" ,&velocity);
    
    if(n != 1)
    {
        printf("Invlid input. Bye...");
        exit(1);
    }
    
    while (velocity < 0 )
    {
        printf ("please enter a positive number for velocity: ");
        n = scanf("%lf", &velocity);
        if(n != 1)
        {
            printf("Invlid input. Bye...");
            exit(1);
        }
    }
    
    create_table(velocity);
    
    return 0;
}



/* UNCOMMENT THE CALL TO THE create_table IN THE main FUNCTION, AND COMPLETE THE PROGRAM */

