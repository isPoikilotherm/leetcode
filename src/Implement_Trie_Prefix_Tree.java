import java.util.LinkedHashSet;
import java.util.Set;

public class Implement_Trie_Prefix_Tree {

    private   Set<String> set;
    private  Set<String> preset;

    public Implement_Trie_Prefix_Tree() {
       set=new LinkedHashSet<>();
       preset=new LinkedHashSet<>();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        set.add(word);

        for (int i = 1; i <word.length()+1; i++) {
            String s=word.substring(0,i);
            if (!preset.contains(s)){
                preset.add(s);
            }

        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return set.contains(word);

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return preset.contains(prefix);

    }


}
