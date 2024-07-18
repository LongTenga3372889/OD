package od.第七题;

import java.util.*;

public class 虚拟游戏理财 {

    private Integer maxMoneyInt = 0;

    private String address;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        虚拟游戏理财 a = new 虚拟游戏理财();
        int[] getMoney = new int[]{10,20,30,40,50};
        a.maxMoney(getMoney,new int[]{3,4,5,6,10},new int[]{20,30,20,40,30},100,10);
        List<String> list = Arrays.asList(a.address.split("_"));
        StringBuilder sb = new StringBuilder();
        String kong = " ";
        for (int i = 0;i<getMoney.length;i++) {
            if (i == getMoney.length-1) {
                kong = "";
            }
            if (list.contains(i+"")) {
                sb.append(1).append(kong);
            }else {
                sb.append(0).append(kong);
            }
        }
        System.out.println(sb.toString());
    }

    /**
     *
     * @param getMoney       产品投资回报
     * @param death          产品风险
     * @param maxGetMoney    最大投资额度
     * @param money          拥有资产
     * @param maxDeath       承受最大风险
     */
    public void maxMoney(int[] getMoney,int[] death,int[] maxGetMoney,int money,int maxDeath){
        for (int i = 0; i < getMoney.length; i++) {
            if (death[i]>maxDeath) {
                continue;
            }
            if (maxGetMoney[i]>money) {
                int newMoney = money * getMoney[i];
                functionOne(newMoney, i+"");
            }
            else {
                int newMoney = maxGetMoney[i]*getMoney[i];
                functionOne(newMoney, i+"");
            }
        }
        for (int i =0;i<getMoney.length;i++) {
            if (death[i]>maxDeath) {
                continue;
            }
            for (int j=i+1;j<getMoney.length;j++) {
                if (death[i] + death[j]>maxDeath) {
                    continue;
                }
                if (getMoney[i]>=getMoney[j] ) {
                    if (maxGetMoney[i]>=money) {
                        continue;
                    }
                    int newMoney = maxGetMoney[i]*getMoney[i];
                    newMoney = newMoney +
                            (maxGetMoney[j] > (money - maxGetMoney[i]) ?
                                    (money - maxGetMoney[i])*getMoney[j] :
                                    maxGetMoney[j] * getMoney[j]);
                    functionOne(newMoney,i+"_"+j);
                    continue;
                }
                if(maxGetMoney[j] > money) {
                    continue;
                }
                int newMoney = maxGetMoney[j]*getMoney[j];
                newMoney = newMoney + ((maxGetMoney[i]>(money - maxGetMoney[j])) ?
                        (money-maxGetMoney[j])*getMoney[i] :
                        maxGetMoney[i]*getMoney[i]);
                functionOne(newMoney,i+"_"+j);
            }
        }
    }

    private void functionOne(int newMoney, String address) {
        if (this.address ==null) {
            this.address = address;
        }else {
            this.address = newMoney < maxMoneyInt ? this.address : address;
        }
        maxMoneyInt = newMoney>maxMoneyInt?newMoney:maxMoneyInt;
    }

}
