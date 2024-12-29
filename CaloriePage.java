
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.text.ParseException;
import java.awt.event.*;
import javax.imageio.ImageIO;
public class CaloriePage extends javax.swing.JPanel {
  
  private double weight;
  private double height;
  private int age;
  private User.Gender gender;
  private double calLimit;
  private double topCalorie;
  private double leftCalorie;
  private boolean cbox1;
  private boolean cbox2;
  private boolean cbox3;
  private boolean cbox4;
  private boolean cbox5;
  private MainFrame frame ;
  final double meat = 234;
  final double bread = 264.6;
  final double fruit = 52.1;
  final double vegetable = 41.3;
  final double dessert = 494;
  String pieces;
  public CaloriePage(MainFrame f) {
    frame = f;
    weight = UserCollection.getAccessedUser().getWeight();
    height = UserCollection.getAccessedUser().getHeight();
    age = UserCollection.getAccessedUser().getAge();
    gender = UserCollection.getAccessedUser().getGender();
    calLimit=UserCollection.getAccessedUser().getDailyCalorieAmount();
    initComponents();
    topCalorie = 0;
    leftCalorie = calLimit-topCalorie;
    cbox1 = false;
    cbox2 = false;
    cbox3 = false;
    cbox4 = false;
    cbox5 = false;
    pieces = "0";
  }
  
                         
    private void initComponents() {
    
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jCheckBox1 = new javax.swing.JCheckBox();
    jCheckBox2 = new javax.swing.JCheckBox();
    jCheckBox3 = new javax.swing.JCheckBox();
    jCheckBox4 = new javax.swing.JCheckBox();
    jCheckBox5 = new javax.swing.JCheckBox();
    jLabel5 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    
    setBackground(new java.awt.Color(240, 253, 255));
    
    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel1.setText("Calories:");
    
    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText(topCalorie+"/"+calLimit);
    
    jLabel3.setText("You have taken "+topCalorie+" calories today.");
    
    jLabel4.setText(getLeftCalorie()+" calories left!");
    
    jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox1ActionPerformed(evt);
      }
    });
    
    jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox2ActionPerformed(evt);
      }
    });
    
    jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox3ActionPerformed(evt);
      }
    });
    
    jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox4ActionPerformed(evt);
      }
    });
    
    jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox5ActionPerformed(evt);
      }
    });
    
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    
    jLabel5.setText("Enter number of pieces:");
    
    jTextField1.setText("Enter here what you ate");
    jTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1ActionPerformed(evt);
      }
    });
    
    jButton1.setText("Add Calories");
    
    try {
    Image img = ImageIO.read(getClass().getResource("2ccfe959736053.Y3JvcCw1OTIsNDYzLDEyMiwzODE.png"));
    jLabel6.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  
  try {
    Image img = ImageIO.read(getClass().getResource("ehmek.png"));
    jLabel7.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  
  try {
    Image img = ImageIO.read(getClass().getResource("animated-apple-clipart-1.png"));
    jLabel8.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  
  try {
    Image img = ImageIO.read(getClass().getResource("eggplant-vegetable-cartoon-illustration-hand-drawn-animation-transparent-background_hega2fwbx_thumbnail-full10.png"));
    jLabel9.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  
  try {
    Image img = ImageIO.read(getClass().getResource("dessert.png"));
    jLabel10.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
    
    jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel11.setText("Meat");
    
    jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel12.setText("Bread");
    
    jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel13.setText("Fruit");
    
    jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel14.setText("Vegetable");
    
    jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel15.setText("Dessert");
    
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
                              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addGap(123, 123, 123)
                                                                    .addComponent(jLabel1)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addGap(150, 150, 150)
                                                                    .addComponent(jLabel4))
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addGap(156, 156, 156)
                                                                    .addComponent(jButton1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addGap(29, 29, 29)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel5)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addGap(9, 9, 9)
                                                                                                                    .addComponent(jLabel11)
                                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                    .addComponent(jLabel12))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                    .addGap(18, 18, 18)
                                                                                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                            .addGap(18, 18, 18)
                                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addGap(9, 9, 9)
                                                                                                                    .addComponent(jLabel13)))))
                                                                    .addGap(18, 18, 18)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addGap(29, 29, 29)
                                                                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                            .addComponent(jLabel14)
                                                                                            .addGap(18, 18, 18)
                                                                                            .addComponent(jLabel15)))))
                                            .addContainerGap(36, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(jCheckBox1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jCheckBox2)
                                                                    .addGap(44, 44, 44)
                                                                    .addComponent(jCheckBox3)
                                                                    .addGap(57, 57, 57)
                                                                    .addComponent(jCheckBox4)
                                                                    .addGap(48, 48, 48)
                                                                    .addComponent(jCheckBox5)
                                                                    .addContainerGap())
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(51, 51, 51))))
                             );
    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jLabel4)
                                          .addGap(22, 22, 22)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(jLabel11)
                                                      .addComponent(jLabel12)
                                                      .addComponent(jLabel13)
                                                      .addComponent(jLabel14)
                                                      .addComponent(jLabel15))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(jLabel8)
                                                      .addComponent(jLabel9)
                                                      .addComponent(jLabel10))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addComponent(jCheckBox1)
                                                      .addComponent(jCheckBox2)
                                                      .addComponent(jCheckBox3)
                                                      .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                      .addComponent(jCheckBox5))
                                          .addGap(33, 33, 33)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(jLabel5)
                                                      .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(jButton1)
                                          .addContainerGap(46, Short.MAX_VALUE))
                           );
  }                     
  
  private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    if(jCheckBox1.isSelected())
      cbox1 = true;
    else
      cbox1 = false;
  }                                          
  
  private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    if(jCheckBox2.isSelected())
      cbox2 = true;
    else
      cbox2 = false;
  }                                          
  
  private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    if(jCheckBox3.isSelected())
      cbox3 = true;
    else
      cbox3 = false;
  }                                          
  
  private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    if(jCheckBox4.isSelected())
      cbox4 = true;
    else
      cbox4 = false;
  }                                          
  
  private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    if(jCheckBox5.isSelected())
      cbox5 = true;
    else
      cbox5 = false;
  }                                          
  
  private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    pieces = jTextField1.getText();
    System.out.println(pieces);
  }                                           
  
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {    
    if(cbox1==true)
      topCalorie += (int) Integer.parseInt(pieces)*meat;
    if(cbox2==true)
      topCalorie += (int) Integer.parseInt(pieces)*bread;
    if(cbox3==true)
      topCalorie += (int) Integer.parseInt(pieces)*fruit;
    if(cbox4==true)
      topCalorie += (int) Integer.parseInt(pieces)*vegetable;
    if(cbox5==true)
      topCalorie += (int) Integer.parseInt(pieces)*dessert;
    
    UserCollection.getAccessedUser().setLeftCalorie(leftCalorie);
    jLabel2.setText(topCalorie+"/"+calLimit);
    jLabel3.setText("You have taken "+topCalorie+" calories today.");
    System.out.println(topCalorie);
    jLabel4.setText(UserCollection.getAccessedUser().returnLeftCalorie() + " calories left!");
    calculateLeftCalorie();
    revalidate();
    repaint();
  }    
                     
  private javax.swing.JButton jButton1;
  private javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JCheckBox jCheckBox2;
  private javax.swing.JCheckBox jCheckBox3;
  private javax.swing.JCheckBox jCheckBox4;
  private javax.swing.JCheckBox jCheckBox5;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JTextField jTextField1;           

  public void calculateLeftCalorie(){
    leftCalorie = calLimit-topCalorie;
  }
  public double getLeftCalorie()
  {
    return leftCalorie;
  }
}
