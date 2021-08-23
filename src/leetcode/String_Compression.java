package leetcode;

public class String_Compression {
    public int compress(char[] chars) {
        int font=0;
        int end=1;
        char now=chars[font];
        int count=1;
        while (end<chars.length){
            if (chars[end]==now){
                count++;
                end++;
            }else {
                chars[font]=now;
                font++;
              if (count>1){
                  String s=String.valueOf(count);
                  for (int i = 0; i < s.length(); i++) {
                      chars[font]=s.charAt(i);
                      font++;
                  }
              }
                now=chars[end];
              count=0;
            }
        }
        chars[font]=now;
        font++;
        if (count>1){
            String s=String.valueOf(count);
            for (int i = 0; i < s.length(); i++) {
                chars[font]=s.charAt(i);
                font++;
            }
        }
        return font;
    }
}
