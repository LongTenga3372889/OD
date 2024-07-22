package od.two.第二题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 篮球游戏 {

    private static final String NO = "NO";

    List<String> ingString = new ArrayList<>();

    public static void main(String[] args) {
        篮球游戏 a = new 篮球游戏();
        String s = a.returnString(Arrays.asList(new String[]{"1","2","3","4"}), Arrays.asList(new String[]{"1","2","3","5"}), 0,0);
        s = a.ingString.size()>0?NO:s;
        System.out.println(s);
    }

    public String returnString(List<String> backBoolList,List<String> resList,int backBoolIndex,int resIndex) {
        if (resIndex == resList.size()) {
            return "";
        }
        if (ingString.contains(resList.get(resIndex))) {
            String resString = resList.get(resIndex);
            if (!ingString.get(0).equals(resString) && !ingString.get(ingString.size()-1).equals(resString)) {
                return NO;
            }
            String res = null;
            if (ingString.get(0).equals(resString)) {
                ingString.remove(0);
                res = "L";
            }
            if (ingString.size()>0 && ingString.get(ingString.size()-1).equals(resString)) {
                ingString.remove(ingString.size()-1);
                res = "R";
            }
            String resReturn = returnString(backBoolList,resList,backBoolIndex,resIndex+1);
            if (NO.equals(resReturn)) {
                return NO;
            }
            return res + resReturn;
        }
        if (backBoolIndex == backBoolList.size()) {
            return "";
        } else {
            ingString.add(backBoolList.get(backBoolIndex));
            return returnString(backBoolList,resList,backBoolIndex+1,resIndex);
        }
    }

}
