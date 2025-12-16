#include <stdio.h>
#include <conio.h>
#include <windows.h>

#define KEY_UP 72
#define KEY_DOWN 80
#define KEY_HOME 71
#define KEY_ESC 27
#define KEY_ENTER 13
#define KEY_EXTENDED 224
#define NEW_OPTION 0
#define DISPLAY_OPTION 1
#define EXIT_OPTION 2

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
void setColor(WORD color)
{
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color);
}
int main() {


    char* menu[] = { "New", "Display", "Exit" };
    int currentElement = 0;
    int n = 3;
    int key;
    int terminated = 0;

    while (!terminated) {
        system("cls");
        for (int i = 0; i < n; i++) {
            gotoxyCenter(0, i);
            if (i == currentElement) {
                setColor(BACKGROUND_GREEN | FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE | FOREGROUND_INTENSITY);
                printf("%s\n", menu[i]);
                setColor(FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE);
            }
            else
                printf("%s\n", menu[i]);
        }

        key = _getch();
        switch (key) {
        case KEY_EXTENDED:
            key = _getch();
            switch (key) {
            case KEY_UP:
                currentElement--;
                if (currentElement < 0) currentElement = 2;
                break;
            case KEY_DOWN:
                currentElement++;
                if (currentElement >= n) currentElement = 0;
                break;
            }
            break;
        case KEY_ENTER:
            system("cls");
            gotoxyCenter(0, 0);
            switch (currentElement) {
            case NEW_OPTION:
                printf("New selected\n");
                gotoxyCenter(0, 1);
                printf("Press any key to go back to the menu...");
                _getch();
                break;
            case DISPLAY_OPTION:
                printf("Display selected\n");
                gotoxyCenter(0, 1);
                printf("Press any key to go back to the menu...");
                _getch();
                break;
            case EXIT_OPTION:
                printf("Exit selected\n");
                terminated = 1;
                break;
            }
            break;
        case KEY_ESC:
            system("cls");
            gotoxyCenter(0, 0);
            printf("Esc key pressed");
            terminated = 1;
            break;
        case KEY_HOME:

            break;
        }

    }

    return 0;
}
