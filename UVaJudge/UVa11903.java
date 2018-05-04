import java.util.*;

public class UVa11903{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int stations = sc.nextInt();
            int fuel[] = new int[stations];
            int cost[] = new int[stations];
            
            int totalFuel = 0;
            int totalCost = 0;
            
            for(int i = 0; i < stations; i++){
                fuel[i] = sc.nextInt();
                totalFuel += fuel[i];
            }
            for(int i = 0; i < stations; i++){
                cost[i] = sc.nextInt();
                totalCost += cost[i];
            }
            
            boolean success = false;
            int smallestStation = -1;
            if(totalCost <= totalFuel){
                for(int beginIndex = 0; beginIndex < stations; beginIndex++){
                    int currentFuel = 0;
                    
                    int currentStation;
                    for(currentStation = beginIndex; currentStation < stations+beginIndex; currentStation++){
                        currentFuel += fuel[currentStation%stations];
                        currentFuel -= cost[currentStation%stations];
                        if(currentFuel < 0)break;
                    }
                    
                    if(currentStation == stations+beginIndex){
                        success = true;
                        smallestStation = currentStation%stations;
                        break;
                    }
                }
            }
            
            
            
            System.out.println("Case " + (t+1) + ": " + (success ? "Possible from station " + (smallestStation+1) : "Not possible"));
        }
    }
}
