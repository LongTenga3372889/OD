package od;

import java.util.HashSet;
import java.util.Set;

public class 精准核算检测 {

    private Set<Integer> set = new HashSet();

    public static void main(String[] args) {
        精准核算检测 a = new 精准核算检测();
        System.out.println(a.test(new int[]{1,2},new int[][]{{1,1,0,1,0},{1,1,0,0,0},{0,0,1,0,1},{1,0,0,1,0},{0,0,1,0,1}}));
    }

    public int test(int[] userList,int[][] userAction){
        for (Integer userId:userList) {
            int count = set.size();
            set.add(userId);
            int newCount = set.size();
            if (count == newCount) {
                continue;
            }
            set.add(userId);
            getUserNumber(userAction,userId);
        }
        for (Integer userId:userList){
            set.remove(userId);
        }
        return set.size();
    }

    private void getUserNumber(int[][] userAction, Integer userId) {
        for (int i = 0;i<userAction.length;i++) {
            if (userAction[userId][i] == 1) {
                int count = set.size();
                set.add(i);
                int newCount = set.size();
                if (count == newCount) {
                    continue;
                }
                getUserNumber(userAction,i);
            }
        }

    }

}
