package od.one.第十三题;

import java.util.*;
import java.util.stream.Collectors;

public class 智能成绩表 {

    public static void main(String[] args) {
        智能成绩表 a = new 智能成绩表();
        Map<String,List<Integer>> map = new HashMap();
        map.put("fangfang",Arrays.asList(95,90));
        map.put("xiaohua",Arrays.asList(88,95));
        map.put("minmin",Arrays.asList(90,95));
        List<String> userList = a.sort(Arrays.asList("yuwen","shuxue"), map,"zongfen");
        System.out.println(userList);
    }

    public List<String> sort(List<String> subList, Map<String,List<Integer>> subMap,String sub){
        List<User> users = new ArrayList<>(subMap.size());
        if (subList.contains(sub)) {
            int index = 0;
            for(int i = 0;i<subMap.size();i++) {
                if(subList.get(i).equals(sub)){
                    index = i ;
                    break;
                }
            }
            for (Map.Entry<String,List<Integer>> entry:subMap.entrySet()) {
                User user = new User(entry.getKey(),entry.getValue().get(index));
                users.add(user);
            }
        }else {
            for (Map.Entry<String,List<Integer>> entry:subMap.entrySet()) {
                User user = new User(entry.getKey(),entry.getValue().stream().mapToInt(Integer::intValue).sum());
                users.add(user);
            }
        }
        users.sort((o1,o2)-> (o2.getFen()-o1.getFen()));
        return users.stream().map(User::getUserName).collect(Collectors.toList());
    }

}

class User {
    private Integer fen;

    private String userName;

    public User(String userName,Integer fen) {
        this.fen = fen;
        this.userName = userName;
    }

    public Integer getFen() {
        return fen;
    }

    public User setFen(Integer fen) {
        this.fen = fen;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}