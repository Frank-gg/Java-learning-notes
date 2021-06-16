package GameDouDiZhu;

import java.util.ArrayList;
import java.util.Collections;

public class DouDiZhu {

    public static void main(String[] args) {

        //1.准备牌
        String[] color = {"♠","♧","♢","♥"};
        String[] number = {"K","Q","J","10","9","8","7","6","5","4","3","2","A"};
        ArrayList<String> poker = new ArrayList<>();

        //放入牌
        for (String i:color) {
            for (String j:number){
                poker.add(i + j);
            }
        }
        poker.add("大王");
        poker.add("小王");

        //2.洗牌
        Collections.shuffle(poker);
        //System.out.println(poker);

        //3.发牌
        ArrayList<String> people1 = new ArrayList<>();
        ArrayList<String> people2 = new ArrayList<>();
        ArrayList<String> people3 = new ArrayList<>();
        ArrayList<String> DiPai = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            if(i >= 51){
                DiPai.add(poker.get(i));
            }else if(i % 3 == 0){
                people1.add(poker.get(i));
            }else if(i % 3 == 1){
                people2.add(poker.get(i));
            }else if(i % 3 == 2){
                people3.add(poker.get(i));
            }
        }

        //4.看牌
        System.out.println(people1);
        System.out.println(people2);
        System.out.println(people3);
        System.out.println(DiPai);
    }
}
