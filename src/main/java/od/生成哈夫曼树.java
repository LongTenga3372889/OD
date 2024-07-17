package od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 生成哈夫曼树 {

    public static void main(String[] args) {
        生成哈夫曼树 a = new 生成哈夫曼树();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        Node node = a.buildNode(list);
        List<Integer> list1 = a.getCenterNumber(node);
        if (list1.size() == 1) {
            System.out.println(list1.get(0));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<list1.size();i++) {
            if(i==0) {
                sb.append(list1.get(2)).append(" ");
                continue;
            } else if (i==2) {
                if (i==list1.size()-1) {
                    sb.append(list1.get(i));
                    continue;
                }
                sb.append(list1.get(0)).append(" ");
                continue;
            }
            if (i==list1.size()-1) {
                sb.append(list1.get(i));
                continue;
            }
            sb.append(list1.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private List<Integer> getCenterNumber(Node node) {
        List<Integer> list = new ArrayList<>();
        if(node.getLeft() == null) {
            list.add(node.getNumber());
            return list;
        } else {
            list.addAll(getCenterNumber(node.getLeft()));
        }
        list.add(node.getNumber());
        if (node.getRight() ==null) {
            return list;
        } else {
            list.addAll(getCenterNumber(node.getRight()));
        }
        return list;
    }

    public Node buildNode(List<Integer> nodeList){
        nodeList.sort(Comparator.comparingInt(o -> o));
        Node node = new Node(nodeList.get(0),null,null);
        if(nodeList.size()==1) {
            return node;
        }
        return buildNode(nodeList,node);
    }

    public Node buildNode(List<Integer> nodeList,Node node) {
        for (int i=1;i<nodeList.size();i++) {
            Node nodeLeft = new Node(nodeList.get(i),null,null);
            node = createNode(nodeLeft,node);
        }
        return node;
    }

    private Node createNode(Node nodeLeft, Node node) {
        return new Node(nodeLeft.getNumber()+node.getNumber(), nodeLeft,node);
    }

}

class Node {

    private Integer number;

    private Node left;

    private Node right;

    public Node(Integer number, Node left, Node right) {
        this.number = number;
        this.left = left;
        this.right = right;
    }

    public Integer getNumber() {
        return number;
    }

    public Node setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Node getLeft() {
        return left;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return this;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node right) {
        this.right = right;
        return this;
    }
}