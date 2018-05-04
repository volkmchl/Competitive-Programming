import java.util.*;
import java.lang.*;

public class UVa755{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int dataSets = sc.nextInt();
        for(int dataSet = 0; dataSet < dataSets; dataSet++){
            
            int N = sc.nextInt();
            Map<String, Integer> occurences = new HashMap<String, Integer>();
            PriorityQueue<String> numbers = new PriorityQueue<String>();
            HashSet<String> numbersInQueue = new HashSet<String>();
            
            for(int n = 0; n < N; n++){
                String unsanitizedNumber = sc.next();
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < unsanitizedNumber.length(); i++){
                    if(unsanitizedNumber.charAt(i) >= '0' && unsanitizedNumber.charAt(i) <= '9') sb.append(unsanitizedNumber.charAt(i));
                    else if(unsanitizedNumber.charAt(i) >= 'A' && unsanitizedNumber.charAt(i) <= 'Z') sb.append(letterToNumber(unsanitizedNumber.charAt(i)));
                    else if(unsanitizedNumber.length() == 7) break;
                }
                
                String sanitizedNumber = sb.toString();
                if(occurences.containsKey(sanitizedNumber)){
                    occurences.put(sanitizedNumber,occurences.get(sanitizedNumber)+1);
                    if(!numbersInQueue.contains(sanitizedNumber)){
                        numbers.add(sanitizedNumber);
                        numbersInQueue.add(sanitizedNumber);
                    }
                }
                else {
                    occurences.put(sanitizedNumber, 1);
                }
            }
            
            if(dataSet != 0){System.out.println("");}
            if(numbers.isEmpty()){
                System.out.println("No duplicates.");
            }
            else{
                while(!numbers.isEmpty()){
                    String number = numbers.poll();
                    System.out.println(number.substring(0,3) + "-" + number.substring(3) + " " + occurences.get(number));
                }
            }
        }
    }
    
    public static char letterToNumber(char letter){
        
        char number = '0';
        
        switch(letter){
            case 'A':
            case 'B':
            case 'C':
                number = '2';
                break;
            case 'D':
            case 'E':
            case 'F':
                number = '3';
                break;
            case 'G':
            case 'H':
            case 'I':
                number = '4';
                break;
            case 'J':
            case 'K':
            case 'L':
                number = '5';
                break;
            case 'M':
            case 'N':
            case 'O':
                number = '6';
                break;
            case 'P':
            case 'R':
            case 'S':
                number = '7';
                break;
            case 'T':
            case 'U':
            case 'V':
                number = '8';
                break;
            case 'W':
            case 'X':
            case 'Y':
                number = '9';
                break;
        }
        
        return number ;
    }
}

