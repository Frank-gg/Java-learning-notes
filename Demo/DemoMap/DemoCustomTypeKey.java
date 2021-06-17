package DemoMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DemoCustomTypeKey {

    public static void main(String[] args) {
        //show01();
        show02();
    }

    private static void show01() {
        //创建HashMap集合
        HashMap<String, Person> map = new HashMap<>();
        //往集合里添加元素
        map.put("北京", new Person("张三", 18));
        map.put("上海", new Person("李四", 18));
        map.put("广州", new Person("王五", 18));
        map.put("北京", new Person("赵六", 18));
        //使用keySet()与增强for循环遍历Map集合
        Set<String> set = map.keySet();
        for (String key : set) {
            Person value = map.get(key);
            System.out.println(key + "-->" + value);
        }
    }

    private static void show02(){
        //创建HashMap集合
        HashMap<Person, String> map1 = new HashMap<>();
        //往集合里添加元素
        map1.put(new Person("张三", 18), "北京");
        map1.put(new Person("李四", 18), "上海");
        map1.put(new Person("王五", 30), "广州");
        map1.put(new Person("张三", 18), "重庆");
        //使用entrySet()与增强for循环遍历Map集合
        Set<Map.Entry<Person, String>> set2 = map1.entrySet();
        for (Map.Entry<Person, String> Entry : set2) {
            Person key = Entry.getKey();
            String value = Entry.getValue();
            System.out.println(key + "  -->  " + value);
        }

    }

}
