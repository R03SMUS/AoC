package Solution2023.Day2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day2/input");
        Scanner sc = new Scanner(file);

        ArrayList<Integer> arr;
        int sum = 0;

        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split("[:;]");
            int gamrnr = Integer.parseInt(line[0].split(" ")[1]);
            boolean torf = true;

            for(int i = 1; i < line.length; i++){
                String[] nspil = line[i].trim().split(", ");
                System.out.println(Arrays.toString(nspil));
                for(int j = 0; j < nspil.length; j++) {

                    String[] draw = nspil[j].split(" ");

                    System.out.println(draw[0]+ " | " + draw[1]);

                    if (draw[1].contains("red")) {
                        if (Integer.parseInt(draw[0]) > 12) {
                            torf = false;
                        }
                    } else if (draw[1].contains("green")) {
                        if (Integer.parseInt(draw[0]) > 13) {
                            torf = false;
                        }
                    } else if (draw[1].contains("blue")) {
                        if (Integer.parseInt(draw[0]) > 14) {
                            torf = false;
                        }
                    }
                }
            }
            if(torf){
                //System.out.println(gamrnr);
                sum += gamrnr;
            }

        }
        System.out.println(sum);
    }
}

