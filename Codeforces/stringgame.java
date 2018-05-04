import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

//prob id: 778A

public class stringgame {

	public static void main(String[] args){
		FastScanner sc = new FastScanner();
		String t = sc.next();
		String p = sc.next();

		int ind[] = new int[t.length()];
		int time[] = new int[t.length()];

		for(int i = 0;i<t.length();i++){
			ind[i] = sc.nextInt()-1;
			time[ind[i]] = i;
		}

		int l = 0;
		int h = t.length()-p.length();



		int max = 0;
		while(l <= h){
			int mid = (l+h)/2;

			int pI = 0;
			for(int i = 0; i < t.length(); i++){
				
				if(time[i] >= mid && t.charAt(i) == p.charAt(pI)){
					pI++;
				}
				if(pI == p.length()) break;

			}


			if(pI == p.length()){
				max = mid;
				l = mid+1;
			}
			else{
				h = mid-1;
			}

		}

		System.out.println(max);

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
