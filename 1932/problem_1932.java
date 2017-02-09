import java.io.*;
import java.util.*;

public class problem_1932 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i, j;
    int n = scanner.nextInt();
    int[][] before = new int[n][n];

    if(n > 500)
      return;


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
        if(j<=0) {
          before[i][j] += before[i-1][j];
        }
        else if(j == i-1) {
          before[i][j] += before[i-1][j-1];
        }
        else {
          before[i][j] = Math.max((before[i-1][j]+before[i][j]),(before[i][j]+before[i-1][j-1]));
        }
      }
    }

    int value = 0;
    for(int tmp = 0; tmp < n; tmp++)
      if(value < before[n-1][tmp] && before[n-1][tmp] !=0)
          value = before[n-1][tmp];


        System.out.println(value);
        return;

  }
}
