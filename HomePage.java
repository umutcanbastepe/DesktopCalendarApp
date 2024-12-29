import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.text.ParseException;
import java.awt.event.*;
import javax.imageio.ImageIO;
public class HomePage extends JPanel{
  private JPanel upPanel;
  private JPanel westPanel;
  private JPanel cenPanel;
  private MainFrame frame ;
  private JButton button1;
  private JButton button2;
  private JButton button3;
  private JButton button4;
  private JButton button5;
  private JButton button6;
  private JButton button7;
  public HomePage(MainFrame f){
    frame=f;
    createComponents();
    
    searchEvents();
    
    try {
    Image img = ImageIO.read(getClass().getResource("11th-hour-clock.png"));
    button1.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  button1.setPreferredSize(new Dimension(40, 40));
  try {
    Image img = ImageIO.read(getClass().getResource("asda.png"));
    button2.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  button2.setPreferredSize(new Dimension(40, 40));
  try {
    Image img = ImageIO.read(getClass().getResource("eeeeee.jpg"));
    button3.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  button3.setPreferredSize(new Dimension(40, 40));
   try {
    Image img = ImageIO.read(getClass().getResource("hamburger.png"));
    button4.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  button4.setPreferredSize(new Dimension(100, 40));
  try {
    Image img = ImageIO.read(getClass().getResource("371327-200.png"));
    button5.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  button5.setPreferredSize(new Dimension(100, 40));
  try {
    Image img = ImageIO.read(getClass().getResource("business-blue-09-512.png"));
    button6.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  button6.setPreferredSize(new Dimension(100, 40));
  try {
    Image img = ImageIO.read(getClass().getResource("10160-200.png"));
    button7.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  button7.setPreferredSize(new Dimension(100, 40));
  }
  
  public void createComponents(){
    button1 = new JButton();
    button2 = new JButton("THIS MONTH");
    button3 = new JButton("THIS YEAR");
    button4 = new JButton("CALORIES");
    button5 = new JButton("GOALS");
    button6 = new JButton("SUMMARY");
    button7 = new JButton("TIMEKEEPER");
    
    setLayout(new BorderLayout());
    upPanel = new JPanel();
    westPanel = new JPanel();
    upPanel.setLayout(new GridLayout(1,3));
    westPanel.setLayout(new GridLayout(4,1));
    upPanel.add(button1);
    upPanel.add(button2);
    upPanel.add(button3);
    
    westPanel.add(button4);
    westPanel.add(button5);
    westPanel.add(button6);
    westPanel.add(button7);
    
    cenPanel = new JPanel();
    
    cenPanel.setLayout(new BorderLayout());
    
    add(upPanel, BorderLayout.NORTH);
    add(westPanel, BorderLayout.WEST);
    add(cenPanel, BorderLayout.CENTER);
    
    setBackground(new java.awt.Color(240, 253, 255));
    cenPanel.setBackground(new java.awt.Color(240, 253, 255));
    
    button1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button1ActionPerformed(evt);
      }
    });
    
    button2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button2ActionPerformed(evt);
      }
    });
    
    button3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button3ActionPerformed(evt);
      }
    });
    
    button4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button4ActionPerformed(evt);
      }
    });
    
    button5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button5ActionPerformed(evt);
      }
    });
    
    button6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button6ActionPerformed(evt);
      }
    });
    
    button7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button7ActionPerformed(evt);
      }
    });
  }
  
  public void searchEvents(){
    Calendar n = Calendar.getInstance();
    
    
    int currentDay = n.get(Calendar.DAY_OF_MONTH);
    int currentMonth = n.get(Calendar.MONTH);
    int currentYear = n.get(Calendar.YEAR);
    System.out.println(currentDay+"\n"+currentMonth+"\n"+currentYear);
    
    ArrayList<ToDo> todos = UserCollection.getAccessedUser().getToDos();
    JFrame fr = new JFrame();
    fr.setSize(400,300);
    JPanel p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
    fr.add(p);
    
    p.add(new JLabel("UPCOMING ACTIVITIES"), BorderLayout.NORTH);
    
    for(int i=0; i<todos.size(); i++){
      if(Integer.parseInt(todos.get(i).getYear())==currentYear && Integer.parseInt(todos.get(i).getMonth())==currentMonth+1 && Math.abs(Integer.parseInt(todos.get(i).getDeadlineDay())-currentDay)<5){
        p.add(new JLabel("Event: "+todos.get(i).getName()+" Date: "+ currentYear+"/"+Integer.toString(currentMonth)+"/"+todos.get(i).getDeadlineDay()));
      }
    }
    ArrayList<Goal> goals = UserCollection.getAccessedUser().getGoals();
    
    fr.setVisible(true);
  }
  
  public void button1ActionPerformed(java.awt.event.ActionEvent evt) {
    cenPanel.removeAll();
    frame.setSize(800,600);
    TodayPage a = new TodayPage();
    cenPanel.add(a, BorderLayout.CENTER);
    revalidate();
    repaint();
  }
  
  public void button2ActionPerformed(java.awt.event.ActionEvent evt) {
    cenPanel.removeAll();
    MonthlyCalendar a = new MonthlyCalendar(frame);
    frame.setSize(800,600);
    cenPanel.add(a, BorderLayout.CENTER);
    revalidate();
    repaint();
  }
  
  public void button3ActionPerformed(java.awt.event.ActionEvent evt) {
    cenPanel.removeAll();
    YearlyPage a = new YearlyPage(frame);
    frame.setSize(800,600);
    cenPanel.add(a, BorderLayout.CENTER);
    revalidate();
    repaint();
  }
  
  public void button4ActionPerformed(java.awt.event.ActionEvent evt) {
    cenPanel.removeAll();
    CaloriePage a = new CaloriePage(frame);
    frame.setSize(525,400);
    cenPanel.add(a, BorderLayout.CENTER);
    revalidate();
    repaint();
  }
  
  public void button5ActionPerformed(java.awt.event.ActionEvent evt) {
    cenPanel.removeAll();
    GoalPage a = new GoalPage(frame);
    frame.setSize(800,600);
    cenPanel.add(a, BorderLayout.CENTER);
    revalidate();
    repaint();
  }
  
  public void button6ActionPerformed(java.awt.event.ActionEvent evt) {
    cenPanel.removeAll();
    SummaryPage a = new SummaryPage();
    frame.setSize(800,600);
    cenPanel.add(a, BorderLayout.CENTER);
    revalidate();
    repaint();
  }
  
  public void button7ActionPerformed(java.awt.event.ActionEvent evt) {
    cenPanel.removeAll();
    Timekeeper a = new Timekeeper();
    frame.setSize(800,600);
    cenPanel.add(a, BorderLayout.CENTER);
    revalidate();
    repaint();
  }
}