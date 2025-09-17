
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


        JButton start = new JButton("Start");
        start.setBounds(350, 350, 100, 40);
        start.setBackground(new Color(0,125,42));
        start.setFont(new Font("Tahoma", Font.PLAIN, 20));
        start.setForeground(Color.WHITE);

        cp.add(start);
        cp.setBackground(Color.BLACK);
        
        
        

    }







    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
