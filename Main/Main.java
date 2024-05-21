package Testing2DGame.Main;

import javax.swing.JFrame;

public class Main 
{
    public static void main(String[] args) 
    {
        JFrame window = new JFrame();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Pokemon-Kanto Adventures");

        GamePanel panel = new GamePanel();
        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.startGameThread();
    }
}
