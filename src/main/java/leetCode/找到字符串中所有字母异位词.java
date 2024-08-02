package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 找到字符串中所有字母异位词 {

    Map<Character,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        找到字符串中所有字母异位词 a = new 找到字符串中所有字母异位词();
        List<Integer> s = a.findAnagrams("baa","aa");
        s.forEach(System.out::println);
    }

    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()<s.length()) {
            return new ArrayList<>();
        }
        char[] chars = p.toCharArray();
        for (char c:chars) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        char[] sChars = s.toCharArray();
        char[] sourceChars = s.substring(0,p.length()).toCharArray();
        Map<Character,Integer> firstMap = new HashMap<>();
        for (char source:sourceChars) {
            firstMap.put(source,firstMap.getOrDefault(source,0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int index = sourceChars.length;index<s.length();index++) {
            boolean loop = true;
            for(Map.Entry<Character,Integer> value:map.entrySet()) {
                if(!value.getValue().equals(firstMap.get(value.getKey()))) {
                    loop = false;
                    continue;
                }
            }
            Character delete = sChars[index-sourceChars.length];
            firstMap.put(delete, firstMap.getOrDefault(delete,0)-1);
            Character add = sChars[index];
            firstMap.put(add,firstMap.getOrDefault(add,0)+1);
            if(loop) {
                list.add(index-sourceChars.length);
            }

        }
        boolean loop = true;
        for(Map.Entry<Character,Integer> value:map.entrySet()) {
            if(!value.getValue().equals(firstMap.get(value.getKey()))) {
                loop = false;
                continue;
            }
        }
        if(loop) {
            list.add(s.length()-p.length());
        }
        return list;
    }


}
