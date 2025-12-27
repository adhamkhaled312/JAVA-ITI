package iti.gui;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import javax.swing.*;
public class App extends JFrame{
    public App(){
        this.setLayout(null);
        setTitle("Word Character Counter");
        JTextArea stringArea = new JTextArea();
        JButton wordButton = new JButton("Word");
        JButton charButton = new JButton("Char");

        stringArea.setBounds(40,30,400,300);
        wordButton.setBounds(120,350,100,30);
        charButton.setBounds(260,350,100,30);

        wordButton.addActionListener(l->{
            int count = stringArea.getText().trim().split("\\s+").length;
            String message = "Total words: " + count;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
        });
        charButton.addActionListener(l->{
            int numChars = stringArea.getText().length();
            String message = "Total characters with spaces: " + numChars;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
        });
        add(stringArea);
        add(wordButton);
        add(charButton);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main( String[]args ){
        App findIpApp = new App();
        findIpApp.setSize(500,450);
        findIpApp.setVisible(true);
        findIpApp.setResizable(false);
        }
}
