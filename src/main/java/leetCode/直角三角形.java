package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 3128
 */
public class 直角三角形 {

    public static void main(String[] args) {
        直角三角形 a = new 直角三角形();
        long count = a.numberOfRightTriangles(new int[][]{{0,0},{0,1},{1,1}});
        System.out.println(count);
    }

    public long numberOfRightTriangles(int[][] grid) {
        long res = 0;
        Map<Integer,Long> map = new HashMap<>();
        for (int i = 0;i< grid.length;i++) {
            Long lengthOne = null;
            for (int j = 0;j< grid[i].length;j++) {
                if(i == 0) {
                    long rowOne = 0;
                    for(int k = 0;k<grid.length;k++) {
                        if (grid[k][j] == 1) rowOne++;
                    }
                    map.put(j,rowOne);
                }
                if (grid[i][j] == 0) continue;
                if (map.get(j) == 0) continue;
                if (lengthOne == null) {
                    lengthOne = 0L;
                    for (int k = 0;k<grid[i].length;k++) {
                        if (grid[i][k] == 1) lengthOne++;
                    }
                }
                res = res + (lengthOne-1)*(map.get(j)-1);
            }
        }
        return res;
    }

}
