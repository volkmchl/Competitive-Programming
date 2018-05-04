import java.util.*;

class TUTBFS {
					   //N S E W  NE NW SE   SW
	static int[] dx = {-1,1,0, 0, 1 ,1, -1, -1};
	static int[] dy = {0 ,0,1,-1, 1, -1, 1 ,-1};
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t = 0; t < T; t++){
			int N = in.nextInt();
			int M = in.nextInt();
			char[][] mx = new char[N][M];
			boolean[][] vis = new boolean[N][M];
			int[][] dis = new int[N][M];
			
			for(int n = 0; n < N; n++){
				for(int m = 0; m < M; m++){
					dis[n][m] = -1;
				}
			}
			
			for(int n = 0; n < N; n++){
				String line = in.next();
				for(int m = 0; m < M; m++){
					mx[n][m] = line.charAt(m);
				}
			}
			
			Pair init = new Pair(0,0);
			dis[0][0] = 0;
			vis[0][0] = true;
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(init);
			
			while(!q.isEmpty()){
				Pair buffer = q.poll();
				int r = buffer.row;
				int c = buffer.col;
				vis[r][c] =  true;
				for(int i = 0 ; i < 8; i++){
					if(r+dx[i] >= 0 && r+dx[i] < N && c+dy[i] >= 0 && c+dy[i] < M && !vis[r+dx[i]][c+dy[i]] && mx[r+dx[i]][c+dy[i]] == '.'){
						dis[r+dx[i]][c+dy[i]] = dis[r][c] + 1;
						vis[r+dx[i]][c+dy[i]] = true;
						q.add(new Pair(r+dx[i],c+dy[i]));
					}
				}
			}
			
			int maxDis = 0;
			for(int n = 0; n < N; n++){
				for(int m = 0; m < M; m++){
					if(dis[n][m] > maxDis){
						maxDis = dis[n][m];
					}
				}
			}
			System.out.println(maxDis);
			
		}
	}
	
	public static class Pair{
		int row,col;
		Pair(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
}
