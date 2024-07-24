package od.two.第三题;

import java.util.*;

public class 石头剪刀布游戏 {

    private Map<String,List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer count = Integer.valueOf(scanner.nextLine());
        List<User> user = new ArrayList<>();
        for (int i = 0 ;i<count;i++) {
            String s = scanner.nextLine();
            String[] array = s.split(" ");
            User user1 = new User(array[0],array[1]);
            user.add(user1);
        }
        石头剪刀布游戏 a = new 石头剪刀布游戏();
        System.out.println(a.game(user));
    }

    public String game(List<User> userList) {
        userList.forEach(user -> {
            List<String> stringList = map.get(user.getGameChoose());
            if (stringList == null) {
                stringList = new ArrayList<>();
            }
            stringList.add(user.getName());
            map.put(user.getGameChoose(), stringList);
        });
        if (map.size() != 2) {
            return "NULL";
        }
        Set<String> set = map.keySet();
        List<String> res = null;
        if (set.contains("A")) {
            res = map.get("C");
            if (res == null) {
                res = map.get("A");
            }
        } else if (set.contains("B")) {
            res = map.get("A");
            if (res == null) {
                res = map.get("B");
            }
        } else {
            res = map.get("B");
            if (res == null) {
                res = map.get("C");
            }
        }
        res.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        res.forEach(r -> {sb.append(r + "\n");});
        return sb.toString();
    }

}

class User {

    private String name;

    private String gameChoose;

    public User(String name, String gameChoose) {
        this.name = name;
        this.gameChoose = gameChoose;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getGameChoose() {
        return gameChoose;
    }

    public User setGameChoose(String gameChoose) {
        this.gameChoose = gameChoose;
        return this;
    }
}