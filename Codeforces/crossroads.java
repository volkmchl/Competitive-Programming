import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

//prob id: 812A

public class crossroads {
	
	public static boolean light[][];
	
	public static void main(String[] args){
		FastScanner sc = new FastScanner();
		light = new boolean[4][4];
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				light[i][j] = (sc.nextInt() == 1);
			}
		}
		
		boolean acci = false;
		for(int w = 0; w < 4; w++){
			if(acc(w)) {
				acci = true;
				break;
			}
		}
		
		if(acci) System.out.println("YES");
		else System.out.println("NO");
	}
	
	
	public static boolean acc(int way){
		
		if(!light[way][3]) return false;
		
		for(int l = 0; l < 3; l++){
			
			if(light[way][l]){
				return true;
			}
		}
		
		for(int p = way+1, l = 0; p < way+4; p++, l++){
			if(light[p%4][l]) {
				return true;
			}
		}
		
		return false;
		
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
