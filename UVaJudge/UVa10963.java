import java.util.*;
public class UVa10963 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            int C = in.nextInt();
            int gap = Math.abs(in.nextInt() - in.nextInt());
            boolean closable = true;
            for(int c = 0; c < C-1; c++){
                if(gap != Math.abs(in.nextInt() - in.nextInt())){
                    closable = false;
                }
            }
            if(t!= T-1){
                System.out.println(closable ? "yes\n" : "no\n");
            }
            else{
                System.out.print(closable ? "yes" : "no");
            }
        }
    }
}
