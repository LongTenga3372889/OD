package od.第十九题;

import java.util.*;

public class 内存冷热标记 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer count = Integer.valueOf(scanner.nextLine());
        String sIndex = scanner.nextLine();
        Integer pin = scanner.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        String[] sIndexArray = sIndex.split(" ");
        for (int i =0 ; i<sIndexArray.length;i++) {
            Integer key = Integer.parseInt(sIndexArray[i]);
            Integer value = map.get(key);
            if (value == null) {
                value = 0;
            }
            value = value + 1;
            map.put(key,value);
            if (value >= pin && !list.contains(key)) {
                list.add(key);
            }
        }
        System.out.println(list.size());
        list.sort(Comparator.comparingInt(o -> o));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
