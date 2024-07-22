package od.one.第十六题;

public class 螺旋数字矩阵 {

    public static void main(String[] args) {
        螺旋数字矩阵 a = new 螺旋数字矩阵();
        int[][] table = a.getTable(3,5);
        for (int[] tableR:table) {
            StringBuilder sb = new StringBuilder();
            for (int i:tableR) {
                sb.append(i == 0?"*":i).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public int[][] getTable(int nums,int r){
        int l = getLine(nums,r);
        int[][] table = new int[r][l];
        int num = 1;
        int x = 0;
        int y = 0;
        String f = "left";
        while (num <= nums) {
            table[x][y] = num;
            if ("left".equals(f)) {
                if ( y+1 < l && table[x][y+1] == 0) {
                    y = y + 1;
                } else {
                    f = "down";
                    x = x + 1;

                }
            } else if ("down".equals(f)) {
                if (x + 1 < r && table[x+1][y] == 0) {
                    x = x + 1;
                } else {
                    f = "right";
                    y = y - 1;
                }
            } else if ("right".equals(f)) {
                if (y - 1 >= 0 && table[x][y-1] == 0) {
                    y = y - 1;
                } else {
                    f = "up";
                    x = x -1;
                }
            } else {
                if (x - 1 >= 0 && table[x-1][y] == 0) {
                    x = x - 1;
                } else {
                    f = "left";
                    y = y + 1;
                }
            }
            num ++;
        }
        return table;
    }

    private int getLine(int nums, int r) {
        int l = nums/r;
        if(nums % r ==0) {
            return l;
        } else {
            return l+1;
        }
    }

}
