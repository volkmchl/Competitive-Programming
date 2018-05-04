/*
Could have probably been done in a clearer way.
*/

import java.util.*;
import java.lang.*;
public class UVa230{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String bufferLine = "";
		
		ArrayList<Book> books = new ArrayList<Book>();


		bufferLine = sc.nextLine();
		while(!bufferLine.equals("END")){
			StringBuilder sb = new StringBuilder();
			
			boolean secondMarkIncoming = false;
			
			int i = 0;
			for(i = 0; i < bufferLine.length(); i++){
				if(bufferLine.charAt(i) == '"' && !secondMarkIncoming) secondMarkIncoming = true;
				else if(bufferLine.charAt(i) == '"' && secondMarkIncoming) break;
				else{
					sb.append(bufferLine.charAt(i));
				}
			}
			
			String title = sb.toString();
			sb.delete(0, sb.length());

			i = i + 5;
			for( ; i < bufferLine.length(); i++){
				sb.append(bufferLine.charAt(i));
			}

			String author = sb.toString();
			books.add(new Book(title, author));

			bufferLine = sc.nextLine();

		}

		Collections.sort(books);
		
		Map<String, Integer> bookLocations = new HashMap<String, Integer>();
		for(int i = 0; i < books.size(); i++){
			bookLocations.put(books.get(i).title, i);
		}
		
		boolean[] currentShelf = new boolean[books.size()];
		for(int i = 0; i < books.size(); i++){
			currentShelf[i] = true;
		}

		PriorityQueue<Book> returningBooks = new PriorityQueue<Book>();
		while(sc.hasNextLine()){
			bufferLine = sc.nextLine();
			Scanner commandGetter = new Scanner(bufferLine);
			String command = commandGetter.next();
			if(command.equals("BORROW")){
				String book = bufferLine.substring(8,bufferLine.length()-1);
				currentShelf[bookLocations.get(book)] = false;
			}
			else if(command.equals("RETURN")){
				String book = bufferLine.substring(8,bufferLine.length()-1);
				returningBooks.add(books.get(bookLocations.get(book)));
			}
			else if(command.equals("SHELVE")){
				while(!returningBooks.isEmpty()){
					String book = returningBooks.poll().title;
					currentShelf[bookLocations.get(book)] = true;
					boolean first = true;
					int i = 0;
					for(i = bookLocations.get(book)-1; i >= 0; i--){
						if(currentShelf[i]){first = false; break;}
					}
					System.out.println("Put \"" + book + "\"" +  ((first) ? " first" : " after \"" + books.get(i).title + "\""));
				}
				System.out.println("END");
			}
			else if(command.equals("END")) break;
		}
	}

	public static class Book implements Comparable<Book>{
		String author;
		String title;

		Book(String title, String author){
			this.title = title;
			this.author = author;
		}

		@Override
		public int compareTo(Book other){
			if(this.author.compareToIgnoreCase(other.author) != 0){
				return this.author.compareToIgnoreCase(other.author);
			}
			return this.title.compareToIgnoreCase(other.title);
		}
	}
}
