import java.util.*;

public class UVa12442{

	static int[] map;
	static int[] depth;
	static boolean[] vis;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t = 0; t < T; t++){
			int N = sc.nextInt();
			map = new int[N];
			depth = new int[N];
			vis = new boolean[N];
			for(int n = 0; n < N; n++){
				int sender = sc.nextInt()-1;
				int receiv = sc.nextInt()-1;
				map[sender] = receiv;
			}

			int ans = 0;
			int longestDepth = 0;
			for(int n = 0; n < N; n++){
				int senderDepth = 0;
				if(depth[n] == 0) dfs(n);
				senderDepth = depth[n];
				if(senderDepth > longestDepth){
					ans = n+1;
					longestDepth = senderDepth;
				}
			}
			System.out.println("Case " + (t+1) + ": " + ans);
		}
	}

	public static int dfs(int sender){
		int senderDepth = 0;
		vis[sender] = true;
		if(!vis[map[sender]]){
			senderDepth = 1 + dfs(map[sender]);
		}
		depth[sender] = senderDepth;
		vis[sender] = false;
		return senderDepth;
	}
}
