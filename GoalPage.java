import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GoalPage extends JPanel implements ActionListener{
  
  private JPanel upPanel;
  private JPanel downPanel;
  private JPanel addGoalPanel;
  private JLabel mygoals;
  private JButton addGoal;
  private JButton add;
  private JTextField goalName;
  private JTextField day;
  private JTextField month;
  private JTextField year;
  private ArrayList<Goal> goals;
  private ArrayList<JRadioButton> buttons;
  private Color color = new Color(0, 0, 0);
  private MainFrame frame;
  public GoalPage(MainFrame f){
    goals = UserCollection.getAccessedUser().getGoals();
    createComponents();
    addComponents();
    setBackground(new java.awt.Color(240, 253, 255));
    upPanel.setBackground(new java.awt.Color(240, 253, 255));
    downPanel.setBackground(new java.awt.Color(240, 253, 255));
    addGoalPanel.setBackground(new java.awt.Color(240, 253, 255));
    frame=f;
  }
  
  public void createComponents(){
    setLayout(new BorderLayout());
    upPanel = new JPanel();
    upPanel.setLayout(new BorderLayout());
    downPanel = new JPanel();
    addGoalPanel = new JPanel();
    downPanel.setLayout(new GridLayout(1,1));
    mygoals = new JLabel("         My Goals(to set successfull, click to the goal)");
    mygoals.setFont(new Font("sa", Font.PLAIN, 18));
    mygoals.setForeground(color);
    addGoal = new JButton("Add a Goal");
    buttons = new ArrayList<JRadioButton>();
    addGoalPanel.setLayout(new GridLayout(5,5));
    add = new JButton("Add");
    goalName = new JTextField();
    year = new JTextField();
    month = new JTextField();
    day = new JTextField();
    addGoalPanel.add(new JLabel("Goal name: "));
    addGoalPanel.add(goalName);
    addGoalPanel.add(new JLabel("Deadline year: "), year);
    addGoalPanel.add(year);
    addGoalPanel.add(new JLabel("Deadline month: "), month);
    addGoalPanel.add(month);
    addGoalPanel.add(new JLabel("Deadline day: "), day);
    addGoalPanel.add(day);
    addGoalPanel.add(add);
    
  }
  
  public void addComponents(){
    add(upPanel, BorderLayout.NORTH);
    add(downPanel, BorderLayout.CENTER);
    upPanel.add(mygoals, BorderLayout.WEST);
    upPanel.add(addGoal, BorderLayout.EAST);
    for(int j =0 ; j<goals.size();j++)
    {
      buttons.add(new JRadioButton(goals.get(j).getName()));
    }
    for(int i=0; i<buttons.size(); i++)
    {
      if(goals.get(i).getSituation()==false)
      {
        buttons.get(i).addActionListener(this);
        buttons.get(i).setBackground(new java.awt.Color(240, 253, 255));
        downPanel.add(buttons.get(i));
      }
    }

    addGoal.addActionListener(this);
    add.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==addGoal){
      remove(upPanel);
      remove(downPanel);
      repaint();
      boolean con=false;
      add(addGoalPanel, BorderLayout.CENTER);
      revalidate();
      repaint();
      if(goalName.getText() != "" && year.getText()!="" && month.getText()!="" && day.getText()!="" )
      {
        con = true;
      }
    }
    
    if(e.getSource()==add){
      UserCollection.getAccessedUser().addNewGoal(new Goal(goalName.getText(), year.getText(), month.getText(), day.getText()));
      buttons.add(new JRadioButton(goalName.getText()));
      downPanel.add(buttons.get(buttons.size()-1));
      buttons.get(buttons.size()-1).addActionListener(this);
      buttons.get(buttons.size()-1).setBackground(new java.awt.Color(240, 253, 255));
      remove(addGoalPanel);
      add(upPanel, BorderLayout.NORTH);
      add(downPanel, BorderLayout.CENTER);
      frame.addToFile();
      revalidate();
      repaint();
    }
    for(int i=0; i<buttons.size(); i++){
      if(e.getSource()==buttons.get(i)){
        goals.get(i).setSucOrFail(true);
        downPanel.remove(buttons.get(i));
        frame.addToFile();
        revalidate();
        repaint();
      }
    }
  }
}