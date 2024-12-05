package Solution2023.Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day7_2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Solution2023/Day7/input");
        Scanner sc = new Scanner(file);

        int sum = 0;

        HashMap<String, Integer> cardmap = new HashMap<>();

        ArrayList<String> five = new ArrayList<>();
        ArrayList<String> four = new ArrayList<>();
        ArrayList<String> house = new ArrayList<>();
        ArrayList<String> three = new ArrayList<>();
        ArrayList<String> twopair = new ArrayList<>();
        ArrayList<String> onepair = new ArrayList<>();
        ArrayList<String> high = new ArrayList<>();




        while(sc.hasNextLine()){
            String line = sc.nextLine();
            cardmap.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
        }

        HashMap<Character, Character> sortcard = new HashMap<>();
        sortcard.put('2', '!');
        sortcard.put('3', '"');
        sortcard.put('4', '#');
        sortcard.put('5', '$');
        sortcard.put('6', '%');
        sortcard.put('7', '&');
        sortcard.put('8', '(');
        sortcard.put('9', ')');
        sortcard.put('T', '*');
        sortcard.put('Q', ',');
        sortcard.put('K', '-');
        sortcard.put('A', '.');
        sortcard.put('J', ' ');

        for(String card : cardmap.keySet()){
            HashMap<Character, Integer> cardstrength = new HashMap<>();
            cardstrength.put('A', 0);
            cardstrength.put('K', 0);
            cardstrength.put('Q', 0);
            cardstrength.put('J', 0);
            cardstrength.put('T', 0);
            cardstrength.put('9', 0);
            cardstrength.put('8', 0);
            cardstrength.put('7', 0);
            cardstrength.put('6', 0);
            cardstrength.put('5', 0);
            cardstrength.put('4', 0);
            cardstrength.put('3', 0);
            cardstrength.put('2', 0);
            // START HERE
            int antalj = 0;
            for(int i = 0; i < card.length(); i++){
                if(card.charAt(i) == 'J'){
                    antalj++;
                } else {
                    cardstrength.compute(card.charAt(i), (key, val) -> val+1);
                }


            }

            ArrayList<Integer> max = new ArrayList<>();
            for(int i : cardstrength.values()){
                if(i != 0){
                    max.add(i);
                }
            }
            if(max.isEmpty()){
                five.add(card);
                continue;
            }
            Collections.sort(max);
            max.add(max.get(max.size()-1)+antalj);
            max.remove(max.size()-2);
            Collections.reverse(max);

            System.out.println(max);

            if(max.isEmpty()){
                five.add(card);
            }else if(max.get(0)== 5){
                five.add(card);
            } else if(max.get(0) == 4){
                four.add(card);
            } else if(max.get(0) == 3){
                if(max.get(1) == 2){
                    house.add(card);
                } else {
                    three.add(card);
                }
            } else if (max.get(0)== 2){
                if(max.get(1) == 2){
                    twopair.add(card);
                } else {
                    onepair.add(card);
                }
            } else {
                high.add(card);
            }
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                    char char1 = o1.charAt(i);
                    char char2 = o2.charAt(i);

                    if (char1 != char2) {
                        return sortcard.get(char1) - sortcard.get(char2);
                    }
                }
                return Integer.compare(o1.length(), o2.length());
            }
        };

        Collections.sort(high, comparator);
        Collections.sort(onepair, comparator);
        Collections.sort(twopair, comparator);
        Collections.sort(three, comparator);
        Collections.sort(house, comparator);
        Collections.sort(four, comparator);
        Collections.sort(five, comparator);


        System.out.println(high);
        System.out.println(onepair);

        int rank = 1;



        for(int i = 0; i < high.size(); i++){
            sum += cardmap.get(high.get(i)) * rank;
            rank++;
        }
        for(int i = 0; i < onepair.size(); i++){
            sum += cardmap.get(onepair.get(i)) * rank;
            rank++;
        }
        for(int i = 0; i < twopair.size(); i++){
            sum += cardmap.get(twopair.get(i)) * rank;
            rank++;
        }
        for(int i = 0; i < three.size(); i++){
            sum += cardmap.get(three.get(i)) * rank;
            rank++;
        }
        for(int i = 0; i < house.size(); i++){
            sum += cardmap.get(house.get(i)) * rank;
            rank++;
        }
        for(int i = 0; i < four.size(); i++){
            sum += cardmap.get(four.get(i)) * rank;
            rank++;
        }
        for(int i = 0; i < five.size(); i++){
            sum += cardmap.get(five.get(i)) * rank;
            rank++;
        }

        System.out.println(sum);
        System.out.println(cardmap);

    }
}
