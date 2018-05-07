import java.util.*;

//prob id: 327A, complexity N^2

public class flippinggame {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            dp[0][0] += array[i];
        }



        dp[0][0] += array[0] == 0 ? 1 : -1;
        int MAX = dp[0][0];

        for(int i = 1; i < n; i++){
            dp[i][i] = dp[i-1][i-1] + (array[i-1] == 1 ? 1 : -1);
            dp[i][i] += array[i] == 0 ? 1 : -1;
            MAX = Math.max(dp[i][i], MAX);
        }


        for(int left = 0; left < n; left++){
            for(int right = left+1; right < n; right++){
                dp[left][right] = dp[left][right-1] + (array[right] == 0 ? 1 : -1);
                MAX = Math.max(dp[left][right], MAX);
            }
        }

        System.out.println(MAX);
    }
}
