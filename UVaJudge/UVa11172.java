import java.util.*;

public class UVa11172 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            int a = in.nextInt();
            int b = in.nextInt();
            if(a < b){
                System.out.println("<");
            }
            else if(a > b){
                System.out.println(">");
            }
            else{
                System.out.println("=");
            }
        }
    }
}
