import java.awt.*;
import javax.swing.border.Border;
import javax.swing.*;



public class WelcomePage{
    ImageIcon icon = new ImageIcon("Machi.jpg");
    JFrame frame = new JFrame();
    JLabel wlabel = new JLabel();
    Border border = BorderFactory.createLineBorder(Color.green,3);
    

    WelcomePage(String userID){

       
        wlabel.setText("Hello " + userID);
        wlabel.setIcon(icon);
        wlabel.setHorizontalTextPosition(JLabel.CENTER);
        wlabel.setVerticalTextPosition(JLabel.TOP);
        wlabel.setFont(new Font("MV Boli",Font.BOLD,30));
        wlabel.setHorizontalAlignment(JLabel.CENTER);
        wlabel.setBackground(Color.black);
        wlabel.setOpaque(true);
        wlabel.setBounds(180,15,1200,800);

        

        frame.add(wlabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);

        


    }
}