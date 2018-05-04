import java.util.*;

public class UVa10424{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			String name1 = sc.nextLine();
			String name2 = sc.nextLine();

			name1 = name1.toLowerCase();
			name2 = name2.toLowerCase();

			int name1Value = 0;
			int name2Value = 0;

			for(int i = 0; i < name1.length(); i++){
				if(Character.isLetter(name1.charAt(i))){
					name1Value += (int)(name1.charAt(i))-96;
				}
			}

			while(name1Value > 9){
				String bufferDigits = name1Value + "";
				name1Value = 0;
				for(int i = 0; i < bufferDigits.length(); i++){
					name1Value += Integer.parseInt(bufferDigits.charAt(i)+"");
				}
			}

			for(int i = 0; i < name2.length(); i++){
				if(Character.isLetter(name2.charAt(i))){
					name2Value += (int)(name2.charAt(i))-96;
				}
			}

			while(name2Value > 9){
				String bufferDigits = name2Value + "";
				name2Value = 0;
				for(int i = 0; i < bufferDigits.length(); i++){
					name2Value += Integer.parseInt(bufferDigits.charAt(i)+"");
				}
			}

			double ratio = (name1Value > name2Value) ? (double)name2Value/name1Value*100 : (double)name1Value/name2Value*100;
			ratio = Math.round(ratio*100)/100.00;

			System.out.printf("%.2f", ratio);
			System.out.println(" %");
		}
	}
}
