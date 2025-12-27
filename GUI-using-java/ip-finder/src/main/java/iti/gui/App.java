package iti.gui;
import java.net.InetAddress;
import javax.swing.*;
public class App extends JFrame{
    public App(){
        this.setLayout(null);
        setTitle("IP Finder tool");
        JTextField urlField = new JTextField();
        JLabel urlLabel = new JLabel("Enter URL: ");
        JButton findButton = new JButton("Find IP");
        urlField.setBounds(180,200,200,20);
        urlLabel.setBounds(100,200,200,20);
        findButton.setBounds(220,230,100,20);
        
        findButton.addActionListener(l->{
            try{
                String ip = InetAddress.getByName(urlField.getText()).getHostAddress();
                String message = "URL: " + urlField.getText() + "\nIP: " + ip;
                JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(urlField);
        add(urlLabel);
        add(findButton);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main( String[]args ){
        App findIpApp = new App();
        findIpApp.setSize(500,500);
        findIpApp.setVisible(true);
        findIpApp.setResizable(false);
        }
}
