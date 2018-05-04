import java.util.*;

public class UVa10113{

    public static Map<String, ArrayList<Rate>> map;
    
    public static int lcm(int a, int b){
        return a * (b / gcd(a, b));
    }
    
    public static int gcd(int a, int b){
        while (b > 0){
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public static Rate bfs(String itemA, String itemB){
        
        Queue<Rate> queue = new LinkedList<>();
        
        Map<String, Boolean> visited = new HashMap<>();
        for(String item : map.keySet()){
            visited.put(item, false);
        }

        ArrayList<Rate> rates = map.get(itemA);
        for(int i = 0; i < rates.size(); i++){
            queue.add(rates.get(i));
        }

        visited.put(itemA, true);

        while(!queue.isEmpty()){
            Rate current = queue.poll();
            if(current.to.equals(itemB)){
                queue.clear();
                //FOUND DESTINATION
                return current;
            }
            
            visited.put(current.from, true);
            ArrayList<Rate> adjRates = map.get(current.to);
            for(Rate adjRate: adjRates){

                if(!visited.get(adjRate.to)){
                    visited.put(adjRate.to, true);
                    int currentFrmCst = current.frmCst;
                    int currentToRwrd = current.toRwrd;

                    int adjFrmCst = adjRate.frmCst;
                    int adjToRwrd = adjRate.toRwrd;

                    int LCM = lcm(currentToRwrd, adjFrmCst);
                    Rate result = new Rate(current.from,adjRate.to , currentFrmCst * LCM/currentToRwrd, adjToRwrd * LCM/adjFrmCst);
                    queue.add(result);
                }
            }

        }

        return new Rate("", "", 0, 0);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        map = new HashMap<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals(".")){
                break;
            }

            String[] tokens = line.split(" ");
            String command = tokens[0];
            
            //ASSERTION
            if(command.equals("!")){
                int m = Integer.parseInt(tokens[1]);
                String itemA = tokens[2];

                int n = Integer.parseInt(tokens[4]);
                String itemB = tokens[5];

                
                Rate rateAB = new Rate(itemA, itemB, m, n);
                Rate rateBA = new Rate(itemB, itemA, n, m);
                
                if(map.get(itemA) == null){
                    ArrayList<Rate> rates = new ArrayList<>();
                    rates.add(rateAB);
                    map.put(itemA, rates);
                }
                else{
                    map.get(itemA).add(rateAB);
                }

                if(map.get(itemB) == null){
                    ArrayList<Rate> rates = new ArrayList<>();
                    rates.add(rateBA);
                    map.put(itemB, rates);
                }
                else{
                    map.get(itemB).add(rateBA);
                }
            }

            //QUERY
            else{
                String itemA = tokens[1];
                String itemB = tokens[3];
                Rate result = bfs(itemA, itemB);
                if(result.from.equals("")){
                    System.out.println("? " + itemA + " = ? " + itemB);
                }
                else{
                    System.out.println(result);
                }
            }

        }
    }

    public static class Rate{
        String from, to;
        int frmCst, toRwrd;

        public Rate(String from, String to, int frmCst, int toRwrd){
            this.from = from;
            this.to = to;
            
            int gcd = gcd(frmCst, toRwrd);
            if(gcd == 0)
                gcd = 1;
            this.frmCst = frmCst/gcd;
            this.toRwrd = toRwrd/gcd;
        }

        public String toString(){
            return (frmCst + " " + from + " = " + toRwrd + " " + to);
        }
    }
}
