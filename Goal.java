import java.awt.*;
public class Goal extends Task{
  private boolean situation;
  public Goal(String naame, String year, String mounth, String day){
    super(naame, year, mounth, day);
    setTaskType(TaskType.GOAL);
  }
  public void setSucOrFail(boolean a){
    situation = a;
  }
  public boolean getSituation(){
    return situation;
  }
}