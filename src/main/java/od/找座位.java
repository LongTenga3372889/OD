package od;


public class 找座位 {

    public static void main(String[] args) {
        找座位 a = new 找座位();
        System.out.println(a.getMaxUser("0010001000010000"));
    }

    public int getMaxUser(String address){
        if(address.length()<1) {
            return 0;
        }
        char[] cArray = address.toCharArray();
        int count = 0;
        int int0 = 0;
        boolean first = false;
        for (char c:cArray) {
            if (c == '0') {
                int0 = int0+1;
            } else {
                if (!first) {
                    count = int0/2;
                } else {
                    count = count + (int0+1)/2 -1;
                }
                int0 = 0;
                first = true;
            }
        }
        if (int0>=2) {
            count = count + int0/2;
        }
        return count;
    }

}
