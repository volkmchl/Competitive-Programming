import java.util.*;
public class UVa11727 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int sal[] = new int[3];
        for(int t = 0; t < T; t++){
            
            sal[0] = in.nextInt();
            sal[1] = in.nextInt();
            sal[2] = in.nextInt();
            
            Arrays.sort(sal);
            
            System.out.println("Case " + (t+1) + ": " + sal[1]);
        }
    }
}
