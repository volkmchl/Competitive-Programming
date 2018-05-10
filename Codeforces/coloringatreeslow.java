import java.util.*;

public class coloringatreeslow{

	public static int[] currColor;
	public static int[] requColor;
	public static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		currColor = new int[N+1];
		requColor = new int[N+1];

		adjList = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= N; i++){
			adjList.add(new ArrayList<Integer>());
			currColor[i] = 0;
		}

		for(int i = 2; i <= N; i++){
			int parent = sc.nextInt();
			adjList.get(parent).add(i);
		}


		for(int i = 1; i <= N; i++){
			requColor[i] = sc.nextInt();
		}

		int steps = bfs(1);

		System.out.println(steps);
	}

	public static int bfs(int root){

		int steps = 0;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root);

		while(!queue.isEmpty()){
			int currPoint = queue.poll();

			if(currColor[currPoint] != requColor[currPoint]){
				dfs(currPoint, requColor[currPoint]);
				steps += 1;
			}

			ArrayList<Integer> children = adjList.get(currPoint);

			for(int i = 0; i < children.size(); i++){
				queue.add(children.get(i));
			}
		}

		return steps;
	}

	public static void dfs(int root, int color){
		currColor[root] = color;

		ArrayList<Integer> children = adjList.get(root);
		for(int i = 0; i < children.size(); i++){
			dfs(children.get(i),color);
		}
	}
}
