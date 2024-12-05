package Solution2023.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1_2 {



    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day1/input");
        Scanner sc = new Scanner(file);
        Map<Integer, Integer> arr;
        //pos tal
        int sum = 0;
        while(sc.hasNextLine()){
            arr = new HashMap<>();
            String line = sc.nextLine();
            for(int i = 0; i < line.length(); i++){
                if(Character.isDigit(line.charAt(i))){
                    arr.put(i, Integer.parseInt(String.valueOf(line.charAt(i))));
                }
            }
            if(line.contains("one")){
                arr.put(line.indexOf("one"), 1);
                arr.put(line.lastIndexOf("one"), 1);
            }
            if(line.contains("two")){
                arr.put(line.indexOf("two"), 2);
                arr.put(line.lastIndexOf("two"), 2);
            }
            if(line.contains("three")){
                arr.put(line.indexOf("three"), 3);
                arr.put(line.lastIndexOf("three"), 3);
            }
            if(line.contains("four")){
                arr.put(line.indexOf("four"), 4);
                arr.put(line.lastIndexOf("four"), 4);
            }
            if(line.contains("five")){
                arr.put(line.indexOf("five"), 5);
                arr.put(line.lastIndexOf("five"), 5);
            }
            if(line.contains("six")){
                arr.put(line.indexOf("six"), 6);
                arr.put(line.lastIndexOf("six"), 6);
            }
            if(line.contains("seven")){
                arr.put(line.indexOf("seven"), 7);
                arr.put(line.lastIndexOf("seven"), 7);
            }
            if(line.contains("eight")){
                arr.put(line.indexOf("eight"), 8);
                arr.put(line.lastIndexOf("eight"), 8);
            }
            if(line.contains("nine")){
                arr.put(line.indexOf("nine"), 9);
                arr.put(line.lastIndexOf("nine"), 9);
            }
            System.out.println(arr);
            int et = Integer.MAX_VALUE;
            int to = Integer.MIN_VALUE;
            for(int tal: arr.keySet()) {
                et = Math.min(et, tal);
                to = Math.max(to, tal);
            }
            sum += arr.get(et) * 10 + arr.get(to);
        }
        System.out.println(sum);
    }
}
