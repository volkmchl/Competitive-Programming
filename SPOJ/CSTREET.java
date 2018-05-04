import java.util.*;

class CSTREET{
	//array of representatives
	static int[] parent;

	//create initial disjoint sets (no person has any friends -- they are their own representatives)
	static void makeSets(int N){
		parent = new int[N+1];
		
		for(int i = 1; i <= N; i++){
			parent[i] = i;
		}
	}

	//connect two nodes
	static void union(int x, int y){
		int rX = find(x);
		int rY = find(y);

		parent[rY] = rX;
	}

	//find the representative of node x
	static int find(int x){
		if(x == parent[x]) return x;

		//path compression
		return (parent[x] = find(parent[x]));
	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while(T --> 0){

			PriorityQueue<Edge> edgeQueue = new PriorityQueue<Edge>();

			int price = sc.nextInt();
			int nodes = sc.nextInt();
			int edges = sc.nextInt();

			makeSets(nodes);

			for(int e = 0; e < edges; e++){

				int nodeX = sc.nextInt();
				int nodeY = sc.nextInt();
				int weight = sc.nextInt();


				edgeQueue.add(new Edge(nodeX, nodeY, weight));
			}

			int totalWeight = 0;
			while(!edgeQueue.isEmpty()){
				Edge edgePolled = edgeQueue.poll();

				if(find(edgePolled.nodeX) != find(edgePolled.nodeY)){
					union(edgePolled.nodeX, edgePolled.nodeY);
					totalWeight += edgePolled.weight;
				}
			}
			
			System.out.println(totalWeight * price);

		}
	}

	static class Edge implements Comparable<Edge>{

		int nodeX, nodeY;
		int weight;

		public Edge(int X, int Y, int weight){
			this.nodeX = X;
			this.nodeY = Y;
			this.weight = weight;
		}

		public int compareTo(Edge other){
			if(this.weight < other.weight){
				return -1;
			}
			else if(this.weight > other.weight){
				return 1;
			}

			return 0;
		}

	}

}
