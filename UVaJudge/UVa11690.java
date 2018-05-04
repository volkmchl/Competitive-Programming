import java.util.*;

public class UVa11690{
	static int parent[];
	static int rank[];
	static int balance[];

	public static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public static void merge(int x, int y){
		int xRep = find(x);
		int yRep = find(y);
		if(xRep == yRep) return;
		
		if(rank[xRep] > rank[yRep]){
			parent[yRep] = xRep;
			balance[xRep] += balance[yRep];
			balance[yRep] = 0;
		}
		else {
			parent[xRep] = yRep;
			balance[yRep] += balance[xRep];
			balance[xRep] = 0;
		}
		if(rank[xRep] == rank[yRep]){
			rank[yRep]++;
		}

	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++){
			int P = sc.nextInt();
			int R = sc.nextInt();

			parent = new int[P];
			balance = new int[P];
			rank = new int[P];
			for(int i = 0; i < P; i++){
				parent[i] = i;
			}

			for(int p = 0; p < P; p++){
				balance[p] = sc.nextInt();
			}

			for(int r = 0; r < R; r++){
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				merge(p1, p2);
			}

			boolean possible = true;
			for(int i = 0; i < P; i++){
				if(balance[parent[i]] != 0){
					possible = false;
					break;
				}
			}

			System.out.println((possible) ? "POSSIBLE" : "IMPOSSIBLE");

		}
	}
}
