
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class MainFrame extends javax.swing.JFrame {
  
  /**
   * Creates new form HomePageFrame
   */
  LoginPanel loginPanel;
  SignUpPanel signUpPanel ;
  HomePage homePage;
  UserCollection userCollection;
  JFrame frame1;
  public MainFrame() {
    userCollection = new UserCollection();
    readTheFile();
    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginPanel = new LoginPanel(this);
    add(loginPanel);
    repaint();
    revalidate();
    setVisible(true);  
  } 
  public UserCollection getUserList(){
    return userCollection;
  }
  public void changePanel()
  {
    if(loginPanel.getLoginPanelCheck()==true){
      remove(loginPanel);
      homePage = new HomePage(this);
      add(homePage);
      setSize(1000,600);
      revalidate();
      repaint();
      setVisible(true);
    }
    else if(loginPanel.getSignUpCheck()==true){
      remove(loginPanel);
      signUpPanel= new SignUpPanel(this);
      add(signUpPanel);
      revalidate();
      repaint();
      setVisible(true);
    }
  }
  public void backToLoginPage(){
    if(signUpPanel.getBackCheck()==true){
      remove(signUpPanel);
      add(loginPanel);
      revalidate();
      repaint();
      setVisible(true);
    }
  }
  public void addToFile(){
    try {
      FileWriter fw = new FileWriter("file.txt");
      try (PrintWriter pw = new PrintWriter(fw)) {
        for (int i = 0 ; i<userCollection.getArrayList().size() ; i++){
          pw.println( userCollection.getArrayList().get(i).getUsername());
          pw.println( userCollection.getArrayList().get(i).getPassword());
          pw.println(userCollection.getArrayList().get(i).getAge());
          pw.println(userCollection.getArrayList().get(i).getWeight());
          pw.println(userCollection.getArrayList().get(i).getHeight());
          pw.println(userCollection.getArrayList().get(i).getGender());
          int a = userCollection.getArrayList().get(i).getGoals().size();
          for(int j = 0; j <a  ; j++)
          {
            pw.print(userCollection.getArrayList().get(i).getGoals().get(j).getName() 
                       + "-" + userCollection.getArrayList().get(i).getGoals().get(j).getDeadlineDay() 
                       + "-" + userCollection.getArrayList().get(i).getGoals().get(j).getMonth()
                       + "-" + userCollection.getArrayList().get(i).getGoals().get(j).getYear()
                       + "-" + userCollection.getArrayList().get(i).getGoals().get(j).getSituation() + "-" + ","); 
          }
          pw.println();
          int b = userCollection.getArrayList().get(i).getToDos().size();
          for(int j = 0; j<b ; j++)
          {
            pw.print(userCollection.getArrayList().get(i).getToDos().get(j).getName() 
                       + "-" + userCollection.getArrayList().get(i).getToDos().get(j).getDeadlineDay() 
                       + "-" + userCollection.getArrayList().get(i).getToDos().get(j).getMonth()
                       + "-" + userCollection.getArrayList().get(i).getToDos().get(j).getYear()
                       + "-" + userCollection.getArrayList().get(i).getToDos().get(j).getHour() 
                       + "-" + userCollection.getArrayList().get(i).getToDos().get(j).getMinute() + ","); 
          }
          pw.println();
        }
      }
    } catch (Exception e) {
    } 
  }
  private void readTheFile() {
    User user1 =  null;
    try{
      File file = new File("file.txt");
      Scanner reader ;
      reader = new Scanner(file);
      String line = reader.nextLine();
      int count = 0;
      String username="";
      String password="";
      int age = -1;
      double weight = -1;
      int height = -1;
      String gender="";
      while (line!=null) 
      { 
        if(count%8==0)
        {
          username = line;
          count++;
        }
        else if(count%8==1)
        {
          password = line;
          count++;
        }
        else if(count%8==2)
        {
          age = Integer.parseInt(line);
          count++;
        }
        else if(count%8==3)
        {
          weight = Double.parseDouble(line);
          count++;
        }
        else if(count%8==4)
        {
          height = Integer.parseInt(line);
          count++;
        }
        else if(count%8==5)
        {
          gender = line;
          user1 =  new User(username,password,age,weight,height,gender);
          userCollection.add(user1);
          System.out.println(user1.toString());
          count++;
        }
        else if(count%8 == 6)
        {
          String goalName="";
          String goalYear="";
          String goalMonth="";
          String goalDay="";
          boolean sucOrFail=false;
          int counter = 0;
          int len = line.length();
          String temp="";
          for(int i=0; i<len; i++){
            if(line.charAt(i)==',')
            {
              Goal goal = new Goal(goalName,goalYear,goalMonth,goalDay);
              goal.setSucOrFail(sucOrFail);
              user1.addNewGoal(goal);
              counter = 0;
              temp = "";
            }
            else if(line.charAt(i)=='-')
            {
              if(counter==0)
              {
                goalName = temp;
                temp = "";
              }
              else if(counter==1)
              {
                goalDay = temp;
                temp = "";
              }
              else if(counter==2)
              {
                goalMonth = temp;
                temp = "";
              }
              else if(counter==3)
              {
                goalYear = temp;
                temp = "";
              }
              else if(counter==4)
              {
                if(temp.equals("false"))
                {
                  sucOrFail = false;
                }
                if(temp.equals("true"))
                {
                  sucOrFail = true;
                }
              }
              counter++;
            }
            else
            {
              temp = temp + line.charAt(i);
            }
          }
          count++;
        }
        else if(count%8 == 7)
        {
          String toDoName="";
          String toDoYear="";
          String toDoMonth="";
          String toDoDay="";
          String hour="";
          String minute="";
          int counter = 0;
          int len = line.length();
          String temp="";
          for(int i=0; i<len; i++)
          {
            if(line.charAt(i)==',')
            {
              ToDo todo = new ToDo(toDoName,toDoYear,toDoMonth,toDoDay,hour,minute);
              user1.addNewToDo(todo);
              counter = 0;
              temp = "";
            }
            else if(line.charAt(i)=='-')
            {
              if(counter==0)
              {
                toDoName = temp;
                temp = "";
              }
              else if(counter==1)
              {
                toDoDay = temp;
                temp = "";
              }
              else if(counter==2)
              {
                toDoMonth = temp;
                temp = "";
              }
              else if(counter==3)
              {
                toDoYear = temp;
                temp = "";
              }
              else if(counter==4)
              {
                hour = temp;
                temp = "";
              }
              else if(counter==5)
              {
                minute = temp;
                temp = "";
              }
              counter++;
            }
            else
            {
              temp = temp + line.charAt(i);
            }
          }
          count++;
        }
        line = reader.nextLine();
      }
    }
    catch (Exception e) {
    }
  }                  
}