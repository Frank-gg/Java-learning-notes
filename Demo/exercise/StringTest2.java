package Exercise;


import java.util.Scanner;

/*
    将一个字符串进行反转。
    将字符串中指定部分进行反转。比如"abcdefg"反转为"abfedcg"

    方法一：char数组
    方式二：String拼接

*/

public class StringTest2 {

    //方式一：char[]数组
    public static String reverse(String str, int startIndex, int endIndex){

        char[] ch = str.toCharArray();
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
        return new String(ch);
    }

    //方式二：String拼接
    public static String reverse2(String str, int startIndex, int endIndex){

        String st = str.substring(0, startIndex);
        String st2 = str.substring(endIndex + 1, str.length() + 1);

        for (int i = endIndex; i >= startIndex; i--) {
            st += str.charAt(i);
        }
        return st + st2;
    }

    //方式三：使用StringBuffer/StringBuilder替换String
    public static String reverse3(String str, int startIndex, int endIndex){

        StringBuilder builder = new StringBuilder(str.length());

        builder.append(str.substring(0, startIndex));

        for (int i = endIndex; i >= startIndex; i--) {
            builder.append(str.charAt(i));
        }

        builder.append(str.substring(endIndex + 1));

        return builder.toString();
    }

    public static void main(String[] args) {

        //键盘输入字符串，以及想要反转的索引
        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串：");
        String str = sc.next();
        System.out.println("请输入想反转的位置：");
        int startIndex = sc.nextInt();
        int endIndex = sc.nextInt();

        //调用反转方法
        String st = reverse(str, startIndex, endIndex);
        System.out.println("反转字符串：" + st);
        System.out.println("-------------------------");
        String s = reverse2(str, startIndex, endIndex);
        System.out.println("反转字符串：" + s);

    }
}
