import java.util.*;

public class UVa11904{
	//N,S,E,W
	static int[] dR = {-1,1,0,0};
	static int[] dC = {0,0,1,-1};

	static char[][] world;
	static boolean[][] vis;
	static char land;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int R = sc.nextInt();
			int C = sc.nextInt();

			world = new char[R][C];
			vis   = new boolean[R][C];

			for(int r = 0; r < R; r++){
				String row = sc.next();
				for(int c = 0; c < C; c++){
					world[r][c] = row.charAt(c);
				}
			}

			Point home = new Point(sc.nextInt(), sc.nextInt());
			land  = world[home.r][home.c];

			bfs(home);

			int maxConquer = 0;
			for(int r = 0; r < R; r++){
				for(int c = 0; c < C; c++){
					if(!vis[r][c] && world[r][c] == land){
						int tempArea = bfs(new Point(r,c));
						maxConquer = (maxConquer < tempArea) ? tempArea : maxConquer;
					}
				}
			}

			System.out.println(maxConquer);

		}
	}

	public static int bfs(Point pos){
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(pos);
		vis[pos.r][pos.c] = true;

		int area = 0;
		while(!queue.isEmpty()){

			Point currPos = queue.poll();
			area++;

			for(int i = 0; i < 4; i++){
				int adjR = currPos.r+dR[i];
				int adjC = (currPos.c+dC[i]+world[0].length)%world[0].length;
				if(adjR >= 0 && adjR < world.length && world[adjR][adjC] == land && !vis[adjR][adjC]){
					queue.add(new Point(adjR,adjC));
					vis[adjR][adjC] = true;
				}
			}
		}
		return area;
	}
}

class Point{
	int r,c;

	Point(int r, int c){
		this.r = r;
		this.c = c;
	}
}
