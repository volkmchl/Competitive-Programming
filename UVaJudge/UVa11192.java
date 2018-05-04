import java.util.*;
import java.lang.StringBuilder;

public class UVa11192{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int G = sc.nextInt();
            if (G == 0) break;

            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<Character>();
            String initial = sc.next();
            int shift = initial.length()/G;
            for(int i = 0; i < initial.length();){
                int stop = i+shift;
                for( ; i < initial.length() && i < stop; i++){
                    stack.add(initial.charAt(i));
                }

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
            System.out.println(sb.toString());
        }
    }
}
