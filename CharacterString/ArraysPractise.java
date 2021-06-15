package CharacterString;

import java.util.Arrays;

public class ArraysPractise {

    public static void main(String[] args) {
        String str = "jdiasodjDOIDIA2893ada";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }
}
