import java.util.*;

public class torn2pieces{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        Map<String,Integer> locToID = new HashMap<>();
        Map<Integer, String> idToLoc = new HashMap<>();

        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < N; i++){
            String[] input = sc.nextLine().split(" ");
            
            assignID(input[0], locToID, idToLoc, graph);

            for(int j = 1; j < input.length; j++){
                assignID(input[j], locToID, idToLoc, graph);
                createEdge(input[0], input[j], locToID, graph);
            }
        }

        String start = sc.next();
        String end = sc.next();

        int[] parent = bfs(start, end, graph, locToID);


        if(!locToID.containsKey(start) || !locToID.containsKey(end) || parent[locToID.get(end)] == -1){
            System.out.println("no route found");
        }
        else{
            Stack<String> path = new Stack<String>();
            String currStation = end;
            int currParent = parent[locToID.get(end)];
            path.push(end);

            while(currParent != -1){
                path.push(idToLoc.get(currParent));
                currParent = parent[currParent];
            }

            while(!path.isEmpty()){
                System.out.print(path.pop());
                if(!path.isEmpty()) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[] bfs(String start, String end, Map<Integer, List<Integer>> graph, Map<String, Integer> locToID){

        int[] parent = new int[graph.size()];
        Arrays.fill(parent,-1);

        if(!locToID.containsKey(start) || !locToID.containsKey(end)) return parent;

        int startID = locToID.get(start);
        int endID = locToID.get(end);

        boolean[] visited = new boolean[graph.size()];
        
        parent[startID] = -1;
        visited[startID] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startID);

        while(!queue.isEmpty()){
            int currStationID = queue.poll();
            if(currStationID == endID) break;

            List<Integer> neighbors = graph.get(currStationID);
            for(int i = 0; i < neighbors.size(); i++){
                if(!visited[neighbors.get(i)]){
                    parent[neighbors.get(i)] = currStationID;
                    visited[neighbors.get(i)] = true;
                    queue.add(neighbors.get(i));
                }
            }
        }

        return parent;

    }

    public static void printGraph(Map<Integer, List<Integer>> graph, Map<Integer, String> idToLoc){
        for(Integer start : graph.keySet()){
            System.out.println("Station " + idToLoc.get(start));
            System.out.println("Neighboring Stations: ");
            
            List<Integer> neighbors = graph.get(start);
            System.out.print("\t");
            for(int i = 0; i < neighbors.size(); i++){
                System.out.print(idToLoc.get(neighbors.get(i)) + " ");
            }
            System.out.println("\n");
        }
    }

    public static void assignID(String location, Map<String, Integer> locToID, Map<Integer,String> idToLoc, Map<Integer, List<Integer>> graph){
        if(!locToID.containsKey(location)){

            int idToAssign = locToID.size();
            locToID.put(location, idToAssign);
            idToLoc.put(idToAssign, location);

            graph.put(locToID.get(location), new ArrayList<>());
        }
    }

    public static void createEdge(String from, String to, Map<String,Integer> locToID, Map<Integer, List<Integer>> graph){
        int fromID = locToID.get(from);
        int toID = locToID.get(to);
        graph.get(fromID).add(toID);
        graph.get(toID).add(fromID);
    }

}
