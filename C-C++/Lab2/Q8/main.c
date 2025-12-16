#include <stdio.h>
#include <conio.h>
#include <windows.h>

void gotoxy(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void gotoxyCenter(int x, int y) {
    CONSOLE_SCREEN_BUFFER_INFO csbi;
    int columns, rows;

    GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &csbi);
    columns = csbi.srWindow.Right - csbi.srWindow.Left + 1;
    rows = csbi.srWindow.Bottom - csbi.srWindow.Top + 1;

    int centerX = columns / 2 - 10;
    int centerY = rows / 2;
    gotoxy(centerX + x, centerY + y);
}

int main(void)
{
    int rows = 3, cols = 4;
    int matrix[3][4] = { 0 };
    float colSum[4] = { 0 };
    int rowSum;
    int i, j;

    int startX = -25;
    int startY = -5;
    _getch();
    gotoxyCenter(startX + 5, startY);
    for (j = 1; j <= cols; j++)
        printf("%6d", j);
    printf("%6s", "Sum");

    gotoxyCenter(startX + 5, startY + 1);
    for (j = 1; j <= cols; j++)
        printf("%6c", '*');

    for (i = 1; i <= rows; i++)
    {
        gotoxyCenter(startX, startY + 1 + i);
        printf("%2d *", i);
    }
    gotoxyCenter(startX-2, startY + 5);
    printf("%6s","Avg");
    for (i = 0; i < rows; i++)
    {
        rowSum = 0;
        for (j = 0; j < cols; j++)
        {
            gotoxyCenter(startX + 10 + (j * 6), startY + 2 + i);
            scanf_s("%d", &matrix[i][j]);
            rowSum += matrix[i][j];
            colSum[j] += matrix[i][j];
            if (i == rows - 1) {
                gotoxyCenter(startX + 10 + (j * 6), startY + 5);
                printf("%4.2f", colSum[j] / rows);
            }
        }
        gotoxyCenter(startX + 5 + (j * 6), startY + 2 + i);
        printf("%6d", rowSum);
    }
    gotoxyCenter(startX + 10 + (j * 6), startY + 6);
    printf("\n\n");
    return 0;
}
