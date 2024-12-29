import java.text.SimpleDateFormat;
import java.util.Date;
public class Task{
  private String dateInString;
  private String name;
  private String deadlineYear;
  private String deadlineMounth;
  private String deadlineDay;
  enum TaskType{
    GOAL, TODO;
  }
  private TaskType taskType;
  public Task(String naame, String year, String mounth, String day){
    deadlineYear = year;
    deadlineMounth = mounth;
    deadlineDay = day;
    name = naame;
  }
  public String getDeadlineDay(){
    return deadlineDay;
  }
  public String getMonth(){
    return deadlineMounth;
  }
  
  public String getYear(){
    return deadlineYear;
  }
  
  public boolean checkDate(){
    Date now = new Date();
    SimpleDateFormat dateFormatter1 = new SimpleDateFormat("y");  //Current year
    SimpleDateFormat dateFormatter2 = new SimpleDateFormat("M");  //Current mounth
    SimpleDateFormat dateFormatter3 = new SimpleDateFormat("d");  //Current day
    
    int y = Integer.parseInt(dateFormatter1.format(now));
    int m = Integer.parseInt(dateFormatter2.format(now));
    int d = Integer.parseInt(dateFormatter3.format(now));
    
    if(Integer.parseInt(deadlineYear)==y &&  Integer.parseInt(deadlineMounth)==m){
      if(d<Integer.parseInt(deadlineDay))
        return true;
      else
        return false;
    }
    return true;  //Return true if the deadline is not passed
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String a){
    name = a;
  }
  
  public void changeDate(int d, int m, int y){
    deadlineYear = Integer.toString(y);
    deadlineDay = Integer.toString(d);
    deadlineMounth = Integer.toString(m);
  }
  
  public String getDate(){
    return deadlineYear+"-"+deadlineMounth+"-"+deadlineDay;
  }
  
  public TaskType getTaskType(){
    return taskType;
  }
  
  public void setTaskType(TaskType a){
    a = taskType;
  }
  public String toString(){
    return "Name: "+getName()+" Deadline Year: "+deadlineYear+" Deadline month: "+deadlineMounth+" Deadline day: "+deadlineDay;
  }
}