#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int linearSearchInt(int arr[], int n, int key);
int sequentialSearchCStr(const char* arr[], int n, const char* key);
int binarySearchInt(int arr[], int n, int key);
int binarySearchString(const char* arr[], int n, const char* key);

int main() {
	int arrInt[] = { 1, 3, 7, 9 ,10 };
	int nInt = sizeof(arrInt) / sizeof(arrInt[0]);
	int keyInt = 9;

	cout << "Linear search (int) index: " << linearSearchInt(arrInt, nInt, keyInt) << endl;

	cout << "Binary search (int) index: " << binarySearchInt(arrInt, nInt, keyInt) << endl;

	const char* arrStr[] = { "apple", "banana", "grape", "orange" };
	int nStr = sizeof(arrStr) / sizeof(arrStr[0]);
	const char* keyStr = "banana";

	cout << "Sequential search (cstring) index: " << sequentialSearchCStr(arrStr, nStr, keyStr) << endl;

	cout << "Binary search (cstring) index: " << binarySearchString(arrStr, nStr, keyStr) << endl;

	return 0;
}

int linearSearchInt(int arr[], int n, int key) {
	for (int i = 0; i < n; i++) {
		if (arr[i] == key) return i;
	}
	return -1;
}

int sequentialSearchCStr(const char* arr[], int n, const char* key) {
	for (int i = 0; i < n; i++) {
		if (strcmp(arr[i], key) == 0) return i;
	}
	return -1;
}

int binarySearchInt(int arr[], int n, int key) {
	int l = 0;
	int r = n - 1;
	while (l <= r) {
		int mid = l + (r - l) / 2;
		if (arr[mid] == key) return mid;
		else if (arr[mid] < key) l = mid + 1;
		else  r = mid - 1;
	}
	return -1;
}

int binarySearchString(const char* arr[], int n, const char* key) {
	int l = 0;
	int r = n - 1;
	while (l <= r) {
		int mid = l + (r - l) / 2;
		int comp = strcmp(arr[mid], key);
		if (comp == 0) return mid;
		else if (comp < 0) l = mid + 1;
		else  r = mid - 1;
	}
	return -1;
}