package Solution2023.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day1/input");
        Scanner sc = new Scanner(file);

        ArrayList<Integer> arr;
        int sum = 0;

        while(sc.hasNextLine()){
            arr = new ArrayList<>();
            String line = sc.nextLine();
            for(int i = 0; i < line.length(); i++){
                if(Character.isDigit(line.charAt(i))){
                    arr.add(Integer.parseInt(String.valueOf(line.charAt(i))));
                }
            }
            if (arr.size() == 1){
                sum += arr.get(0) * 11;
            } else {
                sum += arr.get(0) * 10 + arr.get(arr.size() - 1);
            }
            System.out.println(sum);

        }
        System.out.println(sum);

    }
}
