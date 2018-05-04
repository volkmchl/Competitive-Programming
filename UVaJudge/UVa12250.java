import java.util.*;

public class UVa12250 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Map<String,String> lang = new HashMap<String,String>();
        lang.put("HELLO", "ENGLISH");
        lang.put("HOLA", "SPANISH");
        lang.put("HALLO", "GERMAN");
        lang.put("BONJOUR", "FRENCH");
        lang.put("CIAO", "ITALIAN");
        lang.put("ZDRAVSTVUJTE", "RUSSIAN");
        
        
        int i = 1;
        while(in.hasNextLine()){
            String input = in.nextLine();
            if(input.equals("#")) break;
            
            if(lang.get(input) == null){
                System.out.println("Case " + i++ + ": UNKNOWN");
            }
            else{
                System.out.println("Case " + i++ + ": "+ lang.get(input));
            }
            
        }
    }
}
