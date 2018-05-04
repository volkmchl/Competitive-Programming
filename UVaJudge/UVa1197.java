import java.util.*;

public class UVa1197{

	static int parent[];
	static int rank[];

	public static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public static void merge(int x, int y){
		int xRep = find(x);
		int yRep = find(y);
		if(rank[xRep] > rank[yRep]){
			parent[yRep] = xRep;
		}
		else {
			parent[xRep] = yRep;
		}
		if(rank[xRep] == rank[yRep]){
			rank[yRep]++;
		}

	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();
			int M = sc.nextInt();

			if (N == 0) break;

			parent = new int[N];
			rank = new int[N];
			for(int i = 0; i < N; i++){
				parent[i] = i;
			}

			for(int m = 0; m < M; m++){
				int cnt = sc.nextInt();
				int prv = sc.nextInt();
				for(int c = 1; c < cnt; c++){
					int nxt = sc.nextInt();
					merge(prv,nxt);
					prv = nxt;
				}
			}
			int ans = 1;
			int repr0 = find(0);

			for(int i = 1; i < N; i++){
				if(find(i) == repr0) ans++;
			}
			System.out.println(ans);
		}
	}
}
