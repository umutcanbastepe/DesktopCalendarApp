import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.concurrent.*;

/*
 * Timekeeper class provides counter and stopwatch features
 */
public class Timekeeper extends JPanel
{
  //proporties of timekeeper
  private JButton counterButton;
  private JButton chronometerButton;
  private JPanel buttonPanel;
  private JPanel mainPanel;
  private JLabel topLabel;
  private JPanel southPanel;
  private Chronometer chrFrame;
  private Counter countFrame;
  private int counter1=0;
  private int counter2=0;
  
  
  /*
   * Constructor method of the timekeeper class
   */
  public Timekeeper()
  {
    mainPanel = new JPanel();
    mainPanel.setLayout( new BorderLayout());
    
    topLabel = new JLabel("Timekeeper");
    mainPanel.add( topLabel, BorderLayout.NORTH);
    
    counterButton = new JButton("Counter");
    counterButton.addActionListener(new ClickListener());
    chronometerButton = new JButton("Chronometer");
    chronometerButton.addActionListener(new ClickListener());
    buttonPanel = new JPanel();
    buttonPanel.add(counterButton);
    buttonPanel.add(chronometerButton);
    mainPanel.add( buttonPanel, BorderLayout.CENTER);
    
    southPanel = new JPanel();
    mainPanel.add( southPanel, BorderLayout.SOUTH);
    
    add(mainPanel);
    buttonPanel.setBackground(new java.awt.Color(240, 253, 255));
    mainPanel.setBackground(new java.awt.Color(240, 253, 255));
    southPanel.setBackground(new java.awt.Color(240, 253, 255));
    setBackground(new java.awt.Color(240, 253, 255));
    setVisible(true);
  }
  
