import java.util.*;

public class UVa12376{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t = 0; t < T; t++){
			int N = sc.nextInt();
			int M = sc.nextInt();

			Node[] nodes = new Node[N];

			for(int n = 0; n < N; n++){
				nodes[n] = new Node(sc.nextInt(),n);
			}

			for(int m = 0; m < M; m++){
				int from = sc.nextInt();
				int to 	 = sc.nextInt();
				nodes[from].neighbors.add(nodes[to]);
			}

			int[] end = maxLearn(nodes[0]);

			System.out.println("Case " + (t+1) + ": " + end[0] + " " + end[1]);

		}
	}

	public static int[] maxLearn(Node currNode){
		int[] ans = new int[2];
		ans[0] = currNode.val;
		ans[1] = currNode.ID;

		int[] next = new int[2];
		if(!currNode.neighbors.isEmpty()){
			next = maxLearn(currNode.neighbors.poll());
			ans[1] = next[1];
			ans[0] += next[0];
		}

		return ans;
	}

}

class Node implements Comparable<Node>{
	int val,ID;
	PriorityQueue<Node> neighbors;

	public Node(int val,int ID){
		this.val = val;
		this.ID = ID;
		neighbors = new PriorityQueue<Node>();
	}

	public int compareTo(Node other){
		if(this.val > other.val){
			return -1;
		}
		return 1;
	}
}
