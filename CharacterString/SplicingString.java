package CharacterString;

public class SplicingString {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3};

        String str = fromArrayToString(arr);
        System.out.println(str);
    }

    public static String fromArrayToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length -1){
                str += "word" + arr[i] + "]";
            }else{
                str += "word" + arr[i] + "#";
            }
        }
        return str;
    }
}
