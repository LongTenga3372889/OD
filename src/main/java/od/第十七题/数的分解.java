package od.第十七题;

public class 数的分解 {

    public static void main(String[] args) {
        数的分解 a = new 数的分解();
        int num = 2;
        int index = a.getIndex(num);
        if (index == 0) {
            System.out.println("N");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(num).append("=");
            if (index % 2 == 0) {
                for (int i = (-1)*(index/2)+1;i<=index/2;i++) {
                    if (i == index/2) {
                        sb.append((num/index)+i);
                    } else {
                        sb.append((num / index) + i).append("+");
                    }
                }
            } else {
                for (int i = (-1)*(index/2);i<=index/2;i++) {
                    if (i == index/2) {
                        sb.append((num/index)+i);
                    } else {
                        sb.append((num / index) + i).append("+");
                    }
                }
            }
            System.out.println(sb.toString());
        }

    }

    public int getIndex(int num) {
        if (num == 2) {
            return 0;
        }
        for(int i = 2;i <= num/2;i++) {
            if (i % 2 != 0) {
                if (num % i == 0) {
                    return i;
                }
            }else {
                if ((num % i) !=0 && (num % i)%(i/2) ==0) {
                    return i;
                }
            }
        }
        return 0;
    }

}
