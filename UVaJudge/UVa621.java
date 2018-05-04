import java.util.*;

public class UVa621 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        String input;
        for(int t = 0; t < T; t++){
            input = in.nextLine();
            if(input.equals("1") || input.equals("4") || input.equals("78")){
                System.out.println("+");
            }
            else if(input.substring(input.length()-2).equals("35")){
                System.out.println("-");
            }
            else if(input.charAt(0) == '9'){
                System.out.println("*");
            }
            else if(input.substring(0, 3).equals("190")){
                System.out.println("?");
            }
        }
    }
}
