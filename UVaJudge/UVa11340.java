import java.util.*;
import java.io.*;

public class UVa11340{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] token = line.split(" ");
        int T = Integer.parseInt(token[0]);

        for(int t = 0; t < T; t++){
            line = reader.readLine();
            token = line.split(" ");
            int C = Integer.parseInt(token[0]);

            Map<Character, Integer> valueTable = new HashMap<Character, Integer>();
            for(int c = 0; c < C; c++){
                line = reader.readLine();
                token = line.split(" ");
                char character = token[0].charAt(0);
                int value = Integer.parseInt(token[1]);
                
                valueTable.put(character,value);
            }

            line = reader.readLine();
            token = line.split(" ");
            int L = Integer.parseInt(token[0]);

            double totalValue = 0;
            for(int l = 0; l < L; l++){
                line = reader.readLine();
                String words[] = line.split(" ");

                for(int w = 0; w < words.length; w++){
                    for(int c = 0; c < words[w].length(); c++){
                        if(valueTable.get(words[w].charAt(c)) != null) totalValue += valueTable.get(words[w].charAt(c));
                    }
                }
            }

            totalValue = totalValue/100;
            System.out.printf("%.2f", totalValue);
            System.out.println("$");
        }
    }
}
