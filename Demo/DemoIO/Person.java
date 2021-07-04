package DemoIO;

import java.io.Serializable;

/*
* 可序列化需要要求：
* 1.需要实现接口：Serializable；
* 2.当前类需要提供一个全局常亮：serialVersionUID
* 3.除了当前Person类需要实现Serializable接口之外，还必须
*   保证其他内部所有属性也必须是可序列化的。
*   （默认情况下，基本数据类型都是可序列化的）
* 4.ObjectOutputStream与ObjectInputStream类不能序列化static与transient修饰的成员变量
* */
public class Person implements Serializable {

    public static final long serialVersionUID = 45462315645L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
