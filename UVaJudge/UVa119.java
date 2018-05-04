import java.util.*;
public class UVa119 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int P = in.nextInt();
            
            HashMap<String, Integer> net = new HashMap<String, Integer>();
            String [] people = new String[P];
            
            for(int p = 0; p < P; p++){
                String person = in.next();
                net.put(person, 0);
                people[p] = person;
            }
            in.nextLine();
            
            
            for(int i = 0; i < P; i++){
                String personName = in.next();
                int spendingBound = in.nextInt();
                int givingCNT = in.nextInt();
                int givingTOT = 0;
                
                if(givingCNT == 0){
                    givingTOT = 0;							//avoid division by 0
                }
                else{
                    givingTOT = (spendingBound/givingCNT)*givingCNT;
                }
                
                
                net.put(personName, net.get(personName)-givingTOT);
                
                for(int p = 0; p < givingCNT; p++){
                    String to = in.next();
                    net.put(to, net.get(to)+spendingBound/givingCNT);
                }
            }
            
            for(int i = 0; i < P; i++){
                System.out.println(people[i] + " " + net.get(people[i]));
            }
            in.nextLine();
            if(in.hasNextLine()){
                System.out.print("\n");
            }
            
        }
    }
}
