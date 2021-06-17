package DemoMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DemoKeySet {

    public static void main(String[] args) {

        //创建集合对象
        Map<String, Integer> map = new HashMap<>();
        map.put("kobe", 192);
        map.put("jordon", 195);
        map.put("paul", 183);

        //1.遍历Map集合方法一：通过key值找value值
        //a.使用Map集合中的方法keySet(),把集合中所有的key取出来，存储到一个Set集合
        Set<String> set = map.keySet();

        //b.遍历set集合，获取Map集合中的每一个key
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            //c.通过Map集合中的方法get(key),通过key找value
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }

        //b.使用增强for循环遍历
        for(String key: map.keySet()){
            //c.通过Map集合中的方法get(key),通过key找value
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("-----------------------");

        //2.遍历Map集合方法二：使用entry对象遍历
        //a.使用Map集合中的方法entrySet()，把Map集合中多个Entry对象取出来，存储到一个Set集合
        Set<Map.Entry<String, Integer>> set2 = map.entrySet();

        //b.遍历Set集合，获取每一个Entry对象
        //使用迭代器遍历Set集合
        Iterator<Map.Entry<String, Integer>> it2 = set2.iterator();
        while (it2.hasNext()){
            Map.Entry<String, Integer> entry = it2.next();
            //c.使用Entry对象中的方法getkey()和getvalue()火区键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" +value);
        }
        //iter快捷键可完成
        for (Map.Entry<String, Integer> entry : set2) {
            //c.使用Entry对象中的方法getkey()和getvalue()火区键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" +value);
        }

    }
}
