package od.one.第十五题;

public class 分割均衡字符串 {

    public static void main(String[] args) {
        分割均衡字符串 a = new 分割均衡字符串();
        System.out.println(a.splitString("XXXYYYXYXY"));
    }

    public int splitString(String s){
        int count = 0;
        int x = 0;
        int y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'X') {
                x++;
            }
            if (c == 'Y') {
                y++;
            }
            //每次x与y相等则一定出现了均衡字符串
            if (x == y) {
                count ++;
            }
        }
        return count;
    }

}
