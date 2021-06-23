package someClass;

import java.util.Arrays;

public class DemoSystem {

    public static void main(String[] args) {
        //demo01();
        demo02();
    }

    //验证for循环打印1-9999用的时间
    private static void demo01(){
        //程序执行前，获取一次毫秒值
        long s = System.currentTimeMillis();
        //执行for循环
        for (int i = 1; i <= 9999 ; i++) {
            System.out.println(i);
        }
        //执行后再获取一次毫秒值
        long e = System.currentTimeMillis();
        System.out.println("程序共耗时：" + (e - s) + "");
    }

    //将src数组中的前三个元素，复制到dest数组的前三个位置上
    private static void demo02(){
        //定义数组
        int[] src = {1,2,3,4,5};
        int[] dest = {6,7,8,9,10};

        //使用arraycopy方法操作
        System.arraycopy(src, 2, dest, 0,3);

        System.out.println("输出操作后的数组：" + Arrays.toString(dest));
    }
}
