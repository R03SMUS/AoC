package Solution2023.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5_2 { //backwards search inspired by Thore Husfeldt teams comment, idea not generate entirely by me :*
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day5/input");
        Scanner sc = new Scanner(file);
        int sum = 0;

        HashMap<Long, Long> seeds = new HashMap<>();

        HashMap<Long, Long> seedtosoil = new HashMap<>();
        HashMap<Long, Long> seedtosoilrange = new HashMap<>();

        HashMap<Long, Long> soiltofert = new HashMap<>();
        HashMap<Long, Long> soiltofertrange = new HashMap<>();

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
        for (int m = 0; m < seed.length; m += 2) {
            seeds.put(Long.parseLong(seed[m]), Long.parseLong(seed[m + 1]));
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

            Long start = Long.parseLong(values[1]);
            Long map = Long.parseLong(values[0]);
            Long range = Long.parseLong(values[2]);

            if (count == 1) {
                seedtosoil.put(map, start);
                seedtosoilrange.put(map, range);
            } else if (count == 2) {
                soiltofert.put(map, start);
                soiltofertrange.put(map, range);
            } else if (count == 3) {
                ferttowater.put(map, start);
                ferttowaterrange.put(map, range);
            } else if (count == 4) {
                watertolight.put(map, start);
                watertolightrange.put(map, range);
            } else if (count == 5) {
                lighttotemp.put(map, start);
                lighttotemprange.put(map, range);
            } else if (count == 6) {
                temptohumid.put(map, start);
                temptohumidrange.put(map, range);
            } else if (count == 7) {
                humidtolocation.put(map, start);
                humidtolocationrange.put(map, range);
            }
        }
        Long a = 0L;
        boolean b = true;
        while (b) {
            long temp = a(a, humidtolocationrange, humidtolocation, temptohumidrange, temptohumid, lighttotemprange, lighttotemp, watertolightrange, watertolight, ferttowaterrange, ferttowater, soiltofertrange, soiltofert, seedtosoilrange, seedtosoil);
            for (Long tal : seeds.keySet()) {
                //System.out.println("===");
                //System.out.println(temp);
                //System.out.println(tal + " " + (seeds.get(tal) + tal));
                if (temp >= tal && temp <= seeds.get(tal) + tal) {
                    System.out.println(a);
                    b = false;
                }
            }
            a++;
        }
        //System.out.println(a);
    }

    public static long a(Long tal,
                         HashMap<Long, Long> humidtolocationrange,
                         HashMap<Long, Long> humidtolocation,
                         HashMap<Long, Long> temptohumidrange,
                         HashMap<Long, Long> temptohumid,
                         HashMap<Long, Long> lighttotemprange,
                         HashMap<Long, Long> lighttotemp,
                         HashMap<Long, Long> watertolightrange,
                         HashMap<Long, Long> watertolight,
                         HashMap<Long, Long> ferttowaterrange,
                         HashMap<Long, Long> ferttowater,
                         HashMap<Long, Long> soiltofertrange,
                         HashMap<Long, Long> soiltofert,
                         HashMap<Long, Long> seedtosoilrange,
                         HashMap<Long, Long> seedtosoil) {

        Long temp = tal;
        //System.out.println(temp);
        for (Long j : humidtolocationrange.keySet()) {
            if (temp >= j && temp <= j + humidtolocationrange.get(j)) {
                temp = humidtolocation.get(j) + (temp - j);
                break;
            }
        }
        //System.out.println(temp);
        for (Long j : temptohumidrange.keySet()) {
            if (temp >= j && temp <= j + temptohumidrange.get(j)) {
                temp = temptohumid.get(j) + (temp - j);
                break;
            }
        }
        //System.out.println(temp);
        for (Long j : lighttotemprange.keySet()) {
            if (temp >= j && temp <= j + lighttotemprange.get(j)) {
                temp = lighttotemp.get(j) + (temp - j);
                break;
            }
        }
        //System.out.println(temp);
        for (Long j : watertolightrange.keySet()) {
            if (temp >= j && temp <= j + watertolightrange.get(j)) {
                temp = watertolight.get(j) + (temp - j);
                break;
            }
        }
        //System.out.println(temp);
        for (Long j : ferttowaterrange.keySet()) {
            if (temp >= j && temp <= j + ferttowaterrange.get(j)) {
                temp = ferttowater.get(j) + (temp - j);
                break;
            }
        }
        //System.out.println(temp);
        for (Long j : soiltofertrange.keySet()) {
            if (temp >= j && temp <= j + soiltofertrange.get(j)) {
                temp = soiltofert.get(j) + (temp - j);
                break;
            }
        }
        //System.out.println(temp);
        for (Long j : seedtosoilrange.keySet()) {
            if (temp >= j && temp <= j + seedtosoilrange.get(j)) {
                temp = seedtosoil.get(j) + (temp - j);
                break;
            }

        }
        //System.out.println(temp);
        return temp;

    }
}


