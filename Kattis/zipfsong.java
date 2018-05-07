import java.util.*;

public class zipfsong{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<Song> songs = new ArrayList<>();

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int n = 1; n <= N; n++){
            long listenedTo = sc.nextLong();
            String songName = sc.next();

            songs.add( new Song(songName, listenedTo*n));
        }

        Collections.sort(songs, Collections.reverseOrder());

        for(int m = 0; m < M; m++){
            System.out.println(songs.get(m).name);
        }

    }
}

class Song implements Comparable<Song>{

    String name;
    Long quality;

    public Song(String name, Long quality){
        this.name = name;
        this.quality = quality;
    }

    @Override
    public int compareTo(Song other) {
        if(this.quality - other.quality < 0){
            return -1;
        }
        else if(this.quality - other.quality == 0){
            return 0;
        }
        return 1;
    }
}
