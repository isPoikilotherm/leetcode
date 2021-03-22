public class MyHashMap {

    int[] map=new int[1000000];
    boolean[] isnew=new boolean[1000000];



    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        isnew[key]=true;
        map[key]=value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (isnew[key]==false){
            return -1;
        }else {
            return map[key];
        }

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        isnew[key]=false;

    }
}