  /*
   * an inner class for actions of the buttons
   */
  public class ClickListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      JButton button;
      if (event.getSource() instanceof JButton)
      {
        button = (JButton) event.getSource();
        if( button.getText().equals("Counter"))
        {
          if( counter2 > 0 )
          {
            southPanel.remove(chrFrame);
            counter2 = 0;
          }
          else if ( counter1 > 0 )
          {
            southPanel.remove(countFrame);
            counter1 = 0;
          }
          counter1++;
          countFrame = new Counter();
          southPanel.add( countFrame);
          repaint();
          revalidate();
        }
        else
        {
          if( counter1 > 0)
          {
            southPanel.remove(countFrame);
            counter1 = 0;
          } 
          else if( counter2 > 0 )
          {
            southPanel.remove(chrFrame);
            counter2 = 0;
          }
          counter2++;
          chrFrame = new Chronometer();
          southPanel.add( chrFrame);
          repaint();
          revalidate();
        }
      } 
    }
  }
  /*
   * an inner class for chronometer feature
   */
  public class Chronometer extends JPanel
  {
    
    // proporties for GUI
    private JPanel panel;
    private JLabel label;
    private JButton stopButton;
    private JButton resetButton;
    private JButton startButton;
    private JPanel buttonPanel;
    
    // other proporties
    private byte centisecond = 0;
    private byte second = 0;
    private short minute = 0;
    private short hour=0;
    
    private Runnable timeTask;
    private Runnable calculateTime;
    private Runnable setText;
    private DecimalFormat timeFormatter;
    private boolean isCountinue = true;
    
    private ExecutorService executor = Executors.newCachedThreadPool();
    
    /*
     * constructor method of the chronometer
     */
    public Chronometer()
    {
      setBackground(new java.awt.Color(240, 253, 255));
      panel = new JPanel();
      panel.setLayout(new BorderLayout());
      panel.setBackground(new java.awt.Color(240, 253, 255));
      label = new JLabel();
      label.setHorizontalAlignment(JLabel.CENTER);
      panel.add(label);
      
      
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      buttonPanel.setBackground(new java.awt.Color(240, 253, 255));
      startButton = new JButton("Start");
      startButton.addActionListener(new MyClickListener());
      buttonPanel.add(startButton);
      
      resetButton = new JButton("Reset");
      resetButton.addActionListener(new MyClickListener());
      buttonPanel.add(resetButton);
      
      stopButton = new JButton("Stop");
      stopButton.addActionListener(new MyClickListener());
      
      buttonPanel.add(stopButton);
      panel.add(buttonPanel, BorderLayout.SOUTH);
      
      
      timeFormatter = new DecimalFormat("00");
      
      /*
       * a run method contained by runnable interface 
       */
      timeTask = new Runnable(){
        public void run()
        {
          while(isCountinue)
          {
            executor.execute(calculateTime);
            
            try
            {
              Thread.sleep(10);
            }
            catch (InterruptedException ex)
            {
              ex.printStackTrace();
            }
          }
        }
      };
      /*
       * a run method contained by runnable interface to increment the time by 1.
       */
      calculateTime = new Runnable(){
        public void run()
        {
          if( centisecond < 66)
          {
            centisecond++;
          }
          else
          {
            if( second < 60 ){
              centisecond=0;
              second++;
            }
            else{
              if( minute<60){
                centisecond=0;
                second=0;
                minute++;
              }
              else{
                centisecond=0;
                second=0;
                minute=0;
                hour++;
              }
            }
          }
          
          executor.execute(setText);
        }
      };
      
      /*
       * a run method contained by runnable interface to set the text of the label
       */
      setText = new Runnable(){
        public void run()
        {
          label.setText(timeFormatter.format(hour) + ":" + timeFormatter.format(minute) + ":"  + timeFormatter.format(second) + ":"  + timeFormatter.format(centisecond));
        }
      };
      
      label.setText(timeFormatter.format(hour) + ":" + timeFormatter.format(minute) + ":"  + timeFormatter.format(second)+ ":"  + timeFormatter.format(centisecond));
      
      add(panel);
      setVisible(true);
    }
    /*
     * an inner clickllistener class for actions of each button
     */
    public class MyClickListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        JButton button;
        if (event.getSource() instanceof JButton)
        {
          button = (JButton) event.getSource();
          if(button.getText().equals("Start"))
          {
            if (isCountinue== false)
            {
              isCountinue = true;
            }
            executor.execute(timeTask);
          }
          else if(button.getText().equals("Reset"))
          {
            isCountinue = false;
            
            centisecond = 0;
            second = 0;
            minute = 0;
            hour =0;
            
            label.setText(timeFormatter.format(hour) + ":" + timeFormatter.format(minute) + ":" + timeFormatter.format(second) + ":"  + timeFormatter.format(centisecond));
          }
          else
          {
            isCountinue = false;
          }
        }
      }
    }
  }
  /*
   * an inner class for the counter feature
   */
  public class Counter extends JPanel 
  {
    
    // proporties for GUI 
    private JPanel panel;
    private JLabel label;
    private JButton stopButton;
    private JButton resetButton;
    private JButton startButton;
    private JPanel buttonPanel;
    private JPanel fieldPanel;
    private JTextField editHour;
    private JTextField editMin;
    private JTextField editSec;
    private JButton fieldButton;
    private JLabel message;
    
    // other proporties
    private byte centisecond = 0;
    private byte second=0; 
    private short minute=0; 
    private short hour=0;
    
    private Runnable timeTask;
    private Runnable decrementTime;
    private Runnable setText;
    private DecimalFormat timeFormatter;
    private boolean isContinue = true;
    
    private ExecutorService executor = Executors.newCachedThreadPool();
    
    /*
     * constructor method of the counter class
     */
    public Counter()
    {
      panel = new JPanel();
      panel.setLayout(new BorderLayout());
      panel.setBackground(new java.awt.Color(240, 253, 255));
      setBackground(new java.awt.Color(240, 253, 255));
      fieldPanel = new JPanel();
      editHour = new JTextField(5);
      editMin = new JTextField(5);
      editSec = new JTextField(5);
      fieldButton = new JButton("Edit Time");
      fieldPanel.add(editHour);
      fieldPanel.add(editMin);
      fieldPanel.add(editSec);
      fieldPanel.add(fieldButton);
      fieldPanel.setBackground(new java.awt.Color(240, 253, 255));
      /*
       * adjusting time with the numbers given from the user
       */
      fieldButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
          if(isInteger(editSec.getText())&& isInteger(editMin.getText()) && isInteger(editHour.getText()))
          {
            second = Byte.parseByte(editSec.getText());
            minute = Short.parseShort(editMin.getText());
            hour = Short.parseShort(editHour.getText());
            label.setText(timeFormatter.format(hour) + ":" + timeFormatter.format(minute) + ":" + timeFormatter.format(second));
          }
          else
            label.setText("Enter an integer");
        }
        private boolean isInteger(String s) {
          try { 
            Integer.parseInt(s); 
          } catch(NumberFormatException e) { 
            return false; 
          }
          return true;
        }
      });                             
      panel.add(fieldPanel, BorderLayout.NORTH);
      
      label = new JLabel();
      label.setHorizontalAlignment(JLabel.CENTER);
      panel.add(label);
      
      
      buttonPanel = new JPanel();
      buttonPanel.setBackground(new java.awt.Color(240, 253, 255));
      buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      
      
      startButton = new JButton("Start");
      startButton.addActionListener(new UrClickListener());
      buttonPanel.add(startButton);
      
      resetButton = new JButton("Reset");
      resetButton.addActionListener(new UrClickListener());
      buttonPanel.add(resetButton);
      
      stopButton = new JButton("Stop");
      stopButton.addActionListener(new UrClickListener());
      buttonPanel.add(stopButton);
      
      panel.add(buttonPanel, BorderLayout.SOUTH);
      
      message = new JLabel("");
      buttonPanel.add(message);
      
      timeFormatter = new DecimalFormat("00");
      
      /*
       * a run method contained by runnable interface 
       */
      timeTask = new Runnable(){
        public void run()
        {
          while(isContinue)
          {
            executor.execute(decrementTime);
            
            try
            {
              Thread.sleep(10);
            }
            catch (InterruptedException ex)
            {
              ex.printStackTrace();
            }
          }
        }
      };
      
      /*
       * a run method contained by runnable interface fot decrement the time
       */
      decrementTime = new Runnable(){
        public void run()
        {
          if (centisecond > 0)
            centisecond--;
          else
          {
            if (second == 0 && minute == 0)
              isContinue = false;
            else if (second > 0)
            {
              second--;
              centisecond = 66;
            }
            else if (minute > 0)
            {
              minute--;
              second = 59;
              centisecond = 99;
            }
            else if( hour > 0 )
            {
              hour--;
              minute = 59;
              second = 59;
              centisecond = 99;
            }
            if( centisecond == 0 && second == 0 && minute == 0 && hour == 0 )
            {
              message.setText("Finished!");
            }
          }
          
          executor.execute(setText);
        }
      };
      
      /*
       * a run method contained by runnable interface to set the time of the label 
       */
      setText = new Runnable(){
        public void run()
        {
          label.setText(timeFormatter.format(hour) + ":" + timeFormatter.format(minute) + ":" + timeFormatter.format(second));
        }
      };
      
      label.setText(timeFormatter.format(hour) + ":" + timeFormatter.format(minute) + ":" + timeFormatter.format(second));
      
      add(panel);
      setVisible(true);
    }
    
    /*
     * an inner clickllistener class for actions of each button
     */
    public class UrClickListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        JButton button;
        if (event.getSource() instanceof JButton)
        {
          button = (JButton) event.getSource();
          if(button.getText().equals("Start"))
          {
            if (isContinue== false)
            {
              isContinue = true;
            }
            executor.execute(timeTask);
          }
          else if(button.getText().equals("Reset"))
          {
            isContinue = false;
            
            centisecond = 0;
            second = 0;
            minute = 0;
            hour =0;
            
            label.setText(timeFormatter.format(hour) + ":" + timeFormatter.format(minute) + ":" + timeFormatter.format(second) );
          }
          else
          {
            isContinue = false;
          }
        }
      }
    }
  }
}