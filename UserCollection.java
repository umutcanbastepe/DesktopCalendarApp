import java.util.ArrayList;
import java.util.Arrays;
public class UserCollection {
    private ArrayList<User> users;
    private static User accessedUser;
    public UserCollection(){
        users = new ArrayList<User>();
    }
    public void add(User user){
        users.add(user);
    }
    public void remove(User user){
        users.remove(user);
    }
    public void setAccessed(User a){
      accessedUser = a;
    }
    public static User getAccessedUser(){
      return accessedUser;
    }
    public ArrayList<User> getArrayList()
    {
        return users;
    }
}
