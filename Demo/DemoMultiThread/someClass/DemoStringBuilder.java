package someClass;

public class DemoStringBuilder {

    public static void main(String[] args) {
        //空参构造方法
        StringBuilder bu1 = new StringBuilder();
        System.out.println("bu1:" + bu1);

        //带参构造方法
        StringBuilder bu2 = new StringBuilder("abc");
        System.out.println("bu2:" + bu2);

    }
}
