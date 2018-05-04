import java.util.*;

public class UVa11547 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            System.out.println(Math.abs((in.nextInt()*63+7492)*5-498)/10%10);
        }
    }
}
