import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JFrame obj1= new JFrame();
        obj1.setBounds(12,12,700,600 );
        obj1.setTitle("Brick Crusher Ball");
        obj1.setResizable(false);
        gameSwing gamePanel = new gameSwing();
        obj1.setVisible(true);
        obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj1.add(gamePanel);



    }
}