package od.第十四题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 直线只需要记录两端
 * 等比三角形的边长比相等，由于题目是没有跳跃的，所以只需要判断边长差值是否相等即可判断是否为一条直线
 */
public class 多段线数据压缩 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tableNodeString = scanner.nextLine();
        String[] tableNodeArray = tableNodeString.split(" ");
        List<TableNode> tableNodes = new ArrayList<>();
        for (int i = 0 ;i<tableNodeArray.length;i=i+2) {
            TableNode tableNode = new TableNode(Integer.parseInt(tableNodeArray[i]),Integer.parseInt(tableNodeArray[i+1]));
            tableNodes.add(tableNode);
        }
        多段线数据压缩 a = new 多段线数据压缩();
        List<TableNode> newTableNode = a.getTableNode(tableNodes);
        StringBuilder sb = new StringBuilder();
        newTableNode.forEach(node-> sb.append(node.getY()).append(" ").append(node.getX()).append(" "));
        System.out.println(sb.toString());
    }

    public List<TableNode> getTableNode(List<TableNode> tableNodes){
        if (tableNodes.size() <= 2) {
            return tableNodes;
        }
        List<TableNode> tableNodeList = new ArrayList<>();
        TableNode firstNode = null;
        Boolean xian = false;
        int dy = 0;
        int dx = 0;
        for (int i = 0 ;i < tableNodes.size() ; i++) {
            if (firstNode == null) {
                firstNode = tableNodes.get(i);
                tableNodeList.add(tableNodes.get(i));
            }else if(xian){
                int newDx = firstNode.getX()-tableNodes.get(i).getX();
                int newDy = firstNode.getY()-tableNodes.get(i).getY();
                if (newDy == dy && newDx == dx) {
                    firstNode = tableNodes.get(i);
                    continue;
                }
                tableNodeList.add(firstNode);
                dx = firstNode.getX() - tableNodes.get(i).getX();
                dy = firstNode.getY() - tableNodes.get(i).getY();
                firstNode = tableNodes.get(i);
                xian = false;
            } else {
                if (dx !=0 || dy!=0) {
                    int newDx = firstNode.getX()-tableNodes.get(i).getX();
                    int newDy = firstNode.getY()-tableNodes.get(i).getY();
                    if (newDy == dy && newDx == dx) {
                        xian = true;
                    } else {
                        dx = firstNode.getX() - tableNodes.get(i).getX();
                        dy = firstNode.getY() - tableNodes.get(i).getY();
                        tableNodeList.add(firstNode);
                    }
                } else {
                    dx = firstNode.getX() - tableNodes.get(i).getX();
                    dy = firstNode.getY() - tableNodes.get(i).getY();
                }
                firstNode = tableNodes.get(i);
            }
        }
        tableNodeList.add(tableNodes.get(tableNodes.size()-1));
        return tableNodeList;
    }

}

class TableNode {

    private Integer y;

    private Integer x;

    public TableNode(Integer y, Integer x) {
        this.y = y;
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public TableNode setY(Integer y) {
        this.y = y;
        return this;
    }

    public Integer getX() {
        return x;
    }

    public TableNode setX(Integer x) {
        this.x = x;
        return this;
    }
}