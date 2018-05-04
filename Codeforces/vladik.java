import java.io.*;
import java.util.*;

//prob id: 811B

public class vladik {
	public static void main(String[] args){
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] P = new int[n];
		
		for(int i = 0; i < n; i++){
			P[i] = sc.nextInt();
		}
		
		for(int i = 0; i < m; i++){
			int l = sc.nextInt();
			int r = sc.nextInt();
			int x = sc.nextInt();
			
			if(l > x || r < x){
				System.out.println("Yes");
			}
			else{
				int cntLess = 0;
				for(int j = l-1; j < r; j++){
					if(P[j] < P[x-1]) cntLess++;
				}
				if(P[cntLess+l-1] == P[x-1]) System.out.println("Yes");
				else System.out.println("No");
			}
		}
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
