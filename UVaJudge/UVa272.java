import java.util.*;

public class UVa272 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while(in.hasNextLine()){
            String inLine = in.nextLine();
            String outLine = "";
            for(int i = 0; i < inLine.length(); i++){
                if(inLine.charAt(i) == '"'){
                    if(flag){
                        outLine += "``";
                        flag = !flag;
                    }
                    else if(!flag){
                        outLine += "\'\'";
                        flag = !flag;
                    }
                }
                else{
                    outLine += inLine.charAt(i);
                }
            }
            System.out.println(outLine);
        }
        in.close();
    }
}
