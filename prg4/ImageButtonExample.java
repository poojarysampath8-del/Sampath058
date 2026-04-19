/* Develop a Swing program in Java to display a message “Digital Clock is pressed” or
“Hour Glass is pressed” depending upon the JButton with image either Digital Clock
or Hour Glass is pressed by implementing the event handling mechanism with
addActionListener( ).
 */

package Swings;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ImageButtonExample {
JLabel l1;

ImageButtonExample(){
JFrame f = new JFrame("Image Button Example");

l1 = new JLabel();
l1.setBounds(50,50,500,100);
l1.setFont(new Font("Arial", Font.BOLD,30));

// Load images (make sure images are in your project folder)
ImageIcon clockIcon = new ImageIcon("C:\\Sampath\\eclipse-workspace\\prg4\\src\\Swings\\clock.png");
ImageIcon hourglassIcon = new ImageIcon("C:\\Sampath\\eclipse-workspace\\prg4\\src\\Swings\\hourglass.png");

// Create buttons with images
JButton b1 = new JButton(clockIcon);
JButton b2 = new JButton(hourglassIcon);

b1.setBounds(100,200,150,150);
b2.setBounds(300,200,150,150);

// Event handling
b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
l1.setText("Digital Clock is pressed");
}
});

b2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
l1.setText("Hour Glass is pressed");
}
});

f.add(b1);
f.add(b2);
f.add(l1);

f.setSize(600,500);
f.setLayout(null);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String[] args) {
new ImageButtonExample();
}
}
