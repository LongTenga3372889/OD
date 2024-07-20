package leetCode;

public class 得到更多分数的最少关卡数目 {

    public static void main(String[] args) {
        得到更多分数的最少关卡数目 a = new 得到更多分数的最少关卡数目();
        System.out.println(a.minimumLevels(new int[]{0,1,0}));
    }

    public int minimumLevels(int[] possible) {
        int sumNumber = sumNumber(possible);
        if (sumNumber<-2) {
            return 1;
        }
        int sum = sumNumber/2;
        if (sumNumber == -1 || sumNumber == -2) {
            sum = -1;
        }
//        int mod = sumNumber(possible) % 2;
        int index = (possible[0]==0?-1:1);
        for (int i = 1;i<possible.length;i++) {
            if (sum < index) {
                return i;
            }
            index = index + (possible[i]==0?-1:1);
        }
        return -1;
    }

    public int sumNumber(int[] possible){
        int sum = 0;
        for (int i : possible) {
            sum = sum + (i==0?-1:1);
        }
        return sum;
    }

}
