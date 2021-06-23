package Exercise;

import java.util.Arrays;
import java.util.Scanner;

/*
    模拟一个trim方法，去除字符串两端的空格
*/


public class StringTest1 {

    public static String simulateTrim(String str){

        char[] charArray = str.toCharArray();
        int j = 0;
        int k = 0;

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] != 32){
                j = i;
                break ;
            }
        }

        for (int i = charArray.length - 1; i >= 0; i--) {
            if(charArray[i] != 32){
                k = i;
                break;
            }
        }

        char[] charArray1 = Arrays.copyOfRange(charArray, j,k+1);

        return new String(charArray1);
    }

    public static void main(String[] args) {

        //输入字符串
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入你的字符串：");
        //可以输入空格
        scanner.useDelimiter("\n");
        String st = scanner.next();
        System.out.println("你输入的字符串为：" + st);

        //模拟trim
        System.out.println("去掉首位空格：" + "*" + simulateTrim(st) + "*");

    }
}
