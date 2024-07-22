package od.one.第十题;

public class 小华最多能得到多少克黄金 {

    private int[][] table;

    private int[] dx = new int[]{1,0,-1,0};

    private int[] dy = new int[]{0,1,0,-1};

    public static void main(String[] args) {
        小华最多能得到多少克黄金 a = new 小华最多能得到多少克黄金();
        int x = 40;//长
        int y = 40;//宽
        int sum = 18;//最大距离
        a.createTable(x,y,sum);
        System.out.println(a.dfs(0,0));
    }

    public int dfs(int x,int y){
        if (errorCell(x,y)) return 0;
        if (table[x][y] == 0) return 0;
        table[x][y] = 0;
        int maxGold = 0;
        for (int i = 0;i<4;i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            maxGold = maxGold + dfs(newX,newY);
        }
        return maxGold + 1;
    }

    private boolean errorCell(int x, int y) {
        if (x<0 || y<0 ||x>=table.length || y>=table[0].length) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void createTable(int x,int y,int sum) {
        this.table = new int[x][y];
        for (int i = 0;i < x; i++) {
            for (int j = 0;j < y; j++) {
                if(sumInteger(i)+sumInteger(j) <=sum) {
                    this.table[i][j] = 1;
                } else {
                    this.table[i][j] = 0;
                }
            }
        }
    }

    public int sumInteger(int integer){
        int sum = 0;
        while (integer / 10 != 0) {
            sum = sum + integer % 10;
            integer = integer/10;
        }
        return sum + integer;
    }

//    public int max(int x,int y,int length){
//        if (length >= (x+y)) {
//            return x*y;
//        }else if (length<=x && length<=y) {
//            //满足斐波那契数列
//            return (length+1)*(length+2)/2;
//        }else if(length <= x || length <= y) {
//            int min = Math.min(x, y);
//            int sum = (length+1)*(length+2)/2;
//            int sub = (length+1-min)*(length-min)/2;
//            return sum-sub;
//        } else {
//            return 0;
//        }
//    }

    public int[][] getTable() {
        return table;
    }

    public 小华最多能得到多少克黄金 setTable(int[][] table) {
        this.table = table;
        return this;
    }
}
