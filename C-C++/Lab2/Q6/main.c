#include <stdio.h>
#include <stdlib.h>
void main(void) {
	int n;
	printf("Enter the size of the array: ");
	scanf_s("%d", &n);
	printf("Enter the elements of the array : ");
	int *arr = (int *)malloc(n * sizeof(int));
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &arr[i]);
	}
	for (int i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}
}