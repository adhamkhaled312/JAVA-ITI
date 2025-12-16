#include<stdio.h>

void main(void) {
	int input;
	int sum =0;
	while (sum < 100) {
		scanf_s("%i", &input);
		sum += input;
		printf("The current sum = %i\n", sum);
	}
}