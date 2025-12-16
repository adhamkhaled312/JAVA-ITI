#include <stdio.h>

char* myStrcpy(char* dest, const char* src) {
    if (NULL == dest || NULL == src)
    {
        printf("NULL POINTER\n");
    }
    else
    {
        char* destTemp = dest;
        char* srcTemp;
        int size = strlen(src);
        for (srcTemp = src; srcTemp < src + size; srcTemp++)
        {
            *destTemp++ = *srcTemp;
        }
        *destTemp = '\0';
    }
    return dest;
}

void main(void) {
    char str1[] = "adham";
    char str2[6];

    myStrcpy(str2, str1);
    printf("Str1: %s\n", str1);
    printf("Str2: %s\n", str2);
}