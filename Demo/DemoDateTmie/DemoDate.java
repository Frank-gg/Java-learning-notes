package DemoDateTmie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoDate {

    //字符串转换为java.sql.Date();
    public void testExer() throws ParseException {

        String birth = "2021-06-24";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    public void testSimpleDateFormat() throws ParseException {

        //实例化SimpleDateFormat：使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期-->字符串
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串-->日期
        String str = "2021-06-24 14:50:00";
        Date da = sdf.parse(str);
        System.out.println(da);
    }


}
