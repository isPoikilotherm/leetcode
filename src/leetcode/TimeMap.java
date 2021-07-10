package leetcode;

import com.sun.jdi.event.StepEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Struct{
     String key;
     String value;
     int time;
    Struct( String key, String value,int time){
        this.key=key;
        this.value=value;
        this.time=time;
    }
}

public class TimeMap {
    private Map<String, List<Struct>> map;

    public TimeMap() {
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Struct> list=map.getOrDefault(key,new ArrayList<Struct>());
        Struct struct=new Struct(key,value,timestamp);
        list.add(struct);
        map.put(key,list);
    }

    public String get(String key, int timestamp) {
        List<Struct> list=map.get(key);
        if (list.isEmpty()){
            return "";
        }
        int star=0,end=list.size()-1;
        while (star<end){
            int mid=(end+star)/2;
            Struct struct=list.get(mid);
            if (struct.time==timestamp){
                return struct.value;
            }
            if (struct.time<timestamp){
                star=mid+1;
            }
            if (struct.time>timestamp){
                end=mid-1;
            }
        }
        Struct struct=list.get(end);
        if (struct.time<=timestamp){
            return struct.value;
        }else {
            return "";
        }

    }
}
