import java.util.*;
import java.lang.StringBuilder;

public class UVa10260{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            String word = sc.next();
            System.out.println(soundex(word));
        }
    }
    
    public static String soundex(String word){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            if(charToDigit(word.charAt(i)) != '0') sb.append(charToDigit(word.charAt(i)));
            while(i+1 < word.length() && charToDigit(word.charAt(i+1)) == charToDigit(word.charAt(i))) i++;
        }
        
        return sb.toString();
        
    }
    
    public static char charToDigit(char in){
        char digit = '0';
        switch(in){
            case 'B':
            case 'F':
            case 'P':
            case 'V':
                digit = '1';
                break;
            case 'C':
            case 'G':
            case 'J':
            case 'K':
            case 'Q':
            case 'S':
            case 'X':
            case 'Z':
                digit = '2';
                break;
            case 'D':
            case 'T':
                digit = '3';
                break;
            case 'L':
                digit = '4';
                break;
            case 'M':
            case 'N':
                digit = '5';
                break;
            case 'R':
                digit = '6';
                break;
        }
        return digit;
    }
}
