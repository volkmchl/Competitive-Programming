import java.util.Scanner;

public class UVa10227 {

    static int[] rank;
    static int[] parent;
    static int[][] heard;
    static int answer;

    public static void makeSets(int P, int T){

        answer = P;
        rank = new int[P+1];
        parent = new int[P+1];
        heard = new int[P+1][T+1];

        for(int i = 0; i < parent.length; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public static void union(int a, int b){
        int aR = find(a);
        int bR = find(b);

        if(aR == bR) return;

        if(rank[aR] > rank[bR]){
            parent[bR] = aR;
        }
        else{
            parent[aR] = bR;
        }

        if(rank[aR] == rank[bR]) rank[aR]++;
        answer--;
    }

    public static int find(int a){
        if(parent[a] == a) return parent[a];
        return (parent[a] = find(parent[a]));
    }

    public static boolean sameOpinion(int a, int b){
        for(int tree = 1; tree < heard[0].length; tree++){
            if(heard[a][tree] != heard[b][tree]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int TST = sc.nextInt();
        sc.nextLine();

        while(TST --> 0){

            int P = sc.nextInt();
            int T = sc.nextInt();
            sc.nextLine();

            makeSets(P,T);

            while(sc.hasNext()){
                String line = sc.nextLine();
                if(line.length() == 0) break;

                String inp[] = line.split(" ");
                int pers = Integer.parseInt(inp[0]);
                int tree = Integer.parseInt(inp[1]);
                heard[pers][tree] = 1;

            }

            for(int a = 1; a <= P; a++) {
                for (int b = a + 1; b <= P; b++) {
                    if (sameOpinion(a, b)) {
                        union(a, b);
                    }
                }
            }

            System.out.println(answer);
            if(TST > 0){
                System.out.println();
            }
        }
    }
}
