package Demo;

/*
    要求：模拟注册操作，如果用户名已存在，则抛出异常并提示：该用户名已被注册

    分析：
        1.使用数组保存已注册过得用户名(数据库)；
        2.使用Scanner获取用户输入的注册的用户名(前端，网页)；
        3.定义一个方法，对用户输入中的注册的用户名进行判断
            遍历存储已经注册的用户名的数组，获取每一个用户名
            使用获取到的用户名和用户输入的用户名比较
                true：抛出异常
                false：继续遍历比较
            如果循环结束了，还没有找到重复的用户名，提示用户恭喜您，注册成功！
 */

import java.util.Scanner;

public class DemoRegisterException {

    //1.使用数组保存已注册过得用户名(数据库)；
    static String[] usernames = {"kobe","jordan","paul","durant"};

    public static void main(String[] args) /*throws RegisterException*/ {

        //2.使用Scanner获取用户输入的注册的用户名(前端，网页)；
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入注册名：");
        String username = sc.next();
        checkUsername(username);
    }

    //3.定义一个方法，对用户输入中的注册的用户名进行判断
    public static void checkUsername(String username) /*throws RegisterException*/ {
        //遍历存储已经注册的用户名的数组，获取每一个用户名
        for (String s : usernames) {
            if(s.equals(username)){
                //true：抛出异常
                try {
                    throw new RegisterException("名字已经被注册！");
                } catch (RegisterException e) {
                    e.printStackTrace();
                }
            }
        }

        //如果循环结束了，还没有找到重复的用户名，提示用户注册成功！
        System.out.println("注册成功！");
    }
}
