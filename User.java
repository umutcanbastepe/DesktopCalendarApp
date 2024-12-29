
import java.util.ArrayList;
public class User {
      //properties
  private int age;
  private double weight;
  private int height;
  private String username;
  private String password;
  private Gender gender;
  private double calorieAmount;
  private ArrayList<Goal> goals;
  private ArrayList<ToDo> todos;
  private double leftCalorie;
  public enum Gender
  {
    Male, Female
  }
  //constructor
  public User(String username,String password,int age, double weight,int height,String gender)
  {
    setAge(age);
    setWeight(weight);
    setHeight(height);
    setUsername(username);
    setPassword(password);
    this.gender = Gender.valueOf(gender);
    calculateDailyCalorieAmount();
    goals = new ArrayList<Goal>();
    todos = new ArrayList<ToDo>();
    leftCalorie=getDailyCalorieAmount();
  }


  public void setAge(int age)
  {
    this.age = age;
  }
  public int getAge()
  {
    return age;
  }
  public void setWeight(double weight)
  {
    this.weight = weight;
  }
  public double getWeight()
  {
    return weight;
  }
  public void setHeight(int height)
  {
    this.height = height;
  }
  public int getHeight()
  {
    return height;
  }
  public void setUsername(String username)
  {
    this.username = username;
  }
  public String getUsername()
  {
    return username;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  public String getPassword()
  {
    return password;
  }
  public Gender getGender()
  {
    return gender;
  }
  public void calculateDailyCalorieAmount()
  {
    if(gender==Gender.Male)
    {
      calorieAmount = 66 + ( 13.75 * getWeight() ) + ( 5 * getHeight() ) - ( 6.8 * getAge() );
    }
    if(gender==Gender.Female)
    {
      calorieAmount = 66 + ( 9.6 * getWeight() ) + ( 1.7 * getHeight() ) - ( 4.7 * getAge() );
    }
  }
  public double getDailyCalorieAmount()
  {
    return calorieAmount;
  }
  
  public ArrayList<Goal> getGoals(){
    return goals;
  }
  
  public void addNewGoal(Goal a){
    goals.add(a);
  }
  
  public void removeGoal(Goal a){
    goals.remove(a);
  }
  
  public ArrayList<ToDo> getToDos(){
    return todos;
  }
  
  public void addNewToDo(ToDo a){
    todos.add(a);
  }
  
  public void removeToDo(ToDo a){
    todos.remove(a);
  }
  
  public double returnLeftCalorie(){
    return leftCalorie;
  }
  
  public void setLeftCalorie(double a){
    leftCalorie = a;
  }
  
  @Override
  public String toString()
  {
    return "Username: " + username + "\nWeight: " + weight + " kg" +  "\nHeight: " + height + " cm " + "\nAge: " + age;
  }
}
