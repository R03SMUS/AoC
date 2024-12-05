package Solution2023.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3_2 {

    public static int getTal(String line, Integer talIndex) {

        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        String builder = "";

        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                arr.add(i);
                builder = builder + line.charAt(i);
            } else {
                for (Integer tal : arr) {
                    map.put(tal, Integer.parseInt(builder));
                }
                arr = new ArrayList<>();
                builder = "";
            }


        }
        if (arr.size() > 0) {
            for (Integer tal : arr) {
                map.put(tal, Integer.parseInt(builder));
            }
        }


        return map.get(talIndex) == null ? 0 : map.get(talIndex);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day3/input");
        Scanner sc = new Scanner(file);
        int sum = 0;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<ArrayList<Integer>> starlocation = new ArrayList<>();

        ArrayList<ArrayList<Integer>> tallocation = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> talmap = new HashMap<>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());

        }


        for (int i = 0; i < lines.size(); i++) {
            starlocation.add(new ArrayList<>());
            tallocation.add(new ArrayList<>());
            for (int j = 0; j < lines.get(i).length(); j++) {
                int count = 0;
                if (Character.isDigit(lines.get(i).charAt(j))) {
                    continue;
                }
                if (lines.get(i).charAt(j) != '*') {
                    continue;
                }
                if (Character.isDigit(lines.get(i - 1).charAt(j))) {
                    count++;
                } else {
                    if (Character.isDigit(lines.get(i - 1).charAt(j - 1))) {
                        count++;
                    }
                    if (Character.isDigit(lines.get(i - 1).charAt(j + 1))) {
                        count++;
                    }
                }
                if (Character.isDigit(lines.get(i + 1).charAt(j))) {
                    count++;
                } else {
                    if (Character.isDigit(lines.get(i + 1).charAt(j - 1))) {
                        count++;
                    }
                    if (Character.isDigit(lines.get(i + 1).charAt(j + 1))) {
                        count++;
                    }
                }
                if (Character.isDigit(lines.get(i).charAt(j - 1))) {
                    count++;
                }
                if (Character.isDigit(lines.get(i).charAt(j + 1))) {
                    count++;
                }

                if (count == 2) {
                    starlocation.get(i).add(j);
                }
            }
        }
        int match = 0;
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                talmap.put(match, new ArrayList<>());
                if (starlocation.get(i).contains(j)) {

                    if (Character.isDigit(lines.get(i).charAt(j - 1))) {
                        tallocation.get(i).add((j - 1));
                        talmap.get(match).add(i + "," + (j - 1));
                    }

                    if (Character.isDigit(lines.get(i).charAt(j + 1))) {
                        tallocation.get(i).add((j + 1));
                        talmap.get(match).add(i + "," + (j + 1));
                    }

                    if (Character.isDigit(lines.get(i - 1).charAt(j))) {
                        tallocation.get(i - 1).add((j));
                        talmap.get(match).add((i - 1) + "," + j);
                    } else {
                        if (Character.isDigit(lines.get(i - 1).charAt(j - 1))) {
                            tallocation.get(i - 1).add((j - 1));
                            talmap.get(match).add((i - 1) + "," + (j - 1));
                        }
                        if (Character.isDigit(lines.get(i - 1).charAt(j + 1))) {
                            tallocation.get(i - 1).add((j + 1));
                            talmap.get(match).add((i - 1) + "," + (j + 1));
                        }
                    }

                    if (Character.isDigit(lines.get(i + 1).charAt(j))) {
                        tallocation.get(i + 1).add((j));
                        talmap.get(match).add((i + 1) + "," + j);
                    } else {
                        if (Character.isDigit(lines.get(i + 1).charAt(j - 1))) {
                            tallocation.get(i + 1).add((j - 1));
                            talmap.get(match).add((i + 1) + "," + (j - 1));
                        }
                        if (Character.isDigit(lines.get(i + 1).charAt(j + 1))) {
                            tallocation.get(i + 1).add((j + 1));
                            talmap.get(match).add((i + 1) + "," + (j + 1));
                        }
                    }

                    match++;
                }
            }
        }
        System.out.println(talmap);
        System.out.println(starlocation);
        System.out.println(tallocation);
        for(int i = 0; i <talmap.size() -1; i++){
            String line = lines.get(Integer.parseInt(talmap.get(i).get(0).split(",")[0]));
            int talindex = Integer.parseInt(talmap.get(i).get(0).split(",")[1]);
            String line2 = lines.get(Integer.parseInt(talmap.get(i).get(1).split(",")[0]));
            int talindex2 = Integer.parseInt(talmap.get(i).get(1).split(",")[1]);
            sum += getTal(line, talindex) * getTal(line2, talindex2);
        }
        System.out.println(sum);
    }

}

