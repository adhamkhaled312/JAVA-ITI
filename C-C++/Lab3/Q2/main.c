#include <stdio.h>

typedef struct employee {
    char name[20];
    int code;
    int salary;
    int bonus;
    int deduct;
} Employee;

void readEmployee(Employee* emp);
void printEmployee(const Employee* emp);

int main(void) {
    Employee e;

    readEmployee(&e);
    printEmployee(&e);

    return 0;
}

void readEmployee(Employee* emp) {
    printf("Enter employee data:\n");

    printf("Name: ");
    scanf_s("%s", emp->name, (unsigned)sizeof(emp->name));

    printf("Code: ");
    scanf_s("%d", &emp->code);

    printf("Salary: ");
    scanf_s("%d", &emp->salary);

    printf("Bonus: ");
    scanf_s("%d", &emp->bonus);

    printf("Deduction: ");
    scanf_s("%d", &emp->deduct);
}

void printEmployee(const Employee* emp) {
    printf("\n\n");
    printf("Name      : %s\n", emp->name);
    printf("Code      : %d\n", emp->code);
    printf("Salary    : %d\n", emp->salary);
    printf("Bonus     : %d\n", emp->bonus);
    printf("Deduction : %d\n", emp->deduct);
    printf("Net Salary: %d\n", emp->salary + emp->bonus - emp->deduct);
}
