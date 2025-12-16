#include <stdio.h>
#include <windows.h>

void gotoxy(int x, int y) {
    COORD coord = { x, y };
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void getScreenSize(int* width, int* height) {
    CONSOLE_SCREEN_BUFFER_INFO csbi;
    if (GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &csbi)) {
        *width = csbi.srWindow.Right - csbi.srWindow.Left + 1;
        *height = csbi.srWindow.Bottom - csbi.srWindow.Top + 1;
    }
    else {
        *width = 80;
        *height = 25;
    }
}

int main() {
    _getch();
    int n;
    printf("Enter odd number for magic box size: ");
    scanf_s("%d", &n);
    int width, height;
    getScreenSize(&width, &height);
    int rowSize = height / n;
    int colSize = width / n;
    int currentRow = 0;
    int currentCol = n / 2;



    for (int num = 1; num <= n * n; num++) {
        gotoxy(currentCol * colSize, currentRow * rowSize+1);
        printf("%d", num);

        if (num % n == 0) {
            currentRow = (currentRow + 1 == n) ? 0 : currentRow + 1;
        }
        else {
            currentRow = (currentRow - 1 < 0) ? n - 1 : currentRow - 1;
            currentCol = (currentCol - 1 < 0) ? n - 1 : currentCol - 1;
        }

    }

    return 0;
}
