
package View;

import java.util.ArrayList;
import Model.User;
import Controller.SQLite;
import static View.MgmtUser.getMd5;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JPanel {
    
    public SQLite sqlite;
    public Frame frame;
    private int loginAttempts = 0;

    
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        passwordFld = new javax.swing.JPasswordField();
        forgotpass = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        usernameFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFldActionPerformed(evt);
            }
        });

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginBtn.setText("LOGIN");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login Failed; Incorrect Username and/or Password");

        passwordFld.setBackground(new java.awt.Color(242, 242, 242));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        passwordFld.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        passwordFld.setSelectionColor(new java.awt.Color(0, 0, 0));
        passwordFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFldActionPerformed(evt);
            }
        });

        forgotpass.setForeground(new java.awt.Color(0, 138, 230));
        forgotpass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotpass.setText("Forgot password?");
        forgotpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotpassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forgotpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameFld, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(forgotpass)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("PASSWORD");
    }// </editor-fold>//GEN-END:initComponents
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
    if (loginAttempts < 5) {
    sqlite = new SQLite();
    String username = usernameFld.getText();
    String password = String.valueOf(passwordFld.getPassword());
    ArrayList<User> user = sqlite.getUsers();
    boolean isLoginSuccessful = false;

    for (int nCtr = 0; nCtr < user.size(); nCtr++) {
        if(user.get(nCtr).getUsername().equalsIgnoreCase(username) 
            && user.get(nCtr).getPassword().equals(getMd5(password))
            && user.get(nCtr).getRole()!=1){
            jLabel2.setForeground(Color.GRAY);
            jLabel2.setText("");
            passwordFld.setText("");
            usernameFld.setText("");
            frame.mainNav(user.get(nCtr).getRole(), user.get(nCtr).getUsername());
            isLoginSuccessful = true;
            break;
        }
    }

    if (!isLoginSuccessful) {
//        jLabel2.setForeground(Color.RED);
//        jLabel2.setText("Login Failed; Incorrect Username and/or Password");
        JOptionPane.showMessageDialog(this, "Login Failed; Incorrect Username and/or Password.", "Error", JOptionPane.ERROR_MESSAGE);
        loginAttempts++;

        if (loginAttempts == 5) {
//            jLabel2.setForeground(Color.RED);
//            jLabel2.setText("Maximum login attempts exceeded. Account locked.");
            JOptionPane.showMessageDialog(this, "Maximum login attempts exceeded. Account locked.", "Error", JOptionPane.ERROR_MESSAGE);
            for (int nCtr = 0; nCtr < user.size(); nCtr++) {
                if(user.get(nCtr).getUsername().equalsIgnoreCase(username)) {
                    sqlite.lockUser(nCtr+1);
                }
            }
        } else {
            // Implement exponential lockout by introducing a delay before the next login attempt
            long lockoutTime = (long) Math.pow(2, loginAttempts) * 1000; // Exponential delay in milliseconds
            try {
                Thread.sleep(lockoutTime);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}

    }//GEN-LAST:event_loginBtnActionPerformed

    
    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void usernameFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFldActionPerformed

    private void passwordFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFldActionPerformed

    private void forgotpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotpassMouseClicked
        frame.forgotpassNav();
    }//GEN-LAST:event_forgotpassMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgotpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
