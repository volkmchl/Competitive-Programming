import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class UVa725 {
	public static void main(String[] args){

		FastScanner sc = new FastScanner();

		int t = 0;

		while(true){

			int N = sc.nextInt();
			t++;

			if(N == 0){
				break;
			}
			else if( t != 1){
				System.out.println();
			}

			boolean sol = false;
			for (int fghij = 1234; fghij <= 98765 / N; fghij++) {
				int abcde = fghij * N;
				int tmp, used = (fghij < 10000) ? 1 : 0;
				tmp = abcde; while (tmp > 0) { used |= 1 << (tmp % 10); tmp /= 10; }
				tmp = fghij; while (tmp > 0) { used |= 1 << (tmp % 10); tmp /= 10; }
				if (used == (1<<10) - 1){
					sol = true;
					System.out.printf("%05d / %05d = %d\n" , abcde, fghij, N);
				}
			}
			if(!sol){
				System.out.println("There are no solutions for " + N + ".");
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

