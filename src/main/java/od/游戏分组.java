package od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1、分成2组，分组数据的和都枚举出来
 * 2、降数据组集合排序
 * 3、比较
 */
public class 游戏分组 {

    List<Integer>[][] pair;
    int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        游戏分组 a = new 游戏分组();
        System.out.println(a.myGroup(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    private int myGroup(int[] ints) {
        int h = 0;
        int sum = Arrays.stream(ints).sum();
        int hoop = ints.length/2;
        List<Integer>[] left = new ArrayList[hoop+1];
        List<Integer>[] right = new ArrayList[hoop+1];
        for(int i=0;i<=hoop;i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }
        left[0].add(0);
        right[0].add(0);
        for (int i = 0;i<hoop;i++) {
            for(int j = i;j>=0;j--) {
                for(Integer a:left[j]){
                    left[j+1].add(a + ints[i]);
                }
                for(Integer a:right[j]) {
                    right[j+1].add(a + ints[i+hoop]);
                }
            }
        }
        for(int i = 0;i<=hoop;i++) {
            int leftCount = i;
            int rightCount = hoop-i;
            List<Integer> leftList = left[leftCount].stream().sorted().collect(Collectors.toList());
            List<Integer> rightList = right[rightCount].stream().sorted().collect(Collectors.toList());
            int L = 0;
            int R = rightList.size() - 1;
            while (L<leftList.size() && R>=0) {
                int sumNumber = leftList.get(L) + rightList.get(R);
                if (sumNumber<sum/2) {
                    L++;
                } else {
                    R--;
                }
                h = Math.min(h, Math.abs(sum - 2 * sumNumber));
            }
        }
        return h;

    }






























    public int minimumDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        int m = nums.length / 2;
        int ans = Integer.MAX_VALUE;
        Set<Integer>[] left = new HashSet[m + 1];
        Set<Integer>[] right = new HashSet[m + 1];
        for (int i = 0; i < m + 1; i++) {
            left[i] = new HashSet();
            right[i] = new HashSet();
        }
        left[0].add(0);
        right[0].add(0);
        for (int i = 0; i < m; i++) {
            for (int j = i; j >= 0; j--) {
                for (int a : left[j]) {
                    left[j + 1].add(a + nums[i]);
                }
                for (int a : right[j]) {
                    right[j + 1].add(a + nums[i + m]);
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            int cntLeft = i;
            int cntRight = m - i;
            ArrayList<Integer> lList = new ArrayList<>(left[cntLeft].stream().sorted().collect(Collectors.toList()));
            ArrayList<Integer> rList = new ArrayList<>(right[cntRight].stream().sorted().collect(Collectors.toList()));
            int L = 0;
            int R = rList.size() - 1;
            while (L < lList.size() && R >=0) {
                int v = lList.get(L) + rList.get(R);
                if (v < target) {
                    L++;
                } else {
                    R--;
                }
                ans = Math.min(ans, Math.abs(sum - 2 * v));
            }
        }
        return ans;
    }

}
