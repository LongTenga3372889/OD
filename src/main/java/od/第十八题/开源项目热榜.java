package od.第十八题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 开源项目热榜 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer projectCount = Integer.valueOf(scanner.nextLine());
        String projectScan = scanner.nextLine();
        List<Integer> projectScanList = new ArrayList<>();
        for (String s : projectScan.split(" ")) {
            projectScanList.add(Integer.valueOf(s));
        }
        List<项目评分> 项目评分List = new ArrayList<>(projectCount);
        for (int i=0;i<projectCount;i++) {
            String 项目评分String = scanner.nextLine();
            String[] sArray = 项目评分String.split(" ");
            项目评分 project = new 项目评分(sArray[0],Integer.valueOf(sArray[1]),Integer.valueOf(sArray[2]),Integer.valueOf(sArray[3]),Integer.valueOf(sArray[4]),Integer.valueOf(sArray[5]));
            project.setComSum(projectScanList);
            项目评分List.add(project);
        }
        项目评分List.sort((o1,o2)-> {
            if (!o1.getSum().equals(o2.getSum())) {
                return o2.getSum() - o1.getSum();
            } else {
                return o1.getProjectName().compareTo(o2.getProjectName());
            }
        });
        项目评分List.forEach(project-> System.out.println(project.getProjectName()));
    }

}

class 项目评分{

    private String projectName;

    private Integer watch;

    private Integer star;

    private Integer fork;

    private Integer issue;

    private Integer mr;

    private Integer sum;



    public 项目评分(String projectName, Integer watch, Integer star, Integer fork, Integer issue, Integer mr) {
        this.projectName = projectName;
        this.watch = watch;
        this.star = star;
        this.fork = fork;
        this.issue = issue;
        this.mr = mr;
    }

    public String getProjectName() {
        return projectName;
    }

    public 项目评分 setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public Integer getWatch() {
        return watch;
    }

    public 项目评分 setWatch(Integer watch) {
        this.watch = watch;
        return this;
    }

    public Integer getStar() {
        return star;
    }

    public 项目评分 setStar(Integer star) {
        this.star = star;
        return this;
    }

    public Integer getFork() {
        return fork;
    }

    public 项目评分 setFork(Integer fork) {
        this.fork = fork;
        return this;
    }

    public Integer getIssue() {
        return issue;
    }

    public 项目评分 setIssue(Integer issue) {
        this.issue = issue;
        return this;
    }

    public Integer getMr() {
        return mr;
    }

    public 项目评分 setMr(Integer mr) {
        this.mr = mr;
        return this;
    }

    public Integer getSum() {
        return sum;
    }

    public 项目评分 setSum(Integer sum) {
        this.sum = sum;
        return this;
    }

    public void setComSum(List<Integer> projectScanList) {
        int sumWatch = projectScanList.get(0)*this.watch;
        int sumStar = projectScanList.get(1)*this.star;
        int sumFork = projectScanList.get(2)*this.fork;
        int sumIssue = projectScanList.get(3)*this.issue;
        int sumMr = projectScanList.get(4)*this.mr;
        this.sum = sumWatch + sumStar + sumFork + sumIssue + sumMr;
    }
}
