import java.util.*;

//prob: J on 2015 ACM Amman Collegiate Programming Contest

public class candy{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while(T --> 0){
			int N = sc.nextInt();
			int M = sc.nextInt();

			TreeMap <Integer, Integer> ageFreq = new TreeMap<Integer, Integer>();
			TreeMap <Integer, Integer> cdyFreq = new TreeMap<Integer, Integer>();

			for(int n = 0; n < N; n++){
				int age = sc.nextInt();
				if(ageFreq.get(age) == null){
					ageFreq.put(age,1);
				}
				else{
					ageFreq.put(age, ageFreq.get(age)+1);
				}
			}

			for(int m = 0; m < M; m++){
				int candy = sc.nextInt();

				if(candy > 0){
					if(cdyFreq.get(candy) == null){
						cdyFreq.put(candy,1);
					}
					else{
						cdyFreq.put(candy, cdyFreq.get(candy)+1);
					}
				}
			}

			Set ageFreqSet = ageFreq.entrySet();
			Set cdyFreqSet = cdyFreq.entrySet();

			Iterator iterAgeFreq = ageFreqSet.iterator();
			Iterator iterCdyFreq = cdyFreqSet.iterator();

			boolean possibility = true;
			if(cdyFreq.size() == 0) possibility = false;
			while(iterAgeFreq.hasNext() && iterCdyFreq.hasNext()){

				Map.Entry meAGE = (Map.Entry)iterAgeFreq.next();
				int currentAgeClassSize = (int)meAGE.getValue();

				while(iterCdyFreq.hasNext()){

					Map.Entry meCDY = (Map.Entry)iterCdyFreq.next();
					int currentCdyClassSize = (int)meCDY.getValue();


					if(currentCdyClassSize >= currentAgeClassSize) break;
					if(!iterCdyFreq.hasNext()) possibility = false;
				}

				if(iterAgeFreq.hasNext() && !iterCdyFreq.hasNext()){

					possibility = false;
					break;
				}
			}

			if(possibility){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
	}
}
