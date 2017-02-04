#include <stdio.h>

int min(int first, int second)
{
    if (first < second)    return first;
    return second;
}

int main()
{
    int d[1000][3] = { 0, };
    int n;
    int i;
    int price[3];

    scanf("%d", &n);

    scanf("%d %d %d", &d[0][0], &d[0][1], &d[0][2]);

    for (i = 1; i < n; i++) {
        scanf("%d %d %d", &price[0], &price[1], &price[2]);
 
        d[i][0] = min(d[i - 1][1], d[i - 1][2]) + price[0];
        d[i][1] = min(d[i - 1][0], d[i - 1][2]) + price[1];
        d[i][2] = min(d[i - 1][0], d[i - 1][1]) + price[2];
    }

    printf("%d\n", min(min(d[n - 1][0], d[n - 1][1]), d[n - 1][2]));

    return 0;
}


출처: http://ksj14.tistory.com/entry/1149-RGB거리 [:: ENJOY ::]
