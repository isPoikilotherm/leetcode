package leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        int font=0,end=chars.length-1;
        Set<Character> set=new LinkedHashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        while (font<end){
            while ((!set.contains(chars[font]))&&font<end){
                font++;
            }
            while ((!set.contains(chars[end]))&&font<end){
                end--;
            }
            char ch=chars[font];
            chars[font]=chars[end];
            chars[end]=ch;
            font++;
            end--;
        }
        String s1=String.valueOf(chars);
        return s1;

    }
}
