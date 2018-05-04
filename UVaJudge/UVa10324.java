import java.util.*;
import java.lang.*;
public class UVa10324{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int currentCase = 1;
        while(sc.hasNext()){
            char[] string = sc.next().toCharArray();
            if(string.length == 0){
                break;
            }
            int Q = sc.nextInt();
            System.out.println("Case " + currentCase++ + ":");
            for(int q = 0; q < Q; q++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                int i = Math.min(x,y);
                int j = Math.max(x,y);
                char begin = string[i];
                boolean same = true;
                for(int small = i+1; small <= j; small++){
                    if(string[small] != begin){
                        same = false;
                        break;
                    }
                }
                System.out.println(same ? "Yes" : "No");
            }
        }
    }
}
