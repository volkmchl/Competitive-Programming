import java.util.*;

public class UVa353 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(in.hasNextLine()){
			String toProcess = in.nextLine();
			int counter = 0;
			Set<String> palindromes = new HashSet<String>();
			for(int i = toProcess.length()-1; i >= 0; i--){
				for(int j = 0; j < toProcess.length()-i; j++){
					if(checkPali(toProcess.substring(i, i+j+1))){
						palindromes.add(toProcess.substring(i, i+j+1));
					}
				}
			}
			System.out.println("The string '"+ toProcess + "' contains " + palindromes.size() +" palindromes.");
		}
	}

	static boolean checkPali(String word){
		for(int i = 0; i < word.length()/2; i++){
			if(word.charAt(i) != word.charAt(word.length()-(i+1))){
				return false;
			}
		}
		return true;
	}
}
