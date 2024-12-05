package Solution2023.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {

    public static int getTal(String line, Integer talIndex){

        //System.out.println(line);
        //System.out.println(talIndex);

        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        String builder = "";

        for(int i = 0; i < line.length(); i++){
            if(Character.isDigit(line.charAt(i))){
                arr.add(i);
                builder = builder + line.charAt(i);
            } else {
                for(Integer tal : arr){
                    map.put(tal, Integer.parseInt(builder));
                }
                arr = new ArrayList<>();
                builder = "";
            }


        }
        if(arr.size() > 0) {
            for(Integer tal : arr){
                map.put(tal, Integer.parseInt(builder));
            }
        }
        return map.get(talIndex);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day3/input");
        Scanner sc = new Scanner(file);
        int sum = 0;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tallocation = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
            tallocation.add(new ArrayList<>());
        }
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                if (Character.isDigit(lines.get(i).charAt(j))) {
                    continue;
                }
                if (lines.get(i).charAt(j) == '.') {
                    continue;
                }
                try {
                    if (Character.isDigit(lines.get(i - 1).charAt(j - 1))) {
                        tallocation.get(i - 1).add((j - 1));
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (Character.isDigit(lines.get(i - 1).charAt(j))) {
                        tallocation.get(i - 1).add((j));
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (Character.isDigit(lines.get(i - 1).charAt(j + 1))) {
                        tallocation.get(i - 1).add((j + 1));
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (Character.isDigit(lines.get(i).charAt(j - 1))) {
                        tallocation.get(i).add((j - 1));
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (Character.isDigit(lines.get(i).charAt(j + 1))) {
                        tallocation.get(i).add((j + 1));
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (Character.isDigit(lines.get(i + 1).charAt(j - 1))) {
                        tallocation.get(i + 1).add((j - 1));
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (Character.isDigit(lines.get(i + 1).charAt(j))) {
                        tallocation.get(i + 1).add((j));
                    }
                } catch (Exception ignored) {
                }
                try {
                    if (Character.isDigit(lines.get(i + 1).charAt(j + 1))) {
                        tallocation.get(i + 1).add((j + 1));
                    }
                } catch (Exception ignored) {
                }
            }
        }

        ArrayList<ArrayList<Integer>> removes = new ArrayList<>();

        for (int i = 0; i < tallocation.size(); i++) {
            removes.add(new ArrayList<>());
            Collections.sort(tallocation.get(i));
            System.out.println(tallocation.get(i));
            int last = -2;
            for (int j = 0; j < tallocation.get(i).size(); j++) {
                if (tallocation.get(i).get(j) == last + 1) {
                    removes.get(i).add(tallocation.get(i).get(j));
                }
                last = tallocation.get(i).get(j);
            }
            System.out.println(removes.get(i));
        }


        for(int i = 0; i < removes.size(); i++){
            System.out.println(tallocation.get(i));
            for(int j = 0; j <removes.get(i).size(); j++){
                tallocation.get(i).remove(removes.get(i).get(j));
            }
            System.out.println(tallocation.get(i));
        }




        for (int i = 0; i < tallocation.size(); i++) {
            for (int j = 0; j < tallocation.get(i).size(); j++) {
                //System.out.println(i);
                sum += getTal(lines.get(i), tallocation.get(i).get(j));
            }
        }
        System.out.println(sum);
        //System.out.println(tallocation);
    }
}
