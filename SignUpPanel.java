import javax.swing.*;
public class SignUpPanel extends javax.swing.JPanel {

    private boolean checkGender;
    private String gender ;
    private boolean backCheck;
    private MainFrame f;
    public SignUpPanel(MainFrame frame) {
        f=frame;
        initComponents();
        revalidate();
        repaint();
        setVisible(true);
        backCheck = false;
        checkGender = false;
    }

    private void initComponents() {
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        password2Label = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        password2TextField = new javax.swing.JPasswordField();
        ageTextField = new javax.swing.JTextField();
        weightTextField = new javax.swing.JTextField();
        heightTextField = new javax.swing.JTextField();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        completeButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        warningAgeLabel = new javax.swing.JLabel();
        warningWeightLabel = new javax.swing.JLabel();
        warningHeightLabel = new javax.swing.JLabel();
        warningEmptyLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        passwordLabel.setText("Password:");

        usernameLabel.setText("Username:");

        password2Label.setText("Password Again:");

        ageLabel.setText("Age:");

        heightLabel.setText("Height(cm):");

        weightLabel.setText("Weight(kg):");

        genderLabel.setText("Gender:");

        maleRadioButton.setText("Male");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        completeButton.setText("Complete");
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Sign Up Page");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(heightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(weightLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addComponent(genderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(completeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usernameTextField)
                                    .addComponent(passwordTextField)
                                    .addComponent(password2TextField)
                                    .addComponent(ageTextField)
                                    .addComponent(weightTextField)
                                    .addComponent(heightTextField)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(maleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(femaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(warningEmptyLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(warningAgeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(warningWeightLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(warningHeightLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(warningLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warningAgeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warningWeightLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warningHeightLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warningEmptyLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maleRadioButton)
                        .addComponent(femaleRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(completeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
    }
    public void setBackCheck(boolean flag){
        backCheck = flag;
    }
    public boolean getBackCheck(){
        return backCheck;
    }
    private boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    }
    return true;
}
    private boolean isNumeric(String str)  
{  
  try {  
    double d = Double.parseDouble(str);  
  } catch(NumberFormatException nfe) {  
    return false;  
  }  
  return true;  
}
    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
           Object obj = evt.getSource();
           JRadioButton b = (JRadioButton)obj;
           if(b.getText().equals("Female"))
           {
               femaleRadioButton.setSelected(true);
               maleRadioButton.setSelected(false);
               checkGender = true;
               gender = "Female";
           }
    }

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
           Object obj = evt.getSource();
           JRadioButton b = (JRadioButton)obj;
           if(b.getText().equals("Male"))
           {
               maleRadioButton.setSelected(true);
               femaleRadioButton.setSelected(false);
               checkGender = true;
               gender = "Male";
           }
    }

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {
           Object obj = evt.getSource();
           JButton b = (JButton)obj;
           boolean checkName = false;
           boolean checkPassword = false;
           boolean checkPasswordSimilartiy = false;
           if(usernameTextField.getText().isEmpty()==false){
               checkName = true;
           }
           if(passwordTextField.getText().equals(password2TextField.getText())){
               checkPasswordSimilartiy = true;
           }
           if(passwordTextField.getText().isEmpty()==false && password2TextField.getText().isEmpty()==false){
               checkPassword = true ;
           }
           if(b.getText().equals("Complete")){
               boolean userCheck=true;
               for(int i = 0 ; i<f.getUserList().getArrayList().size();i++){
                   if(f.getUserList().getArrayList().get(i).getUsername().equals(usernameTextField.getText())){
                       warningEmptyLabel.setText("there is another user with same name!!");
                       userCheck = false;
                   }
                   else
                       userCheck = true;
               }
               if(userCheck==false){  
               }
               else if(checkGender==false || ageTextField.getText().isEmpty()==true || weightTextField.getText().isEmpty()==true || heightTextField.getText().isEmpty()==true || usernameTextField.getText().isEmpty()==true || passwordTextField.getText().isEmpty()==true || password2TextField.getText().isEmpty()==true){
                   warningEmptyLabel.setText("All blanks should be filled");
               }
               else
               {
                    warningEmptyLabel.setText("");
                    if(checkPasswordSimilartiy == false){
                    warningLabel.setText("Check your password again!");
               }
                    else if(isInteger(ageTextField.getText())==false){
                    warningAgeLabel.setText("Age must be integer");
               }
                    else if(isNumeric(weightTextField.getText())==false){
                    warningWeightLabel.setText("Weight must numerical");
               }
                    else if(isInteger(heightTextField.getText())==false){
                    warningHeightLabel.setText("Height must be integer");
               }
                    else if(checkGender==true && checkName==true && checkPassword==true){
                    User user = new User(usernameTextField.getText(),passwordTextField.getText(),Integer.parseInt(ageTextField.getText()),Double.parseDouble(weightTextField.getText()),Integer.parseInt(heightTextField.getText()),gender);
                    f.getUserList().add(user);
                    warningEmptyLabel.setText("Succesfull");
                    warningHeightLabel.setText("");
                    warningWeightLabel.setText("");
                    warningAgeLabel.setText("");
                    warningLabel.setText("");
                    f.addToFile();
                } 
              }
           }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Object obj = evt.getSource();
        JButton b = (JButton)obj;
        if(b.getText().equals("Back")){
           setBackCheck(true);
           f.backToLoginPage();
        }
    }


    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JButton completeButton;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JLabel password2Label;
    private javax.swing.JPasswordField password2TextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel warningAgeLabel;
    private javax.swing.JLabel warningEmptyLabel;
    private javax.swing.JLabel warningHeightLabel;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JLabel warningWeightLabel;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JTextField weightTextField;
}
