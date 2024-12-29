import javax.swing.*;
import java.awt.*;
import java.util.*;
public class YearlyPage extends javax.swing.JPanel {
  
  private ArrayList<MonthlyCalendar> months;
  private MainFrame frame ;
  public YearlyPage(MainFrame f) {
    frame = f;
    createComponents();
  }
  
  public void createComponents(){
    months = new ArrayList<MonthlyCalendar>();
    setLayout(new GridLayout(3,4));
    
    for(int i=0; i<12; i++){
      months.add(new MonthlyCalendar(i,frame));
      add(months.get(i));
    }
  }
}