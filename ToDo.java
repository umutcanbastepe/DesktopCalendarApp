public class ToDo extends Task{
  
  private String hour;
  private String minute;
  
  public ToDo(String naame, String year, String mounth, String day, String h, String m){
    super(naame, year, mounth, day);
    setTaskType(TaskType.TODO);
    hour = h;
    minute = m;
  }
  
  public String getHour(){
    return hour;
  }
  
  public String getMinute(){
    return minute;
  }
  
  public void setHour(String h){
    hour = h;
  }
  
  public void setMinute(String m){
    minute = m;
  }
}