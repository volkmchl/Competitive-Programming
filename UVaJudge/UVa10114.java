import java.util.*;

public class UVa10114 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()){
            int M = in.nextInt();
            double D = in.nextDouble();
            double L = in.nextDouble();
            int dCnt = in.nextInt();
            
            if(M < 0 ){
                break;
            }
            
            double dVal[][] = new double[dCnt][2];
            for(int i = 0; i < dCnt; i++){
                dVal[i][0] = in.nextInt();
                dVal[i][1] = in.nextDouble();
            }
            
            double carValue = (D+L)-(D+L)*dVal[0][1];
            
            int months = 0;
            int index = months+1 > dCnt-1 ? 0 : months+1;
            double bufferDepreciation = dVal[0][1];
            double payment = L/M;
            while(L > carValue){
                if(dVal[index][0] == (int)(++months)){
                    bufferDepreciation = dVal[index][1];
                    index = index + 1 > dCnt-1 ? index : index+1;
                }
                carValue = carValue - carValue*bufferDepreciation;
                L = L - payment;
            }
            
            System.out.println(months + (months == 1 ? " month" : " months"));
            
            in.nextLine();
        }
    }
}
