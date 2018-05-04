import java.util.*;
public class nizovi{
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        String toProcess = in.nextLine();
        int space = 0;
        Queue<Character> q = new LinkedList<Character>();
        
        for(int i = 0; i < toProcess.length(); i++){
            
            if(toProcess.charAt(i) == ','){
                
                if(q.isEmpty()){
                    continue;
                }
                
                for(int j = 0; j < space; j++){
                    System.out.print(" ");
                }
                while(!q.isEmpty()){
                    System.out.print(q.poll());
                }
                if(i+1 < toProcess.length() && toProcess.charAt(i+1) != '}'){
                    System.out.println(",");
                }
                else{
                    System.out.println("");
                }
                continue;
            }
            
            if(toProcess.charAt(i) == '{'){
                for(int j = 0; j < space; j++){
                    System.out.print(" ");
                }
                System.out.println("{");
                space++;
                space++;
            }
            
            else if(toProcess.charAt(i) == '}'){
                
                if(!q.isEmpty()){
                    for(int j = 0; j < space; j++){
                        System.out.print(" ");
                    }
                    while(!q.isEmpty()){
                        System.out.print(q.poll());
                    }
                    System.out.println("");
                }
               
				space--;
                space--;
                
                for(int j = 0; j < space; j++){
                    System.out.print(" ");
                }
                if(i+1 < toProcess.length() && toProcess.charAt(i+1) == ','){
                    System.out.println("},");
                }
                else{
                    System.out.println("}");
                }
                
                
            }
            
            else{
                q.add(toProcess.charAt(i));
            }
        }
    }
}
