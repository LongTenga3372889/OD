package od;

/**
 * 题目语义是平衡二叉树
 */
public class 传递悄悄话 {

    static int count = 0;

    public static void main(String[] args) {
        传递悄悄话 a = new 传递悄悄话();
        Integer[] s = new Integer[]{0,9,20,-1,-1,15,7,-1,-1,-1,-1,3,2};
        Node2 node = buildTreeOne(new Node2(s[0]),s,1);
        System.out.println(count);
    }

    private static Node2 buildTreeOne(Node2 node,Integer[] nums,int index) {
        if (node.getNumber() == -1)  {
            return null;
        }
        if (index*2-1>=nums.length) {
            return node;
        }
        node.setL(buildTreeOne(new Node2(nums[index*2-1],node.getSumNumber()),nums, index*2));
        if((index*2)>=nums.length) {
            return node;
        }
        node.setR(buildTreeOne(new Node2(nums[index*2],node.getSumNumber()),nums, index*2+1));
        return node;
    }
}

class Node2 {

    private Integer number;

    private Node2 l;

    private Node2 r;

    private Integer sumNumber;

    public Node2(Integer number) {
        this.number = number;
        this.sumNumber = number;
    }

    public Node2(Integer number,Integer sumNumber) {
        this.number = number;
        this.sumNumber = number + sumNumber;
        传递悄悄话.count = 传递悄悄话.count>this.sumNumber?传递悄悄话.count:this.sumNumber;
    }

    public Node2 setR(Node2 r) {
        this.r = r;
        return this;
    }

    public Integer getSumNumber() {
        return sumNumber;
    }

    public Node2 setSumNumber(Integer sumNumber) {
        this.sumNumber = sumNumber;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Node2 setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Node2 getL() {
        return l;
    }

    public Node2 setL(Node2 l) {
        this.l = l;
        return this;
    }

    public Node2 getR() {
        return r;
    }
}