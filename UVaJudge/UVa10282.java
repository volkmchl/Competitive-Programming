import java.util.*;

public class UVa10282{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<String, String>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("")) break;
            String word[] = line.split(" ");
            map.put(word[1],word[0]);
        }
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(!map.containsKey(line)){System.out.println("eh");}
            else{System.out.println(map.get(line));}
        }
    }
}
