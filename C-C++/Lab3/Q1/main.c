#include <stdio.h>
#include <conio.h>
#include <windows.h>
#include <string.h>

#define KEY_UP 72
#define KEY_DOWN 80
#define KEY_HOME 71
#define KEY_ESC 27
#define KEY_ENTER 13
#define KEY_RIGHT 77
#define KEY_LEFT 75
#define KEY_EXTENDED_1 224
#define KEY_EXTENDED_2 -32
#define NEW_OPTION 0
#define DISPLAY_OPTION 1
#define EXIT_OPTION 2
#define MAX_EMPLOYEE_COUNT 5

void gotoxy(int x, int y);
void gotoxyCenter(int x, int y);
void setColor(WORD color);
void readEmployee(void);
void displayEmployees(void);


typedef struct employee {
    char name[50];
    int code;
    int salary;
    int bonus;
    int deduct;
} Employee;
Employee employeeData[MAX_EMPLOYEE_COUNT];
int employeeCount;

int main() {


    char* menu[] = { "New", "Display", "Exit" };
    int currentElement = 0;
    int n = 3;
    int key;
    int terminated=0;

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
        case KEY_EXTENDED_1:
        case KEY_EXTENDED_2:
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
                if (employeeCount == MAX_EMPLOYEE_COUNT - 1) printf("Maximum number of employees reached.");
                else readEmployee();
                gotoxyCenter(0, 1);
                printf("Press any key to go back to the menu...");
                _getch();
                break;
            case DISPLAY_OPTION:
                if (employeeCount == 0) {
                    printf("No employees to display.");
                    gotoxyCenter(0, 1);
                    printf("Press any key to go back to the menu...");
                    _getch();

                }
                else displayEmployees();
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
void readEmployee(void) {
    char name[50];
    int code;
    int salary;
    int bonus;
    int deduct;
    char save;

    gotoxyCenter(0, 0);
    printf("%s", "Name  : ");
    gotoxyCenter(0, 1);
    printf("%s", "Code  : ");
    gotoxyCenter(0, 2);
    printf("%s", "Salary: ");
    gotoxyCenter(0, 3);
    printf("%s", "Bonus : ");
    gotoxyCenter(0, 4);
    printf("%s", "Deduct: ");

    gotoxyCenter(8, 0);
    scanf_s("%s", name, (unsigned)sizeof(name));
    gotoxyCenter(8, 1);
    scanf_s("%d", &code);
    gotoxyCenter(8, 2);
    scanf_s("%d", &salary);
    gotoxyCenter(8, 3);
    scanf_s("%d", &bonus);
    gotoxyCenter(8, 4);
    scanf_s("%d", &deduct);
    gotoxyCenter(0, 5);
    printf("Press s to save, z to undo\n");

    save = _getch();
    switch (save) {
    case 's':
        strcpy_s(employeeData[employeeCount].name, sizeof(name), name);
        employeeData[employeeCount].code = code;
        employeeData[employeeCount].salary = salary;
        employeeData[employeeCount].bonus = bonus ;
        employeeData[employeeCount].deduct = deduct;
        employeeCount++;
        system("cls");
        gotoxyCenter(0, 0);
        printf("Employee saved successfully");
        break;
    case 'z':
        system("cls");
        gotoxyCenter(0, 0);
        printf("Employee is not saved");
        break;
    }
;    
}

void displayEmployees(void) {
    int currentEmployee = 0;
    char choice;
    while (1) {
        system("cls");
        gotoxyCenter(0, 0);
        printf("Name   : %s", employeeData[currentEmployee].name);
        gotoxyCenter(0, 1);
        printf("Code   : %d", employeeData[currentEmployee].code);
        gotoxyCenter(0, 2);
        printf("Net Salary: %d", employeeData[currentEmployee].salary + employeeData[currentEmployee].bonus 
                                            - employeeData[currentEmployee].deduct);
        gotoxyCenter(-15, 4);
        printf("Press > for next employee, < for previous Employee, z to exit");
        choice = _getch();

        if (choice == KEY_EXTENDED_1 || choice == KEY_EXTENDED_2) {
            choice = _getch();  

            switch (choice) {
            case KEY_RIGHT:       
                currentEmployee = (currentEmployee + 1) % employeeCount;
                break;

            case KEY_LEFT:       
                currentEmployee--;
                if (currentEmployee < 0)
                    currentEmployee = employeeCount - 1;
                break;
            }
        }
        else if (choice == 'z') {
            return; 
        }

    }
}