import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.text.ParseException;
import java.awt.event.*;
/*
 *Public class of Monthly Calendar Page extends from JPanel. 
 * This class creates a monthly calendar, and shows if there is any activity in the current month.
 * Author: Gürkan G
 */
public class MonthlyCalendar extends JPanel{
  
  //Variables
  //Three half-main panel
  private JPanel upPanel;
  private JPanel cenPanel;
  private JPanel downPanel;
  
  //Days
  private JLabel mon;  //Monday label
  private JLabel tue;  //Tuesday label
  private JLabel wed;
  private JLabel thu;
  private JLabel fri;
  private JLabel sat;
  private JLabel sun;
  
  private int dayOfWeek; //First day of week
  private int topDays;   //Total days of the month
  
  ArrayList<JLabel> labels;  //Label arraylist to draw days
  
  ArrayList<ToDo> todos;
  ArrayList<String> monthNames;
  
  private int selectedMonth;  //Entered month
  private int thisYear;
  private String selectedDay;
  private ArrayList<JButton> removeButtons;
  private MainFrame frame;
  
  // Constructer
  public MonthlyCalendar(MainFrame f){  //This constructer creates the calendar of current month
    frame = f;
    //Get calendar instance from the calendar class
    Calendar n = Calendar.getInstance();
    Date now = new Date(n.get(Calendar.YEAR), n.get(Calendar.MONTH), 01);  // Create a date to find the day of week of the first day of the month
    thisYear = n.get(Calendar.YEAR);  //Find this year
    
    Calendar c = Calendar.getInstance();  //Other calendar instance
    c.setTime(now);  // Set the date initilazed
    
    System.out.println(c.get(Calendar.DAY_OF_WEEK));  //Print to see what is the first day of week
    System.out.println(n.get(Calendar.YEAR)+" "+ n.get(Calendar.MONTH)+" "+ 01);
    
    selectedMonth = n.get(Calendar.MONTH);  //Initilaze this month
    dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-2;  //Initilaze day of week(-2 to set calendar according to turkey)
    topDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);  //Intilaze total days
    
    //Change day of week to create a smooth calendar(prevent from spaces)
    if(c.get(Calendar.DAY_OF_WEEK)>2)
    dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-2;
    else{
      dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-2+7;
    }
    
    
    createComponents();
    setCalendar();
    searchEvents();
    
