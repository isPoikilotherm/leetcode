package leetcode;

import java.util.*;

public class Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int tag = 0;
        int count = tlen;
        int[] min = {0, Integer.MAX_VALUE};
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < tlen; i++) {
            if (tmap.containsKey(t.charAt(i))) {
                tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);
            } else {
                tmap.put(t.charAt(i), 1);
            }
        }
        while (tag < slen && !tmap.containsKey(s.charAt(tag))) {
            tag++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = tag; i < slen; i++) {
            if (tmap.containsKey(s.charAt(i))) {
                if (queue.size() != 0 && s.charAt(i) == s.charAt(queue.peek()) && tmap.get(s.charAt(i)) == 0) {
                    queue.add(i);
                    queue.poll();
                    while (queue.size() != 0 && (!tmap.containsKey(s.charAt(queue.peek())) || tmap.get(s.charAt(queue.peek())) < 0)) {
                        int de = queue.poll();
                        if (tmap.containsKey(s.charAt(de))) {
                            tmap.put(s.charAt(de), tmap.get(s.charAt(de)) + 1);
                            if (tmap.get(s.charAt(i)) > 0) {
                                count++;
                            }
                        }
                    }
                    if (queue.size() != 0 && count == 0 && queue.peekLast() - queue.peek() < min[1] - min[0]) {
                        min[0] = queue.peek();
                        min[1] = queue.peekLast();
                    }
                } else {
                    queue.add(i);
                    tmap.put(s.charAt(i), tmap.get(s.charAt(i)) - 1);
                    if (tmap.get(s.charAt(i)) >= 0) {
                        count--;
                    }
                    if (queue.size() != 0 && count == 0 && queue.peekLast() - queue.peek() < min[1] - min[0]) {
                        min[0] = queue.peek();
                        min[1] = queue.peekLast();
                    }
                }
            } else {
                queue.add(i);
            }
        }
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if (entry.getValue() > 0) {
                return "";
            }
        }
        return s.substring(min[0], min[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
