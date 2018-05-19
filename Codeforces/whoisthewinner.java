import java.util.*;

public class whoisthewinner {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int i = 0; i < cases; i++){
			int numTeams = in.nextInt();

			Team winningTeam = new Team(in.next(), in.nextInt(),in.nextInt());

			for(int j = 1; j < numTeams; j++){
				String newName = in.next();
				int newScore = in.nextInt();
				int penalty = in.nextInt();
				
				if(newScore > winningTeam.score){
					winningTeam = new Team(newName, newScore, penalty);
				}
				else if(newScore == winningTeam.score && penalty < winningTeam.penalty){
					winningTeam = new Team(newName, newScore, penalty);
				}
				
			}
			
			System.out.println(winningTeam.name);
			
		}
	}
}

class Team{
	String name;
	int score, penalty;
	
	Team(){
		
	}
	
	Team(String name, int score, int penalty){
		this.name = name;
		this.score = score;
		this.penalty = penalty;
	}
}
