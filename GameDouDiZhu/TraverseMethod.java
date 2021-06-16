package GameDouDiZhu;

import java.util.ArrayList;
import java.util.Iterator;

public class TraverseMethod {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        //1.for循环遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //2.创建迭代器Iterator遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //3.增强for循环遍历
        for (String i:list) {
            System.out.println(i);
        }
    }
}
