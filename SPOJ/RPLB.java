import java.util.*;
import java.io.*;

class RPLB{
    public static void main(String[] args) throws Exception{
        Parser sc = new Parser(System.in);

        int T = sc.nextInt();
        StringBuilder string = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = sc.nextInt();
            int MAX = sc.nextInt();

            int[] bush = new int[N];

            for(int i = 0; i < N; i++){
                bush[i] = sc.nextInt();
            }
            int[][] dp = new int[N+5][MAX+5];

            for(int i = 1; i <= MAX; i++){
                if(bush[0] <= i){
                    dp[0][i] = bush[0];
                }
            }

            for(int row = 1; row < N; row++){
                for(int col = 0; col <= MAX; col++){

                    if(col - bush[row] >= 0 && row >= 2){
                        if(dp[row-2][col-bush[row]] + bush[row] <= col){
                            dp[row][col] = Math.max(dp[row-2][col-bush[row]] + bush[row], dp[row-1][col]);
                        }
                    }
                    else{
                        if(bush[row] <= col){
                            dp[row][col] = Math.max(dp[row-1][col], bush[row]);
                        }
                        else{
                            dp[row][col] = dp[row-1][col];
                        }
                    }
                }
            }
            string.append("Scenario #" + t + ": " + dp[N-1][MAX] +"\n");

        }
        System.out.println(string);
    }

    public static void printArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 10; j < array[0].length; j += 10){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class Parser{
	   final private int BUFFER_SIZE = 1 << 16;

	   private DataInputStream din;
	   private byte[] buffer;
	   private int bufferPointer, bytesRead;

	   public Parser(InputStream in){
	      din = new DataInputStream(in);
	      buffer = new byte[BUFFER_SIZE];
	      bufferPointer = bytesRead = 0;
	   }

	   public int nextInt() throws Exception{
	      int ret = 0;
	      byte c = read();
	      while (c <= ' ') c = read();
	      boolean neg = c == '-';
	      if (neg) c = read();
	      do
	      {
	         ret = ret * 10 + c - '0';
	         c = read();
	      } while (c > ' ');
	      if (neg) return -ret;
	      return ret;
	   }

	   private void fillBuffer() throws Exception{
	      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	      if (bytesRead == -1) buffer[0] = -1;
	   }

	   private byte read() throws Exception{
	      if (bufferPointer == bytesRead) fillBuffer();
	      return buffer[bufferPointer++];
	   }
	}
}

