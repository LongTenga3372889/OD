package od.第五题;

import java.util.Arrays;
import java.util.List;

public class 最大宝石购买 {

    public static void main(String[] args) {
        最大宝石购买 a = new 最大宝石购买();
        System.out.println(a.getMaxPayNumber(Arrays.asList(new Integer[]{9,1,1,1,1,1,1,1,1,1}),10));
    }

    public int getMaxPayNumber(List<Integer> list,int money){
        int count = 0;
        int numberMoney = 0;
        int maxCount = 0;
        int deleteCount = 0;
        for (int i = 0;i<list.size();i++) {
            if (numberMoney + list.get(i) <= money) {
                numberMoney = numberMoney + list.get(i);
                count = count + 1;
                maxCount = count;
            } else {
                numberMoney = numberMoney - list.get(deleteCount) + list.get(i);
                deleteCount = deleteCount + 1;
            }
        }
        return maxCount;
    }

}
