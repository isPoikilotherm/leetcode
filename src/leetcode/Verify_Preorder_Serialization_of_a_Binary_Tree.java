package leetcode;

public class Verify_Preorder_Serialization_of_a_Binary_Tree {

    public static boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;


    }

    public static void main(String[] args) {
       boolean b= isValidSerialization("9,#,92,#,#");
        System.out.println(b);

    }



}
