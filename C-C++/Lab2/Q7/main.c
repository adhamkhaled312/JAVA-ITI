#include <stdio.h>
void main(void) {
	int arr[10];
	printf("Enter the elements of the array: ");
	for (int i = 0; i < 10; i++) {
		scanf_s("%d", &arr[i]);
	}
	int min = arr[0], max=arr[0];
	for (int i = 1; i < 10; i++) {
		if (arr[i] > max) max = arr[i];
		if (arr[i] < min) min = arr[i];
	}
	printf("Minimum value : %i\n", min);
	printf("Maximum value : %i\n", max);

}