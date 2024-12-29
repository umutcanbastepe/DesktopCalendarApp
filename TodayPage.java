import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TodayPage extends javax.swing.JPanel implements ActionListener{
  
  SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
  Date now = new Date();
  ArrayList<JButton> buttons;
  JPanel inPanel;
  JLabel today;
  ArrayList<ToDo> todoList;
  String theHour;
  public TodayPage() {
    theHour = "";
    createComponents();
    addComponents();
    SimpleDateFormat formatter = new SimpleDateFormat("dd"); 
    Date date = new Date();
    todoList = UserCollection.getAccessedUser().getToDos();
    for(int i=0; i<todoList.size(); i++){
      if(todoList.get(i).getDeadlineDay().equals(formatter.format(date))){
        System.out.println("true");
        for(int a=0; a<buttons.size(); a++){
          if(((buttons.get(a).getText()).substring(0,2)).equals(todoList.get(i).getHour())){
            theHour = todoList.get(i).getHour();
            System.out.println("true");
            buttons.get(a).setBackground(Color.RED);
            buttons.get(a).addActionListener(this);
          }
        }
      }
    }
  }
  
  public void createComponents(){
    today = new JLabel();
    inPanel = new JPanel();
    inPanel.setLayout(new GridLayout(8,3));
    setLayout(new BorderLayout());
    buttons = new ArrayList<JButton>();
    String o="";
    for(int i=0; i<=23; i++){
      if(i<10)
        o="0";
      else
        o="";
      buttons.add(new JButton(o+Integer.toString(i)+":00"));
      System.out.println(buttons.get(i).getText());
    }
  }
  
  public void addComponents(){
    add(inPanel, BorderLayout.CENTER);
    
    for(int i=0; i<=23; i++){
      inPanel.add(buttons.get(i));
    }
    
    today.setText(f.format(now));
    add(today, BorderLayout.NORTH);
  }
  
  public void actionPerformed(ActionEvent e){
    JFrame a = new JFrame();
    a.setSize(500,200);
    JPanel b = new JPanel();
    b.setLayout(new BoxLayout(b, BoxLayout.PAGE_AXIS));
    for(int i=0; i<todoList.size(); i++){
      if(todoList.get(i).getHour().equals(theHour)){
        b.add(new JLabel(todoList.get(i).toString()));
      }
    }
    a.add(b);
    a.setVisible(true);
  }
}
