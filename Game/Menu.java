package Game;

import javax.swing.*;

import board.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Menu extends JFrame implements ActionListener {
    
    private JButton start , how ;
    private JTextField nameField;

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
        
        nameField = new JTextField("ENTER NAME");
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
            String playerName = nameField.getText().trim(); 

            if (playerName.isEmpty() || playerName.equals("ENTER NAME")) {
                JOptionPane.showMessageDialog(this,"Please enter your name first! ");
            }else{
            write_csv(playerName);
            dispose();
           new Board(playerName);
           
            }
        } else if (e.getSource() == how) {
            JOptionPane.showMessageDialog(this, "W A S D to move a snake \n Eat an Apple to grow");
        }
        
    }
    //สร้างไฟล์เก็บรายชื่อ
    public void write_csv(String playerName) {
        
        File f = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            f = new File("./Snake-main/snake/Nameplayer/NAME.csv");
            fw = new FileWriter(f,true);
            bw = new BufferedWriter(fw);
            bw.write(playerName+"\n");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
