/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/*
 * LOGIN.java
 *
 * Created on Jun 17, 2019, 9:02:31 AM
 */

/**
 *
 * @author Student
 */
public class LOGIN extends javax.swing.JFrame {

    /** Creates new form LOGIN */
    public LOGIN() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LOGIN = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        SIGNUP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pf1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        LOGIN.setFont(new java.awt.Font("Tahoma", 1, 18));
        LOGIN.setText("LOGIN");
        LOGIN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });
        getContentPane().add(LOGIN);
        LOGIN.setBounds(160, 230, 80, 25);

        CLEAR.setFont(new java.awt.Font("Tahoma", 1, 18));
        CLEAR.setText("CLEAR");
        CLEAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });
        getContentPane().add(CLEAR);
        CLEAR.setBounds(260, 230, 76, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("BookYourShow");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 40, 220, 34);

        SIGNUP.setFont(new java.awt.Font("Tahoma", 1, 18));
        SIGNUP.setText("New Member? Sign Up");
        SIGNUP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SIGNUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIGNUPActionPerformed(evt);
            }
        });
        getContentPane().add(SIGNUP);
        SIGNUP.setBounds(350, 230, 229, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Email ID:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 120, 83, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 170, 91, 25);
        getContentPane().add(tf1);
        tf1.setBounds(320, 120, 185, 20);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(39, 402, 100, 100);
        getContentPane().add(pf1);
        pf1.setBounds(320, 170, 185, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movie theater.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 680, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
        int c = 0;
        String Email = tf1.getText();
        String Password = new String (pf1.getPassword());
        if(Email.trim().isEmpty()||Password.trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter both fields properly.");
            tf1.setText("");
            pf1.setText("");
        }
        else if(Password.trim().length()<8)
        {
            JOptionPane.showMessageDialog(this, "Password length shorter than expected.");
        }
        else
        {
            try
            {
                Class.forName("java.sql.DriverManager");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bys","root","G00db@ckend");
                Statement stmt = (Statement) con.createStatement();
                String query = "Select Email,Password from contact where Email = '"+Email+"' and Password = '"+Password+"';";
                ResultSet res = stmt.executeQuery(query);
                if(res.next())
                c++;
                if(c>0)
                {
                JOptionPane.showMessageDialog(this, "Login Successful.");
                tf1.setText("");
                pf1.setText("");
                new MOVIES(Email).setVisible(true);
                this.setVisible(false);
                }
                else
                {
                JOptionPane.showMessageDialog(this, "Login Unsuccessful.");
                tf1.setText("");
                pf1.setText("");
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_LOGINActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        tf1.setText("");
        pf1.setText("");
}//GEN-LAST:event_CLEARActionPerformed

    private void SIGNUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIGNUPActionPerformed
        new SignUp().setVisible(true);
        this.setVisible(false);
}//GEN-LAST:event_SIGNUPActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton LOGIN;
    private javax.swing.JButton SIGNUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pf1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables

}
