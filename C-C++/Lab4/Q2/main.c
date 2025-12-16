#include <stdio.h>
#include <stdlib.h>

int *readArray(int size) {
	printf("Enter the size of the array : ");
	scanf_s("%d", size);
	printf("\nEnter the elements of the array : ");
	int* arr = (int*)malloc(*size * sizeof(int));
	for (int i = 0; i < *size; i++) {
		scanf_s("%d", &arr[i]);
	}
	return arr;
}
int printArray(int* arr, int size) {
	for (int i = 0; i < size; i++) {
		printf("arr[%d] = %d\n",i,arr[i]);
	}
}
void main(void) {
	int size;
	int* arr = readArray(size);
	printArray(arr,size);
	free(arr);

}