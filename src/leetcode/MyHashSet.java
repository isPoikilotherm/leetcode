package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

    List<Integer>  set;

    /** Initialize your data structure here. */
    public MyHashSet() {
        set=new ArrayList<>();
    }

    public void add(int key) {
        if (!set.contains(key)){
            set.add(key);
        }

    }
    public void remove(int key) {
        if (set.contains(key)){
            set.remove((Integer)key);
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set.contains(key);
    }
}
