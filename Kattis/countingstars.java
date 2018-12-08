import java.util.*;

public class countingstars{
    
    static int[] dRow = new int[] {0, 1, 0, -1};
    static int[] dCol = new int[] {1, 0, -1, 0};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = 1;

        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();

            char[][] sky = new char[m][n];
            for(int i = 0; i < m; i++){
                sky[i] = sc.next().toCharArray();
            }

            System.out.println("Case " + testCase++ + ": " + dfs(sky));
        }
    }

    public static int bfs(char[][] sky){

        //set up
        int starsCount = 0;
        boolean[][] visited = new boolean[sky.length][sky[0].length];

        //go through sky
        for(int row = 0; row < sky.length; row++){
            for(int col = 0; col < sky[row].length; col++){
                
                if(sky[row][col] == '-' && !visited[row][col]){
                    bfsUtil(sky, visited, new Point(row, col));
                    ++starsCount;
                }

            }
        }

        return starsCount;
    }

    public static void bfsUtil(char[][] sky, boolean[][] visited, Point start){

        Queue<Point> queue = new LinkedList<Point>();
        visited[start.row][start.col] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            Point currPoint = queue.poll();

            for(int psbleNbor = 0; psbleNbor < 4; psbleNbor++){

                int psbleNborRow = currPoint.row + dRow[psbleNbor];
                int psbleNborCol = currPoint.col + dCol[psbleNbor];

                if(psbleNborRow >= 0 && psbleNborRow < sky.length && psbleNborCol >= 0 && psbleNborCol < sky[0].length){
                    if(sky[psbleNborRow][psbleNborCol] == '-' && !visited[psbleNborRow][psbleNborCol]){
                        queue.add(new Point(psbleNborRow, psbleNborCol));
                        visited[psbleNborRow][psbleNborCol] = true;
                    }
                }

            }
        }

    }

    public static int dfs(char[][] sky){
        int starsCount = 0;
        boolean[][] visited = new boolean[sky.length][sky[0].length];

        for(int row = 0; row < sky.length; row++){
            for(int col = 0; col < sky[row].length; col++){
                if(sky[row][col] == '-' && !visited[row][col]){
                    dfsUtil(sky,visited, row, col);
                    starsCount++;
                }
            }
        }

        return starsCount;
    }

    public static void dfsUtil(char[][] sky, boolean[][] visited, int curRow, int curCol){
        if(curRow < 0 || curRow >= sky.length || curCol < 0 || curCol >= sky[curRow].length || sky[curRow][curCol] != '-' || visited[curRow][curCol]) return;

        visited[curRow][curCol] = true;
        for(int psbleNbor = 0; psbleNbor < 4; psbleNbor++){
            dfsUtil(sky, visited, curRow + dRow[psbleNbor], curCol + dCol[psbleNbor]);
        }

    }


    public static void printVisited(boolean[][] visited){
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[i].length; j++){
                System.out.print((visited[i][j] ? "1" : "0"));
            }
            System.out.println();
        }
    }
}

class Point{
    int row, col;

    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

