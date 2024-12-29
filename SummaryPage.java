import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
public class SummaryPage extends javax.swing.JPanel {
  
  /**
   * Creates new form SummaryPage
   */
  private int successedGoals;
  private ArrayList<Goal> goals;
  private ArrayList<Goal> sGoals;
  private JPanel panel1;
  private JPanel panel2;
  private double sucGoals;
  public SummaryPage() {
    panel1 = new JPanel();
    panel2 = new JPanel();
    sucGoals = 0;
    createComponents();
  }
  
  public void createComponents(){
    goals = UserCollection.getAccessedUser().getGoals();
    sGoals = new ArrayList<Goal>();
    for(int i=0; i<goals.size(); i++){
      if(goals.get(i).getSituation()==true)
        sGoals.add(goals.get(i));
    }
    sucGoals = sGoals.size()*100/goals.size();
    
    setLayout(new GridLayout(1,2));
    panel1.setLayout(new GridLayout(3,1));
    panel2.setLayout(new BorderLayout());
    
    panel1.add(new JLabel("Successful Goals"));
    panel1.add(new JLabel(sGoals.toString()));
    panel1.add(new JLabel("Percentage of success: "+sucGoals));
    add(panel1);
    
    setBackground(new java.awt.Color(240, 253, 255));
    panel1.setBackground(new java.awt.Color(240, 253, 255));
    panel2.setBackground(new java.awt.Color(240, 253, 255));
  }
}