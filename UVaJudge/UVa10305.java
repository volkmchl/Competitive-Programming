import java.util.*;

public class UVa10305{

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] used, Stack<Integer> result, int i){
        used[i] = true;

        for(int v : graph.get(i)){
            if(!used[v]){
                dfs(graph, used, result, v);
            }
        }
        result.push(i+1);
    }

    public static Stack<Integer> topologicalSort(ArrayList<ArrayList<Integer>> graph){
        int n = graph.size();
        boolean[] used = new boolean[n];

        Stack<Integer> result = new Stack<Integer>();
        for(int i = 0; i < n; i++){
            if(!used[i]){
                dfs(graph, used, result, i);
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();

            if(N == 0 && M == 0) break;

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int n = 0; n < N; n++){
                graph.add(new ArrayList<Integer>());
            }

            for(int m = 0; m < M; m++){

                //a must be executed before b   (b depends on a)
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;

                //b -> a (before you can do b, you have to do a) = (b depends on a)
                graph.get(a).add(b);
            }

            Stack<Integer> result = topologicalSort(graph);


            System.out.print(result.pop());
            while(!result.isEmpty()){
                System.out.print(" " + result.pop());
            }
            System.out.println();
        }
    }
}
