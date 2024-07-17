package od;

import java.util.HashMap;
import java.util.Map;

public class 万能字符单词拼写 {

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat","bt","hat","tree"},"atach"));
    }

    public static int countCharacters(String[] words, String chars) {
        Map<Character,Integer> charNumber = new HashMap<>();
        for(char c:chars.toCharArray()) {
            Integer count = charNumber.get(c);
            if (count ==null) {
                count = 0;
            }
            count++;
            charNumber.put(c,count);
        }
        int count = 0;
        for (String word:words) {
            count = count + isStringSuccess(word,charNumber);
        }
        return count;
    }

    private static int isStringSuccess(String word, Map<Character, Integer> charNumber) {
        HashMap<Character,Integer> sourceMap = new HashMap<>();
        int number = charNumber.get('?')==null?0:charNumber.get('?');
        int needNumber = 0;
        for(char c:word.toCharArray()) {
            Integer count = sourceMap.get(c);
            if (count ==null) {
                count = 0;
            }
            count++;
            sourceMap.put(c,count);
        }
        for (Character c:sourceMap.keySet()) {
            Integer cNumber = charNumber.get(c);
            if(cNumber == null) {
                needNumber = needNumber + sourceMap.get(c);
                continue;
            }
            if (cNumber >= sourceMap.get(c)) {
                continue;
            }
            needNumber = needNumber + sourceMap.get(c)-cNumber;
        }
        return number>=needNumber?1:0;
    }
}
