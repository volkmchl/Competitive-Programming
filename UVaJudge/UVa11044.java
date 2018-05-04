import java.util.*;

public class UVa11044 {
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            System.out.println((int)(Math.ceil((in.nextDouble()-2)/3)*Math.ceil((in.nextDouble()-2)/3)));
        }
    }
}
