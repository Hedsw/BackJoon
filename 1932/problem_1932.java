import java.io.*;
import java.util.*;

public class problem_1932 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int i, j;
    int n = scanner.nextInt();

    int[][] before = new int[n][n];

    for(i = 0; i < n; i++) {
      for(j = 0; j <= i; j++) {
        before[i][j] = scanner.nextInt();
      }
    }

    if(n == 1) {
      System.out.println(before[0][0]);
      return;
    }

    for(i = 0; i < n; i++) {
      for(j = 0; j < i; j++) {
        if(j==0)
          before[i][j] += before[i-1][j];
        else if(j == i)
          before[i][j] += before[i-1][j-1];
        else
          before[i][j] = Math.max((before[i-1][j]+before[i][j]),(before[i-1][j]+before[i][j+1]));
      }
    }

    int v = 0;
    for(int tmp = 0; tmp < n; tmp++)
      if(v < before[n-1][tmp])
        v = before[n-1][tmp];


        System.out.println(v);
        return;

  }
}
