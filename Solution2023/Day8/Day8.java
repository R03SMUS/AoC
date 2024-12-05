package Solution2023.Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day8 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day8/input");
        Scanner sc = new Scanner(file);

        int sum = 0;

        String[] commando = sc.nextLine().split("");
        sc.nextLine();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String et = line.split(" ")[0];
            String to = line.split("[(|,]")[1];
            String tre = line.split("[, )]")[4];
            map.put(et, new ArrayList<>());
            map.get(et).add(to);
            map.get(et).add(tre);
        }

        boolean n = true;
        String start = "AAA";
        while(n){
            for(int i = 0; i < commando.length; i++){
                sum++;
                if(commando[i].equals("L")){
                    start = map.get(start).get(0);
                } else if(commando[i].equals("R")){
                    start = map.get(start).get(1);
                }
                if(start.equals("ZZZ")){
                    n = false;
                    break;
                } else {

                }
            }
        }

        //System.out.println(map);
        System.out.println(sum);



    }
}
