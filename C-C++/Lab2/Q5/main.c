#include <stdio.h>
#include <windows.h>

void gotoxy(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void gotoxyCenter(int x, int y)
{
    CONSOLE_SCREEN_BUFFER_INFO csbi;
    int columns, rows;

    GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &csbi);
    columns = csbi.srWindow.Right - csbi.srWindow.Left + 1;
    rows = csbi.srWindow.Bottom - csbi.srWindow.Top + 1;

    int centerX = columns / 2;
    int centerY = rows / 2;
    gotoxy(centerX + x, centerY + y);
}

int main()
{
    int n = 10;
    int startX = -30;
    int startY = -5;

    gotoxyCenter(startX + 5, startY + 2);
    printf("    ");
    for (int i = n; i >= 1; i--)
        printf("%4d", i);
    gotoxyCenter(startX + 5, startY + 3);
    printf("    ");
    for (int i = 1; i <= n; i++)
        printf("%4c", '*');
    for (int i = n; i >= 1; i--)
    {
        gotoxyCenter(startX + 5, startY + 4 + (n-i));
        printf("%2d *", i);
        for (int j = n; j >= 1; j--)
            printf("%4d", i * j);
    }

    gotoxyCenter(startX, startY + n + 4);
    printf("\n");
    return 0;
}
