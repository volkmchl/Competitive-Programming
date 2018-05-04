import java.util.*;

public class UVa469 {
    
    static ArrayList<ArrayList<Character>> area;
    static boolean[][] visited;
    //S, N, E, W,  SE, SW, NE, NW
    static int[] dx = {1, -1, 0,  0, 1,  1, -1, -1};
    static int[] dy = {0,  0, 1, -1, 1, -1,  1, -1};
    
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String line = "";
        boolean first = true;
        while(in.hasNext()){
            area = new ArrayList<ArrayList<Character>>();
            int index = 0;
            while(in.hasNext()){
                if(in.hasNextInt())break;
                area.add(new ArrayList<Character>());
                
                String toProcess = in.next();
                for(int i = 0; i < toProcess.length(); i++){
                    area.get(index).add(toProcess.charAt(i));
                }
                index++;
            }
            
            if(first){
                first = false;
            }
            else{
                System.out.println("");
            }
            
            
            
            while(in.hasNextInt()){
                visited =  new boolean[area.size()][area.get(0).size()];
                int r = in.nextInt()-1;
                int c = in.nextInt()-1;
                System.out.println(bfs(r,c));
            }
        }
        
    }
    
    static int bfs(int r, int c){
        
        if(area.get(r).get(c) != 'W'){
            return 0;
        }
        
        Queue<Coordinate> q = new LinkedList<Coordinate>();
        Coordinate start = new Coordinate(r,c);
        int cnt = 1;
        visited[r][c] = true;
        q.add(start);
        
        while(!q.isEmpty()){
            Coordinate buffer = q.poll();
            
            for(int i = 0; i < 8; i++){
                int newRow = buffer.r + dx[i];
                int newCol = buffer.c + dy[i];
                int N = area.size();
                int M = area.get(0).size();
                if(newRow < area.size() && newRow >= 0 && newCol < area.get(0).size() && newCol >= 0 && area.get(newRow).get(newCol) == 'W' && !visited[newRow][newCol]){
                    cnt++;
                    q.add(new Coordinate(newRow,newCol));
                    visited[newRow][newCol] = true;
                }
                
            }
        }
        
        return cnt;
    }
    
    private static class Coordinate{
        int r,c;
        Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
