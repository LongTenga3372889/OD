package od.第十二题;

public class 转盘寿司 {

    public static void main(String[] args) {
        转盘寿司 a = new 转盘寿司();
        int[] ints = a.createMoney(new int[]{3,14,15,6,5});
        System.out.println(ints);
    }

    public int[] createMoney(int[] ints){
        int[] res = new int[ints.length];
        for(int i = 0;i<ints.length;i++) {
            int one = ints[i];
            int two ;
            if(i == ints.length-1) {
                two = ints[0];
            } else {
                two = ints[i+1];
            }
            if (one>two) {
                res[i] = one+two;
            } else {
                res[i] = one;
            }
        }
        return res;
    }

}
