import java.util.*;
public class UVa12577 {
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        Map<String,String> map = new HashMap<String,String>();
        map.put("Hajj", "Hajj-e-Akbar");
        map.put("Umrah", "Hajj-e-Asghar");
        
        String input;
        int i = 1;
        while(in.hasNextLine()){
            input = in.nextLine();
            if(input.equals("*")) break;
            System.out.println("Case " + i++ + ": " + map.get(input));
        }
        
    }
}
