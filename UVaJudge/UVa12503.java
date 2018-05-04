import java.util.*;
public class UVa12503 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            int C = in.nextInt();
            in.nextLine();
            String commands[] = new String[C];
            int p = 0;
            for(int c = 0; c < C; c++){
                commands[c] = in.nextLine();
                if(commands[c].equals("LEFT")){
                    p--;
                }
                else if(commands[c].equals("RIGHT")){
                    p++;
                }
                else{
                    String [] full = (commands[c].split(" "));
                    commands[c] = commands[Integer.parseInt(full[2])-1];
                    if(commands[c].equals("LEFT")){
                        p--;
                    }
                    else{
                        p++;
                    }
                }
                
            }
            System.out.println(p);
        }
    }
}
