#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
    int stringCount;

    printf("Enter the number of strings: ");
    scanf_s("%d", &stringCount);
    getchar();

    char** arr = (char**)malloc(stringCount * sizeof(char*));
    int* stringSizes = (int*)malloc(stringCount * sizeof(int));

    for (int i = 0; i < stringCount; i++) {
        int size;
        printf("Enter the size of string %d: ", i + 1);
        scanf_s("%d", &size);
        getchar();

        stringSizes[i] = size;
        arr[i] = (char*)malloc((size + 1) * sizeof(char));
    }

    for (int i = 0; i < stringCount; i++) {
        printf("Enter string %d: ", i + 1);
        if (fgets(arr[i], stringSizes[i] + 1, stdin) != NULL) {
            int len = strlen(arr[i]);
            if (len > 0 && arr[i][len - 1] == '\n') {
                arr[i][len - 1] = '\0';
            }
            else {
                int c;
                while ((c = getchar()) != '\n');
            }
        }
    }

    for (int i = 0; i < stringCount; i++) {
        printf("String %d: %s\n", i + 1, arr[i]);
    }

    for (int i = 0; i < stringCount; i++)
        free(arr[i]);
    free(arr);
    free(stringSizes);

    return 0;
}
