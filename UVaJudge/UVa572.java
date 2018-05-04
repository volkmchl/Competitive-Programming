import java.util.*;

public class UVa572{
    
    static int[] dx = {1, -1, 0,  0, 1,  1, -1, -1};
    static int[] dy = {0,  0, 1, -1, 1, -1,  1, -1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int R = sc.nextInt();
            if(R == 0) break;
            int C = sc.nextInt();
            
            char[][] field = new char[R][C];
            boolean[][] visited = new boolean[R][C];
            
            for(int i = 0; i < R; i++){
                String row = sc.next();
                for(int j = 0; j < C; j++){
                    field[i][j] = row.charAt(j);
                }
            }
            
            Queue<Point> locations = new LinkedList<Point>();
            
            int oilDeposits = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    Point toInsert = new Point(i,j);
                    if(field[i][j] == '@' && !visited[i][j]){
                        oilDeposits++;
                        locations.add(toInsert);
                    }
                    
                    while(!locations.isEmpty()){
                        Point bufferPoint = locations.poll();
                        int bufferR = bufferPoint.r;
                        int bufferC = bufferPoint.c;
                        
                        if(field[bufferR][bufferC] == '@'){
                            for(int neighbor = 0; neighbor < 8; neighbor++){
                                int neighborRow = bufferR + dx[neighbor];
                                int neighborCol = bufferC + dy[neighbor];
                                if(neighborRow >= 0 && neighborRow < R && neighborCol >= 0 && neighborCol < C && !visited[neighborRow][neighborCol] && field[neighborRow][neighborCol] == '@'){
                                    locations.add(new Point(neighborRow,neighborCol));
                                    visited[neighborRow][neighborCol] = true;
                                }
                            }
                        }
                    }
                }
            }
            
            System.out.println(oilDeposits);
            
        }
    }
    
    static class Point{
        int r,c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
}
