import java.util.*;

public class UVa11364 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            int stores = in.nextInt();
            int min = 101;
            int max = -1;
            int total = 0;
            
            for(int j = 0; j < stores; j++){
                int storeBuffer = in.nextInt();
                total += storeBuffer;
                if(storeBuffer > max) max = storeBuffer;
                if(storeBuffer < min) min = storeBuffer;
            }
            
            int parkSpot = Math.round(total/stores);
            int result = 2*(parkSpot - min) + 2*(max-parkSpot);
            System.out.println(result);
        }
    }
}
