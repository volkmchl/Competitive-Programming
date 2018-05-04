import java.util.*;

public class UVa10919{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            
            int numCourses = sc.nextInt();
            if(numCourses == 0) break;
            int numCategor = sc.nextInt();
            
            Set<String> coursesSelected = new HashSet<String>();
            
            for(int i = 0; i < numCourses; i++){
                coursesSelected.add(sc.next());
            }
            
            boolean metRequirements = true;
            for(int i = 0; i < numCategor; i++){
                int courses = sc.nextInt();
                int minimum = sc.nextInt();
                for(int j = 0; j < courses; j++){
                    if(coursesSelected.contains(sc.next())){minimum--;}
                }
                if(minimum > 0) metRequirements = false;
            }
            System.out.println(metRequirements ? "yes" : "no");
        }
    }
}
