package DemoMap;

import java.util.*;

/*
斗地主案例有序版本
1.准备牌
2.洗牌
3.发牌
4.排序
5.看牌
*/
public class DouDiZhuGame {

    public static void main(String[] args) {
        //1.创建牌

        //创建一个Map集合，存储牌的索引和组装好的牌
        HashMap<Integer, String> poker = new HashMap<>();

        //创建一个List集合，存储牌的索引,用来洗牌
        ArrayList<Integer> pokerIndex = new ArrayList<>();

        //定义两个集合，存储花色和牌的序号(1.9可以用of方法)
        //List<String>  colors = List.of("♠","♧","♢","♥");
        String[] color1 = {"♠","♧","♢","♥"};
        String[] numbers1 = {"K","Q","J","10","9","8","7","6","5","4","3","2","A"};
        ArrayList<String> color = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();
        for (String s : color1) {
            color.add(s);
        }
        for (String s : numbers1) {
            number.add(s);
        }

        //把大小王放进集合中，定义一个牌的索引
        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;

        //循环嵌套遍历两个集合，组装52张牌，存储到集合中
        for (String s : color) {
            for (String s1 : number) {
                poker.put(index,s+s1);
                pokerIndex.add(index);
                index++;
            }
        }
        //System.out.println(poker);
        //System.out.println(pokerIndex);

        //2.洗牌 使用Collections中的方法shuffle(List)
        Collections.shuffle(pokerIndex);

        //3.发牌
        ArrayList<Integer> people1 = new ArrayList<>();
        ArrayList<Integer> people2 = new ArrayList<>();
        ArrayList<Integer> people3 = new ArrayList<>();
        ArrayList<Integer> DiPai = new ArrayList<>();
        //遍历索引集合，获取索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer j = pokerIndex.get(i);
            if(j >= 51){
                DiPai.add(j);
            }else if(j % 3 == 0){
                people1.add(j);
            }else if(j % 3 == 1){
                people2.add(j);
            }else if(j % 3 == 2){
                people3.add(j);
            }
        }

        //4.排序 使用Collections中的方法sort(List)
        Collections.sort(people1);
        Collections.sort(people2);
        Collections.sort(people3);
        Collections.sort(DiPai);

        //5.看牌 定义一个方法
        lookPoker("付观", poker, people1);
        lookPoker("凌基伟", poker, people1);
        lookPoker("何港", poker, people1);
        lookPoker("底牌", poker, DiPai);

    }

    public static void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
        /*查表法：
                遍历玩家或者底牌集合，获取牌的索引
                使用牌的索引，去Map集合中，找到对应的牌
        */
        //输出玩家名字不换行
        System.out.print(name + ": ");
        //遍历玩家或者底牌集合，获取牌的索引
        for (Integer key : list) {
            //使用牌的索引 去Map集合中，找到对应的值
            String value = poker.get(key);
            System.out.print(value + " ");
        }
        System.out.println();//打印一位玩家的牌 换行
    }
}
