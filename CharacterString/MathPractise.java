package CharacterString;

public class MathPractise {

    public static void main(String[] args) {
        double min = -10.8;
        double max = 5.9;
        min = Math.ceil(min);
        max = Math.floor(max);

        int num = 0;
        for (int i = (int)min; i < (int)max; i++) {
            int abs = Math.abs(i);
            if(abs > 6 || abs < 2.1){
                num++;
                System.out.print("  " + i);
            }
        }
        System.out.println();
        System.out.println("  一共有" + num + "个数");
    }
}
