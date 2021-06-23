package someClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class birthdayDate {
    public static void main(String[] args) throws ParseException {

        //键盘输入出生日期
        Scanner sc = new Scanner(System.in);
        System.out.println("输入出生日期，格式为yyyy-MM-dd");
        String birthdayDateString = sc.next();

        //使用DateFormat类的解析方法，把字符串解析为Date格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = sdf.parse(birthdayDateString);

        //把Date格式的出生日期转换为毫秒值
        long birthdayDateTime = birthdayDate.getTime();

        //获取当前的日期，转换为毫秒值
        long todayTime = new Date().getTime();

        //使用当前日期的毫秒值 - 出生日期的毫秒值
        long time = todayTime - birthdayDateTime;

        //把毫秒值的差值转换为天（s/1000/60/60/24）
        System.out.println(time/1000/60/60/24);
    }
}
