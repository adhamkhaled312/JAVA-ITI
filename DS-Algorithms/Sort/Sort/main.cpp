#include <iostream>
#include <algorithm>
using namespace std;
void selectionSort(int arr[], int n);
void bubbleSort(int arr[], int n);
void mergeSort(int arr[], int l, int r);

int main() {
	int arr[] = { 1,4,12,3,5,9,6 };
	int size = sizeof(arr) / sizeof(arr[0]);
	mergeSort(arr, 0,size-1);
	for (int i = 0; i < size; i++) {
		cout << arr[i] << " ";
	}
}

void selectionSort(int arr[], int n) {
	for (int i = 0; i < n; i++) {
		int min = i;
		for (int j = i+1; j < n; j++) {
			if (arr[j] < arr[min]) min = j;
		}
		swap(arr[i], arr[min]);
	}
}

void bubbleSort(int arr[], int n) {
	for (int i = 0; i < n; i++) {
		int swapped = 0;
		for (int j = 0; j < n-i-1; j++) {
			if (arr[j] > arr[j + 1]) {
				swap(arr[j], arr[j + 1]);
				swapped = 1;
			}
		}
		if (!swapped) break;
	}
}
void merge(int arr[], int l, int m, int r) {
	const int size1 = m - l + 1;
	int size2 = r - m;
	int* leftArr = new int[size1];
	int* rightArr = new int[size2];

	for (int i = 0; i < size1; i++) {
		leftArr[i] = arr[l + i];
	}
	for (int i = 0; i < size2; i++) {
		rightArr[i] = arr[m + 1 + i];
	}

	int i = 0;
	int j = 0;
	int k = l;
	while (i < size1 && j < size2) {
		if (leftArr[i] < rightArr[j]) arr[k++] = leftArr[i++];
		else arr[k++] = rightArr[j++];
	}

	while (i < size1) arr[k++] = leftArr[i++];
	while (j < size2) arr[k++] = rightArr[j++];

	delete[] leftArr;
	delete[] rightArr;
}
void mergeSort(int arr[], int l, int r) {
	if (l < r) {
		int mid = l + (r - l) / 2;

		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);

		merge(arr,l,mid,r);
	}
}