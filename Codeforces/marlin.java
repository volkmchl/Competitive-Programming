import javafx.util.Pair;
import java.util.*;
import java.io.*;

//prob id: 980B Codeforces Round #480 (Div. 2)

public class marlin{
    public static void main(String[] args) throws Exception{
        Parser ps = new Parser(System.in);
        int n = ps.nextInt();
        int k = ps.nextInt();

        System.out.println("YES");
        for(int i = 0; i < 4; i++){
            if(i == 0 || i == 3){
                for(int j = 0; j < n; j++){
                    System.out.print(".");
                }
            }
            else{
                Set<Integer> colPts = createSymmetry(k, n);
                k -= colPts.size();
                for(int j = 0; j < n; j++){
                    if(colPts.contains(j)){
                        System.out.print("#");
                    }
                    else{
                        System.out.print(".");
                    }
                }
            }

            System.out.println();
        }
    }

    //return a set with column coordinates where hotels should be placed in order to create a symmetry
    //this shall exclude column 0 and last column (n-1)
    public static Set<Integer> createSymmetry(int hotels, int n){

        Set<Integer> colPts = new HashSet<>(); 
        if(hotels % 2 != 0){
            colPts.add(n/2);        //n is an integer, so decimal part will be truncated off, which will result in middle column
            --hotels;
        }

        //guaranteed that hotels is even at this point
        int leftSide = 1;
        int rightSide = (n-(leftSide+1));
        while(hotels > 0){
            colPts.add(leftSide);
            colPts.add(rightSide);

            leftSide++;
            rightSide = (n-(leftSide+1));

            hotels -= 2;
        }

        return colPts;
    }
}

class Parser
{
    final private int BUFFER_SIZE = 1 << 16;

    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Parser(InputStream in)
    {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public long nextLong() throws Exception
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do
        {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg) return -ret;
        return ret;
    }

    //reads in the next string
    public String next() throws Exception
    {
        StringBuilder ret =  new StringBuilder();
        byte c = read();
        while (c <= ' ') c = read();
        do
        {
            ret = ret.append((char)c);
            c = read();
        } while (c > ' ');
        return ret.toString();
    }

    public int nextInt() throws Exception
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do
        {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg) return -ret;
        return ret;
    }

    private void fillBuffer() throws Exception
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() throws Exception
    {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }
}
