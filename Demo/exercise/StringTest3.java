package Exercise;


/*
    获取一个字符串在另一个字符串中出现的次数
    比如：获取”ab“在”abdskjdadabaababa“中出现的次数
*/

import java.util.Scanner;

public class StringTest3 {

    public static int getCount(String mianStr, String subStr){

        int count = 0;
        if(mianStr.length() >= subStr.length()){
            while (mianStr.indexOf(subStr) != -1){
                count++;
                mianStr = mianStr.substring(mianStr.indexOf(subStr) + subStr.length());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串：");
        String mainStr = sc.next();
        System.out.println("输入判断的字符串：");
        String subStr = sc.next();

        int sum = getCount(mainStr, subStr);
        System.out.println("出现次数：" + sum);
    }

}
