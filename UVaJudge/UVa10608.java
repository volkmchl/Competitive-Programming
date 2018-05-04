import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.*;
import java.util.*;
public class UVa10608{
	
    static int[] rank;
    static int[] parent;
    static int[] clique;

    public static int union(int a, int b){
        
        int aR = find(a);
        int bR = find(b);
        
        if (rank[aR] > rank[bR]){
            parent[bR] = aR;
            clique[aR] += clique[bR];
            clique[bR] = 0;
        }
        else{
            parent[aR] = bR;
            clique[bR] += clique[aR];
            clique[aR] = 0;
        }

        if(rank[aR] == rank[bR]) rank[bR]++;

        return Math.max(clique[aR],clique[bR]);
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        return (parent[a] = find(parent[a]));
    }
    
    public static void main(String[] args){

        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            rank = new int[N+1];
            parent = new int[N+1];
            clique = new int[N+1];
            Arrays.fill(clique,1);

            for(int n = 0; n < N; n++){
                parent[n] = n;
            }

            int max = 1;
            for(int m = 0; m < M; m++){
                
                int a = sc.nextInt();
                int b = sc.nextInt();
                
                if(find(a) == find(b)) continue;
                int nCliq = union(find(a),find(b));
                max = max < nCliq ? nCliq : max; 
                
            }

            System.out.println(max);
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
