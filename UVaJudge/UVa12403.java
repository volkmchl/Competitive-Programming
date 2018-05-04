import java.util.*;
public class UVa12403 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int acs = in.nextInt();
        
        int money = 0;
        String command;
        for(int i = 0; i < acs; i++){
            command = in.next();
            if(command.equals("donate")){
                money+= in.nextInt();
                in.nextLine();
            }
            else{
                System.out.println(money);
            }
        }
    }
}
