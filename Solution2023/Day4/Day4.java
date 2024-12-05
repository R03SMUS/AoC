package Solution2023.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day4/input");
        Scanner sc = new Scanner(file);

        int sum = 0;

        ArrayList<String> input = new ArrayList<>();

        while(sc.hasNextLine()){
            input.add(sc.nextLine());
        }
        for(int i = 0; i < input.size(); i++){
            ArrayList<Integer> winning = new ArrayList<>();
            ArrayList<Integer> number = new ArrayList<>();
            int point = 0;
            String[] card = input.get(i).split("[:|]");
            String game = card[0];
            String[] winningnr = card[1].trim().split("\s+");
            String[] numbers = card[2].trim().split("\s+");

            for(String num : winningnr){
                winning.add(Integer.parseInt(num));
            }
            for(String num : numbers){
                if(winning.contains(Integer.parseInt(num))){
                    if(point == 0){
                        point++;
                    } else {
                        point *= 2;
                    }
                }
            }
            sum += point;
        }
        System.out.println(sum);
    }
}
