package Solution2023.Day2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2_2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day2/input");
        Scanner sc = new Scanner(file);
        int sum = 0;
        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split("[:;]");
            int gamrnr = Integer.parseInt(line[0].split(" ")[1]);
            boolean torf = true;
            int red = 0;
            int blue = 0;
            int green = 0;
            for(int i = 1; i < line.length; i++){
                String[] nspil = line[i].trim().split(", ");
                for(int j = 0; j < nspil.length; j++) {
                    String[] draw = nspil[j].split(" ");
                    if (draw[1].contains("red")) {
                        red = Math.max(red, Integer.parseInt(draw[0]));
                    } else if (draw[1].contains("green")) {
                        green = Math.max(green, Integer.parseInt(draw[0]));
                    } else if (draw[1].contains("blue")) {
                        blue = Math.max(blue, Integer.parseInt(draw[0]));
                    }
                }
            }
            sum += red * green * blue;
        }
        System.out.println(sum);
    }
}

