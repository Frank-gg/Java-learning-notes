package DemoDateTmie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    练习：三天打渔两天晒网
*/

public class ExerciseDate {

    public static void testDay(String str) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = sdf.parse(str);

        long time = date.getTime();

        //计算天数
        time = time/1000/60/60/24;

        //判断该打渔还是晒网
        if(time % 5 == 1 || time % 5 == 2 || time % 5 == 3){
            System.out.println("今天该打渔！");
        }
        if (time % 5 == 4 || time % 5 == 0 ){
            System.out.println("今天该晒网！");
        }
    }

    public static void main(String[] args) {

        //键盘输入日期
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你想计算日期，格式为：yyyy-MM-dd hh-mm-ss");
        String str = sc.next();

        //调用方法
        try {
            testDay(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
