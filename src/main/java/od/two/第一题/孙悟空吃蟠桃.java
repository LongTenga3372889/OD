package od.two.第一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 孙悟空吃蟠桃 {

    public static void main(String[] args) {
        孙悟空吃蟠桃 a = new 孙悟空吃蟠桃();
        System.out.println(a.minSudu(new Integer[]{2,3,4,5},7));
    }

    public int minSudu(Integer[] quantity,int wait){
        int dif = wait - quantity.length;
        if (dif < 0) {
            return 0;
        }
        List<Integer> quantityList = Arrays.asList(quantity);
        quantityList.sort(Comparator.comparingInt(o -> o));
        if (dif == 0) {
            return quantityList.get(quantity.length-1);
        }
        for (int i = 1;i<quantityList.get(quantityList.size()-1);i++) {
            boolean flag = exitQuantity(quantityList,i,wait);
            if (flag) {
                return i;
            }
        }
        return 0;
    }

    public boolean exitQuantity(List<Integer> quantity,int hours,int wait) {
        int hoursSum = 0;
        for (int i = 0;i<quantity.size();i++) {
            int mod = quantity.get(i)%hours;
            hoursSum = hoursSum + (quantity.get(i)/hours) + (mod==0?0:1);
            if (hoursSum > wait) {
                return false;
            }
        }
        return true;
    }

}
