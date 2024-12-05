package Solution2023.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day5/input");
        Scanner sc = new Scanner(file);
        int sum = 0;

        ArrayList<Long> seeds = new ArrayList<>();

        HashMap<Long, Long> seedtosoil = new HashMap<>();
        HashMap<Long, Long> seedtosoilrange = new HashMap<>();

        HashMap<Long, Long> soiltofert = new HashMap<>();
        HashMap<Long, Long> soiltofertrange  = new HashMap<>();

        HashMap<Long, Long> ferttowater = new HashMap<>();
        HashMap<Long, Long> ferttowaterrange = new HashMap<>();

        HashMap<Long, Long> watertolight = new HashMap<>();
        HashMap<Long, Long> watertolightrange = new HashMap<>();

        HashMap<Long, Long> lighttotemp = new HashMap<>();
        HashMap<Long, Long> lighttotemprange = new HashMap<>();

        HashMap<Long, Long> temptohumid = new HashMap<>();
        HashMap<Long, Long> temptohumidrange = new HashMap<>();

        HashMap<Long, Long> humidtolocation = new HashMap<>();
        HashMap<Long, Long> humidtolocationrange = new HashMap<>();



        HashMap<Long, Long> seedslocation = new HashMap<>();

        String[] seed = sc.nextLine().replace("seeds: ", "").split(" ");
        for (String n : seed) {
            seeds.add(Long.parseLong(n));
        }
        System.out.println(seeds);

        int count = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isBlank()) {
                count++;
                sc.nextLine();//titel
                continue;
            }
            String[] values = line.split(" ");

            //System.out.println(Arrays.toString(values));

            Long start = Long.parseLong(values[1]);
            Long map = Long.parseLong(values[0]);
            Long range = Long.parseLong(values[2]);

            if (count == 1) {
                seedtosoil.put(start, map);
                seedtosoilrange.put(start, range);
            } else if (count == 2) {
                soiltofert.put(start, map);
                soiltofertrange.put(start, range);
            } else if (count == 3) {
                ferttowater.put(start, map);
                ferttowaterrange.put(start, range);
            } else if (count == 4) {
                watertolight.put(start, map);
                watertolightrange.put(start, range);
            } else if (count == 5) {
                lighttotemp.put(start, map);
                lighttotemprange.put(start, range);
            } else if (count == 6) {
                temptohumid.put(start,map);
                temptohumidrange.put(start, range);
            } else if (count == 7) {
                humidtolocation.put(start, map);
                humidtolocationrange.put(start, range);
            }
        }

        for(Long i : seeds) {
            Long temp = i;
            for(Long j : seedtosoilrange.keySet()){
                if(temp >= j && temp <= j + seedtosoilrange.get(j)){
                    temp = seedtosoil.get(j) + (temp - j);
                    break;
                }
            }

            for(Long j : soiltofertrange.keySet()){
                if(temp >= j && temp <= j + soiltofertrange.get(j)){
                    temp = soiltofert.get(j) + (temp - j);
                    break;
                }
            }

            for(Long j : ferttowaterrange.keySet()){
                if(temp >= j && temp <= j + ferttowaterrange.get(j)){
                    temp = ferttowater.get(j) + (temp - j);
                    break;
                }
            }

            for(Long j : watertolightrange.keySet()){
                if(temp >= j && temp <= j + watertolightrange.get(j)){
                    temp = watertolight.get(j) + (temp - j);
                    break;
                }
            }

            for(Long j : lighttotemprange.keySet()){
                if(temp >= j && temp <= j + lighttotemprange.get(j)){
                    temp = lighttotemp.get(j) + (temp - j);
                    break;
                }
            }

            for(Long j : temptohumidrange.keySet()){
                if(temp >= j && temp <= j + temptohumidrange.get(j)){
                    temp = temptohumid.get(j) + (temp - j);
                    break;
                }
            }

            for(Long j : humidtolocationrange.keySet()){
                if(temp >= j && temp <= j + humidtolocationrange.get(j)){
                    temp = humidtolocation.get(j) + (temp - j);
                    break;
                }
            }




            seedslocation.put(i, temp);
        }

        long min = Long.MAX_VALUE;
        for(Long i : seedslocation.values()){
            min = Math.min(i, min);
        }


        System.out.println(seedslocation);
        System.out.println("---");
        System.out.println(min);

    }
}
