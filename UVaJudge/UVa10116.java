import java.util.*;

public class UVa10116{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int R = sc.nextInt();
			int C = sc.nextInt();
			int startC = sc.nextInt()-1;

			sc.nextLine();

			if(startC == -1) break;

			char[][] grid = new char[R][C];
			boolean[][] vis = new boolean[R][C];
			for(int r = 0; r < R; r++){
				String row = sc.nextLine();
				for(int c = 0; c < C; c++){
					grid[r][c] = row.charAt(c);
				}
			}

			int instruct = 0, cycleInstr = 0, currRow = 0, currCol = startC;
			boolean cycle = false;
			vis[currRow][startC] = true;

			while(!cycle){


				char currInstr = grid[currRow][currCol];
				currRow += rowChange(currInstr);
				currCol += colChange(currInstr);

				instruct++;
				if(currRow >= R || currRow < 0 || currCol >= C || currCol < 0) break;

				if(vis[currRow][currCol]){
					cycle = true;
					currInstr = grid[currRow][currCol];
					int cycleStartR = currRow;
					int cycleStartC = currCol;

					cycleInstr = 1;
					currRow += rowChange(currInstr);
					currCol += colChange(currInstr);
					currInstr = grid[currRow][currCol];
					while(currRow != cycleStartR || currCol != cycleStartC){

						currRow += rowChange(currInstr);
						currCol += colChange(currInstr);
						currInstr = grid[currRow][currCol];
						cycleInstr++;
					}

				}
				vis[currRow][currCol] = true;
			}

			if(cycle){
				System.out.println(instruct-cycleInstr + " step(s) before a loop of " + cycleInstr + " step(s)");
			}
			else{
				System.out.println(instruct + " step(s) to exit");
			}
		}
	}

	public static int colChange(char instruction){
		if(instruction == 'W') return -1;
		if(instruction == 'E') return 1;
		return 0;
	}

	public static int rowChange(char instruction){
		if(instruction == 'N') return -1;
		if(instruction == 'S') return 1;
		return 0;
	}
}