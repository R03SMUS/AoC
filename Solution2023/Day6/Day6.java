package Solution2023.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day6/input");
        Scanner sc = new Scanner(file);

        ArrayList<Integer> race = new ArrayList<>();
        //ArrayList<Integer> distance = new ArrayList<>();

        String[] times = sc.nextLine().split(":")[1].trim().split("\s+");
        String[] distances = sc.nextLine().split(":")[1].trim().split("\s+");


        for(int i = 0; i < times.length; i++){
            int count = 0;
            for(int j = 0; j < Integer.parseInt(times[i]); j++){
                if(j*(Integer.parseInt(times[i])- j)>Integer.parseInt(distances[i])){
                    count++;
                }
            }
            race.add(count);
        }
        int sum = 1;
        for(int tal : race){
            sum *= tal;
        }
        System.out.println(sum);

    }
}
