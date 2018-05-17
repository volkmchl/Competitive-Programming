import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

// prob D on 2015 ACM Arabella

public class soduku {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        while(T --> 0){
            int[][] grid = new int[9][9];
            for(int i = 0; i < 9; i++){
                char[] row = sc.nextLine().toCharArray();
                for(int j = 0; j < 9; j++){
                    grid[i][j] = row[j] - '0';
                }
            }
            if( T != 0){
                sc.nextLine();
            }

        boolean valid = true;
        for(int index = 0; index < 9; index++){
            valid &= validCol(grid, index) && validRow(grid, index);
        }

        for(int startI = 0; startI < 9; startI += 3){
            for(int startJ = 0; startJ < 9; startJ += 3){
                valid &= validBoxes(grid, startI, startJ);
            }
        }

        System.out.println( (valid) ? "Valid" : "Invalid");
        }
    }

    public static boolean validCol(int[][] grid, int col){
        HashSet<Integer> hSet = new HashSet<Integer>();

        for(int row = 0; row < 9; row++){
            if(grid[row][col] < 1 || grid[row][col] > 9) return false;
            hSet.add(grid[row][col]);
        }

        return (hSet.size() == 9);
    }

    public static boolean validRow(int[][] grid, int row){
        HashSet<Integer> hSet = new HashSet<Integer>();

        for(int col = 0; col < 9; col++){
            if(grid[row][col] < 1 || grid[row][col] > 9) return false;
            hSet.add(grid[row][col]);
        }

        return (hSet.size() == 9);
    }

    public static boolean validBoxes(int[][] grid, int startI, int startJ){
        
        HashSet<Integer> hSet = new HashSet<Integer>();
        
        for(int i = startI; i < startI+3; i++){
            for(int j = startJ; j < startJ+3; j++){
                if(grid[i][j] < 1 || grid[i][j] > 9) return false;
                hSet.add(grid[i][j]);
            }
        }

        return (hSet.size() == 9);
    }

    public static class FastScanner  {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        public FastScanner() {
            this(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
