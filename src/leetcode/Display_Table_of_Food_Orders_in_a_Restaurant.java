package leetcode;

import java.util.*;

public class Display_Table_of_Food_Orders_in_a_Restaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String,Map<String,Integer>> map=new HashMap<>();
        SortedSet<String> foods=new TreeSet<>();
        SortedSet<Integer> tables=new TreeSet<>();
        for (List<String> list : orders) {
            String table=list.get(1);
            String food=list.get(2);
            tables.add(Integer.valueOf(table));
            foods.add(food);
            Map<String, Integer> foodmap = map.getOrDefault(table,new HashMap<String, Integer>());
            Integer foodcount = foodmap.getOrDefault(food, 0);
            foodmap.put(food,foodcount+1);
            map.put(table,foodmap);
        }
        List<List<String>> ans=new ArrayList<>();
        List<String> list=new ArrayList<>();
        list.add("Table");
        for (String food : foods) {
            list.add(food);
        }
        ans.add(list);

        for (Integer table : tables) {
            List<String> list1=new ArrayList<>();
            list1.add(String.valueOf(table));
            Map<String, Integer> foodmap = map.get(String.valueOf(table));
            for (String food : foods) {
                String count=String.valueOf(foodmap.getOrDefault(food,0));
                list1.add(count);
            }
            ans.add(list1);
        }

        return ans;


    }
}
