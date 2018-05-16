import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

//prob id: 984B

public class mineswepper{

    static int[] dx = {1, -1, 0,  0, 1,  1, -1, -1};
    static int[] dy = {0,  0, 1, -1, 1, -1,  1, -1};

    public static void main(String[] args) throws Exception{
        Parser sc = new Parser(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] field = new char[n][m];

        for(int i = 0; i < n; i++){
            field[i] = sc.next().toCharArray();
        }

        boolean valid = true;
        for(int i = 0; i < n && valid; i++){
            for(int j = 0; j < m && valid; j++){

                if(field[i][j] == '.'){
                    for(int k = 0; k < 8; k++){
                        int adjI = dy[k] + i;
                        int adjJ = dx[k] + j;
                        if(adjI >= 0 && adjI < n && adjJ >= 0 && adjJ < m){
                            if(field[adjI][adjJ] == '*'){
                                valid = false;
                                break;
                            }
                        }
                    }
                }
                else if(field[i][j] == '*') continue;

                else{
                    int num = Character.getNumericValue(field[i][j]);
                    int totalBombs = 0;
                    for(int k = 0; k < 8; k++){
                        int adjI = dy[k] + i;
                        int adjJ = dx[k] + j;
                        if(adjI >= 0 && adjI < n && adjJ >= 0 && adjJ < m){
                            if(field[adjI][adjJ] == '*'){
                               totalBombs++;
                            }
                        }
                    }
                    if(totalBombs != num){
                        valid = false;
                        break;
                    }

                }


            }
        }

        System.out.println(valid ? "YES" : "NO");


    }

    static class Parser
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
}


