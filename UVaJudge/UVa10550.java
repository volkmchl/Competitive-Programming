import java.util.*;

public class UVa10550 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean done = false;
        while(in.hasNextLine()){
            double start = in.nextInt();
            double num1 = in.nextInt();
            double num2 = in.nextInt();
            double num3 = in.nextInt();
            
            if(num1 == 0 && num2 == 0 && num3 == 0){
                break;
            }
            
            double total = 1080 + ((start - num1 + 40) % 40 + (num2 - num1 + 40) % 40 + (num2 - num3 + 40) % 40) * 9 ;
            System.out.println((int)total);
            in.nextLine();
        }
    }
}
