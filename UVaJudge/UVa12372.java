import java.util.*;

public class UVa12372 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        in.nextLine();
        
        boolean flag;
        for(int t = 0; t < T; t++){
            flag = true;
            
            for(int i = 0; i < 3; i++){
                if (in.nextInt() > 20) flag = false;
            }
            
            System.out.println("Case " + (t+1) +": " + ((flag) ? "good":"bad"));
            
        }
    }
}
