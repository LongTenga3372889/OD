package od.第十一题;

import java.util.HashMap;
import java.util.Map;

public class 密码输入检查 {

    private HashMap<String,Integer> map = new HashMap<>(4);

    private static String SMALL_a_z = "SMALL_a_z";

    private static String SMALL_A_Z = "SMALL_A_Z";

    private static String NUM = "NUM";

    private static String TS = "TS";

    {
        map.put(SMALL_a_z,0);
        map.put(SMALL_A_Z,0);
        map.put(NUM,0);
        map.put(TS,0);
    }

    public static void main(String[] args) {
        密码输入检查 a = new 密码输入检查();
        String res = a.checkPassword("AB<<C<");
        StringBuilder sb = new StringBuilder();
        char[] chars = res.toCharArray();
        for(int i = chars.length-1;i>=0 ;i --) {
            sb.append(chars[i]);
        }
        Boolean flag = true;
        for(Map.Entry<String,Integer> entry :a.map.entrySet()) {
            if(entry.getValue() == 0) flag = false;
        }
        System.out.println(sb+" "+flag);
    }

    public String checkPassword(String password){
        byte[] bytes = password.getBytes();
        StringBuilder sb = new StringBuilder();
        for(int i = bytes.length-1; i >= 0 ; ) {
            if (bytes[i] == '<') {
                int isx = 0;
                while(bytes[i]=='<') {
                    if (i == 0) {
                        i--;
                        break;
                    } else {
                        i--;
                        isx ++ ;
                    }
                }
                i = i -isx;
                continue;
            }
            if (bytes[i] >= 'a' && bytes[i] <= 'z') {
                Integer small_a_z = map.get(SMALL_a_z);
                map.put(SMALL_a_z,small_a_z+1);
                sb.append((char) bytes[i]);
                i--;
                continue;
            }
            if (bytes[i] >= 'A' && bytes[i] <= 'Z') {
                Integer small_A_Z = map.get(SMALL_A_Z);
                map.put(SMALL_A_Z,small_A_Z+1);
                sb.append((char) bytes[i]);
                i--;
                continue;
            }
            if (bytes[i] >= '0' && bytes[i] <= '9') {
                Integer num = map.get(NUM);
                map.put(NUM,num+1);
                sb.append((char) bytes[i]);
                i--;
                continue;
            }
            Integer ts = map.get(TS);
            map.put(TS,ts+1);
            sb.append((char) bytes[i]);
            i--;
        }
        return sb.toString();
    }

}