    //Add the month names
    downPanel.add(new JLabel(monthNames.get(n.get(Calendar.MONTH))));
    
    
    
  }
  
  //Copy Constructer
  public MonthlyCalendar(int month, MainFrame f){   //This constructer creates calendar of the given month
    frame = f;
    selectedMonth = month;
    Calendar n = Calendar.getInstance();
    Date now = new Date(n.get(Calendar.YEAR), month, 01);
    thisYear = n.get(Calendar.YEAR);
    Calendar c = Calendar.getInstance();
    c.setTime(now);
    System.out.println(c.get(Calendar.DAY_OF_WEEK));
    
    //Change day of week
    if(c.get(Calendar.DAY_OF_WEEK)>2)
    dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-2;
    else{
      dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-2+7;
    }
    
    topDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
    System.out.println("Top days"+c.getActualMaximum(Calendar.DAY_OF_MONTH));
    
    
    createComponents();
    setCalendar();
    searchEvents();
    
    
    downPanel.add(new JLabel(monthNames.get(month)));
    
    //Refresh
    revalidate();
    repaint();
    
    
  }
  
  /*
   * This method creates components of the monthly panel.
   */
  public void createComponents(){
    
   todos = UserCollection.getAccessedUser().getToDos();
   
    //Initilaze day labels
    mon = new JLabel("Mon");
    tue = new JLabel("Tue");
    wed = new JLabel("Wed");
    thu = new JLabel("Thu");
    fri = new JLabel("Fri");
    sat = new JLabel("Sat");
    sun = new JLabel("Sun");
    
    //Initilaze label arraylist(for all days of the month)
    labels = new ArrayList<JLabel>();
    
    //Initilaze panels
    upPanel = new JPanel();
    cenPanel = new JPanel();
    upPanel.setLayout(new GridLayout(1,7));  //Set layout to keep days(monday, tuesday...)
    cenPanel.setLayout(new GridLayout(6,7)); //Set layout to keep all days of the month
    
    setLayout(new BorderLayout());  //Set layout of the main panel
    upPanel.setBackground(new java.awt.Color(240, 253, 255));
    cenPanel.setBackground(new java.awt.Color(240, 253, 255));
    
    //Initilaze down panel which keeps the names of the months
    downPanel = new JPanel(new FlowLayout());
    
    //Initilaze the monthNames arraylist
    monthNames = new ArrayList<String>();
    
    //Create a panel to draw a line beetween every month
    JPanel west = new JPanel(new GridLayout(6,1));
    for(int i=1; i<=6; i++){
      west.add(new JLabel("|"));
    }
    add(west, BorderLayout.WEST);
  }
  
  /*
   * This method draws a calendar with the taken information from current month.
   */
  public void setCalendar(){
    
    //Add the names of the days to the upPanel
     upPanel.add(mon);
    upPanel.add(tue);
    upPanel.add(wed);
    upPanel.add(thu);
    upPanel.add(fri);
    upPanel.add(sat);
    upPanel.add(sun);
    add(upPanel, BorderLayout.NORTH);
    
    add(downPanel, BorderLayout.SOUTH);
    
    
    monthNames.add("January");
    monthNames.add("February");
    monthNames.add("March");
    monthNames.add("April");
    monthNames.add("May");
    monthNames.add("June");
    monthNames.add("July");
    monthNames.add("August");
    monthNames.add("September");
    monthNames.add("October");
    monthNames.add("November");
    monthNames.add("December");
    
    
    add(cenPanel, BorderLayout.CENTER);
    
    //Draw spaces if the first day of the month does not come
    for(int i=1; i<=dayOfWeek-1; i++){
      labels.add(new JLabel(""));
      cenPanel.add(labels.get(i-1));
    }
    
    //Draw numbers after the first day of the month
    for(int i=1; i<=topDays; i++){
      labels.add(new JLabel(Integer.toString(i)));
      cenPanel.add(labels.get(dayOfWeek+i-2));
    }
    
    //Draw spaces to other places
    for(int i=labels.size(); i<=41; i++){
      cenPanel.add(new JLabel(""));
    }
  }
  
  /*
   * This method searches if there is any event in the current month
   */
  public void searchEvents(){
    //Create a calendar
    Calendar c = Calendar.getInstance();
    
    // Get the ToDoList of the user
    
    
    //This algorithm finds out if there is event in the given month
    for(int i=0; i<todos.size(); i++){
      if(Integer.parseInt(todos.get(i).getMonth())==selectedMonth+1 && Integer.parseInt(todos.get(i).getYear())==c.get(Calendar.YEAR)){
        for(int a=0; a<labels.size(); a++){
          if(labels.get(a).getText().equals(todos.get(i).getDeadlineDay())){  //If there is an event, set background of that day to red
            labels.get(a).setOpaque(true);
            labels.get(a).setBackground(Color.RED);
            labels.get(a).addMouseListener(new firstMouseListener());
          }
        }
      }
    }
    
    //Add mouse listener to day labels to make days and activities changable
    for(int a=0; a<labels.size(); a++){
      (labels.get(a)).addMouseListener(new otherMouseListener());
    }
  }
  
  /*
   * Public class firstMouse Listener. This class creates a frame and shows current to do list.
   * It performs everytime clicked on a red label.
   * 
   */
  public class firstMouseListener implements MouseListener, ActionListener{
  @Override
  public void mousePressed(MouseEvent e) {
  }
  @Override
  public void mouseReleased(MouseEvent e) {
  }
  @Override
  public void mouseEntered(MouseEvent e) {
  }
  @Override
  public void mouseExited(MouseEvent e) {
  }
  @Override
  public void mouseClicked(MouseEvent e) {  //This event creates a new frame to show current todoList
    
    int len = todos.size();
    JFrame f = new JFrame();
    f.setLayout(new BorderLayout());
    f.setSize(new Dimension(400, 300));
    JPanel up = new JPanel(new FlowLayout());
    up.add(new JLabel("To Do List"));
    JPanel a = new JPanel(new GridLayout(len, 3));
    
    f.add(up, BorderLayout.NORTH);
    f.add(a, BorderLayout.CENTER);
    
    removeButtons = new ArrayList<JButton>();
    for(int i=0; i<len; i++){
      a.add(new JLabel(todos.get(i).getName()));
      a.add(new JLabel(todos.get(i).getDeadlineDay()+"/"+todos.get(i).getMonth()+"/"+todos.get(i).getYear()+"  "+todos.get(i).getHour()+":"+todos.get(i).getMinute()));
      removeButtons.add(new JButton("Remove"));
      a.add(removeButtons.get(i));
      removeButtons.get(i).addActionListener(this);
    }
    
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
    for(int i=0; i<removeButtons.size(); i++){
      if(e.getSource()==removeButtons.get(i)){
        
        UserCollection.getAccessedUser().removeToDo(todos.get(i));
        todos = UserCollection.getAccessedUser().getToDos();
        searchEvents();
        frame.addToFile();
        revalidate();
    repaint();
      }
    }
  }
  }
  public class otherMouseListener implements MouseListener, ActionListener{
    JTextField name1;
    JComboBox hourBox;
    JComboBox minuteBox;
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
      int sel=0;
      for(int i=0; i<labels.size(); i++){
        if(e.getSource()==labels.get(i))
          selectedDay = labels.get(i).getText();
      }
      JFrame f = new JFrame();
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(3,1));
      p.add(new JLabel("New Activity"));
      f.add(p);
      f.setSize(300,300);
      name1 = new JTextField("Name");
      JPanel o = new JPanel(new FlowLayout());
      JButton addT = new JButton("Add");
      String[] hours = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
      hourBox = new JComboBox(hours);
      String[] minutes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
      minuteBox = new JComboBox(minutes);
      
      o.add(name1);
      o.add(hourBox);
      o.add(minuteBox);
      
      p.add(o);
      
      p.add(addT);
      
      f.setVisible(true);
      
      addT.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
      UserCollection.getAccessedUser().addNewToDo(new ToDo(name1.getText(), Integer.toString(thisYear), Integer.toString(selectedMonth+1), selectedDay, hourBox.getSelectedItem().toString(), minuteBox.getSelectedItem().toString()));
      System.out.println(UserCollection.getAccessedUser().getToDos().toString());
      ArrayList<ToDo> tttt = UserCollection.getAccessedUser().getToDos();
      todos = tttt;
      searchEvents();
      frame.addToFile();
      revalidate();
      repaint();
    }
  }
}