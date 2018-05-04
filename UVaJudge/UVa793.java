import java.util.*;

public class UVa793{
	
	static int[] parent, rank;
	
	public static boolean sameSet(int x, int y){
		return (find(x) == find(y));
	}

	public static int find(int x){
		if(x != parent[x]){
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public static void makeSets(int[] parent){
		for(int i = 0; i < parent.length; i++){
			parent[i] = i;
		}
	}

	public static void merge(int x, int y){
		int repX = find(x);
		int repY = find(y);

		if(repX == repY) return;

		if(rank[repX] > rank[repY]){
			parent[repY] = repX;
		}
		else{
			parent[repX] = repY;
		}
		if(rank[repX] == rank[repY]){
			rank[repY]++;
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		boolean first = true;
		
		for(int t = 0; t < T; t++){
			if(first) first = false;
			else System.out.println();

			int Y = 0, N = 0;
			int C = sc.nextInt();
			parent = new int[C+1];
			rank = new int[C+1];
			makeSets(parent);

			while(!sc.hasNextInt() && sc.hasNext()){
				char query = sc.next().charAt(0);
				int c1 = sc.nextInt();
				int c2 = sc.nextInt();
				if(query == 'c') merge(c1,c2);
				else{
					if(sameSet(c1,c2)) Y++;
					else N++;
				}
			}

			System.out.println(Y + "," + N);

		}
	}
}
