package Solution2023.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6_2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day6/input");
        Scanner sc = new Scanner(file);

        String times = sc.nextLine().split(":")[1].trim().replace(" ", "");
        String distances = sc.nextLine().split(":")[1].trim().replace(" ", "");

        int count = 0;
        for(int j = 0; j < Integer.parseInt(times); j++){
            if(j*(Long.parseLong(times)- j)>Long.parseLong(distances)){
                count++;

            }
        }
        System.out.println(count);

    }
}
