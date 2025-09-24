package Game;

import javax.swing.*;

import board.*;
import gameobj.Snake;

import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    
    private JButton start , how ;

    public Menu() {

        // ตั้งค่าหน้าต่าง
        
        setTitle("Snake Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        // ตั้งค่าไอคอน
        ImageIcon icon = new ImageIcon("./image/616653.png");
        setIconImage(icon.getImage());


      

      
          
        Container cp = getContentPane();
        cp.setBackground(Color.BLACK);
        cp.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 0); // เว้นระยะห่าง
        gbc.gridx = 0;

        // โลโก้ 
        
        ImageIcon snake = new ImageIcon("./image/616653.png");
        Image scale = snake.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon icon1 = new ImageIcon(scale);

        JLabel pic = new JLabel(icon1);
        gbc.gridy = 0;
        cp.add(pic, gbc);

    
        // Snake Game 
        
        JLabel snakegame = new JLabel("SNAKE GAME");
        snakegame.setFont(new Font("Monospaced", Font.BOLD, 30));
        snakegame.setForeground(Color.WHITE);
        gbc.gridy = 1;
        cp.add(snakegame, gbc);

        
        // Name Field
        
        JTextField nameField = new JTextField("ENTER NAME", 20);
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setFont(new Font("Monospaced", Font.BOLD, 18));
        nameField.setBackground(new Color(150, 180, 150));
        nameField.setForeground(Color.DARK_GRAY);
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        cp.add(nameField, gbc);

        
        // Start Button
        
        start = new JButton("START");
        start.setFont(new Font("Monospaced", Font.BOLD, 20));
        start.setBackground(new Color(0, 125, 42));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        cp.add(start, gbc);

        
        // How Button
        
        how = new JButton("HOW");
        how.setFont(new Font("Monospaced", Font.BOLD, 20));
        how.setBackground(new Color(0, 125, 42));
        how.setForeground(Color.WHITE);
        how.addActionListener(this);
        gbc.gridy = 4;
        cp.add(how, gbc);



        setVisible(true);
    }
        

    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == start) {
            dispose();
           new Board();
        } else if (e.getSource() == how) {
            JOptionPane.showMessageDialog(this, "W A S D to move a snake \n Eat an Apple to grow");
        }
        
    }
}