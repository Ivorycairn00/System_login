import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.regex.Pattern;



public class LoginPage implements ActionListener{



     static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
     static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

     static final String PASSWORD_REGEX =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#_$%^&+=])(?=\\S+$).{8,}$";
     static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    ImageIcon image = new ImageIcon("Machi.jpg");
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID :");
    JLabel userPasswordLabel = new JLabel("Password :");
    JLabel titleLabel = new JLabel("Login Page");
    JLabel messageLabel = new JLabel();
    


    HashMap<String,String> loginInfo = new HashMap<String,String>();


    LoginPage(HashMap<String,String> loginInfoOriginal){

        loginInfo = loginInfoOriginal;
       
         

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        titleLabel.setBounds(150,25,250,35);
        titleLabel.setFont(new Font(null,Font.BOLD,25));
        titleLabel.setForeground(new Color(90,24,134));

        messageLabel.setBounds(125, 250, 250, 50);
        messageLabel.setFont(new Font("Arial",Font.ITALIC,15));
        

        userIDField.setBounds(125,100, 200, 25);
        userIDField.setBackground(Color.GREEN);

        userPasswordField.setBounds(125,150, 200, 25);
        userPasswordField.setBackground(Color.GREEN);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);




        frame.add(titleLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setTitle("Login_page");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(2,255,255));
        
}       




@Override
public void actionPerformed(ActionEvent e){

    if(e.getSource() == resetButton){
        userIDField.setText("");
        userPasswordField.setText("");
    }

    if(e.getSource() == loginButton){

        String userID = userIDField.getText();
        if(userID.isEmpty()){
            messageLabel.setForeground(new Color(255,0,0));
            messageLabel.setText("Isi UserID!!");
            return;
        }

        if(!EMAIL_PATTERN.matcher(userID).matches()){
            messageLabel.setForeground(new Color(255,0,0));
            messageLabel.setText("UserID tidak valid!!");
            return;
        }
        String password = String.valueOf(userPasswordField.getPassword());
        if(password.isEmpty()){
            messageLabel.setForeground(new Color(255,0,0));
            messageLabel.setText("Isi Password!!");
            return;
        }

        if(!PASSWORD_PATTERN.matcher(password).matches()){
            messageLabel.setForeground(new Color(255,0,0));
            messageLabel.setText("Password tidak valid!!");
            return;
        }
    
    if(loginInfo.containsKey(userID)){
        if(loginInfo.get(userID).equals(password)){
            messageLabel.setForeground(new Color(0,255,0));
            messageLabel.setText("Login Succesful");
            frame.dispose();
            WelcomePage welcomePage = new WelcomePage(userID);
        }
        else{
             messageLabel.setForeground(new Color(255,0,0));
            messageLabel.setText("Password Salah");
        }
    }
    else{
         messageLabel.setForeground(new Color(255,0,0));
            messageLabel.setText("Username ini GK ada");
    }
}

}
}




