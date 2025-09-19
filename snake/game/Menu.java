
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    
    

    public Menu() {

        // ตั้งค่าหน้าต่าง
        
        setTitle("Snake Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // ตั้งค่าไอคอน
        ImageIcon icon = new ImageIcon("./image/616653.png");
        setIconImage(icon.getImage());


      

      
          
        Container cp = getContentPane();
        cp.setLayout(null);

        // ภาพ
        ImageIcon snake = new ImageIcon("./image/616653.png");
        Image scale = snake.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon icon1 = new ImageIcon(scale);
        
        JLabel pic = new JLabel(icon1);
        pic.setBounds(320, 50, 150, 150);


        //snake game
        JLabel snakegame = new JLabel("SNAKE GAME");
        snakegame.setBounds(315, 220, 200, 50);
        snakegame.setBackground(new Color(0,125,42));
        snakegame.setFont(new Font("Monospaced", Font.BOLD, 30));
        snakegame.setForeground(Color.WHITE);
        

        // ใส่ชื่อ
        JTextField nameField = new JTextField("ENTER NAME");
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setFont(new Font("Monospaced", Font.BOLD, 18));
        nameField.setBackground(new Color(150, 180, 150));
        nameField.setForeground(Color.DARK_GRAY);
        nameField.setBounds(220, 350, 360, 40);
        
        // ปุ่ม start
        JButton start = new JButton("START");
        start.setBounds(350, 450, 100, 40);
        start.setBackground(new Color(0,125,42));
        start.setFont(new Font("Monospaced", Font.BOLD, 20));
        start.setForeground(Color.WHITE);

        // ปุ่ม how
        JButton How = new JButton("HOW");
        How.setBounds(350, 550, 100, 40);
        How.setBackground(new Color(0,125,42));
        How.setFont(new Font("Monospaced", Font.BOLD, 20));
        How.setForeground(Color.WHITE);

        
        cp.add(snakegame);
        cp.add(pic);
        cp.add(nameField);
        cp.add(start);
        cp.add(How);
        cp.setBackground(Color.BLACK);
        
        
        

    }







    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
