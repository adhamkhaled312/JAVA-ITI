#include <stdio.h>

void swap(int &x, int &y) {
	int temp = x;
	x = y;
	y = temp;
}

void main() {
	int x = 5;
	int y = 10;
	swap(x, y);
	printf("x: %i, y: %i", x, y);
}
