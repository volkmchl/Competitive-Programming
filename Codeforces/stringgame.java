import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.StringTokenizer;

//prob id: 778A

public class stringgame {

	public static void main(String[] args){

		FastScanner sc = new FastScanner();
		
		String initial = sc.next();
		String goal = sc.next();
		int[] ind = new int[initial.length()];
		
		for(int i = 0; i < initial.length(); i++){
			ind[i] = sc.nextInt();
		}

		int l = 0;
		int h = initial.length()-goal.length();


		int max = 0;
		while(l <= h){

			//try removing mid characters
			int mid = (l+h)/2;

			//store all the indices that we will remove for this attempt at finding a solution
			HashSet<Integer> rem = new HashSet<Integer>();
			for(int i = 0 ; i < mid; i++){
				rem.add(ind[i]-1);
			}

			//number of letters we have so far
			int charCount = 0;

			//going through all the letters in the initial word
			for(int i = 0; i < initial.length(); i++){

				//if we are at an index that was not removed
				if(!rem.contains(i)){

					if(initial.charAt(i) == goal.charAt(charCount)){
						charCount++;
					}

					if(charCount == goal.length()) break;
				}
			}

			//if the max number of letters we chose resulted in having all the letters
			//in the goal word, we might be able to remove more letters
			//update max and the low bound
			if(charCount == goal.length()){
				max = mid;			
				l = mid+1;
			}
			//otherwise, update the high bound to whatever max we attempted last -1
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
