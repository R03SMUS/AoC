package Solution2023.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4_2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day4/input");
        Scanner sc = new Scanner(file);
        int sum = 0;
        ArrayList<String> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> countcard = new HashMap<>();
        ArrayList<HashMap<Integer, ArrayList<Integer>>> last = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> winning = new ArrayList<>();
            ArrayList<Integer> number = new ArrayList<>();
            int point = 0;
            String[] card = input.get(i).split("[:|]");
            String game = card[0];
            String[] winningnr = card[1].trim().split("\s+");
            String[] numbers = card[2].trim().split("\s+");
            for (String num : winningnr) {
                winning.add(Integer.parseInt(num));
            }
            int count = 0;
            for (String num : numbers) {
                if (winning.contains(Integer.parseInt(num))) {
                    count++;
                }
            }
            for (int j = 1; j <= count; j++) {
                number.add(i + 1 + j);
            }
            countcard.put(i + 1, 1);
            map.put(i + 1, number);
        }
        for (int i = 1; i < map.size() + 1; i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                for(int n = countcard.get(i); n > 0; n--){
                    countcard.compute(map.get(i).get(j), (key, val) -> (val + 1));
                }
            }
        }
        for(int key : countcard.keySet()){
            sum += countcard.get(key);
        }
        System.out.println(sum);
    }
}
