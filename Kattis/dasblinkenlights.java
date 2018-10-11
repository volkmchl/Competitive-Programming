import java.util.*;

public class dasblinkenlights{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int s = sc.nextInt();

        int LCM = lcm(p,q);
        if(LCM <= s){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }

    }

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
}
