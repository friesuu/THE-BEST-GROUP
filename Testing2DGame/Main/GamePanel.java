package Testing2DGame.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Testing2DGame.Entity.Player;
import Testing2DGame.Tile.TileManager;

public class GamePanel extends JPanel implements Runnable 
{
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 40;
    public final int maxScreenRow = 25;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    int FPS = 120;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandle = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyHandle);

    public GamePanel() 
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true); // GamePanel can be "focused" to receive key input
    }

    public void startGameThread() 
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() 
    {
        //long currentTime = System.nanoTime(); // Returns system time in nanoseconds (more accurate)
        //long currentTime2 = System.currentTimeMillis();// Retursn system time in millisecond

        double drawInteval = 1000000000/FPS; // In nanoseconds. The screen will be drawn every 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInteval;

        while (gameThread != null) 
        {
            update();

            repaint();

            
            try 
            {
                double remaingTime = nextDrawTime - System.nanoTime();
                remaingTime = remaingTime/1000000;

                if(remaingTime < 0)
                {
                    remaingTime = 0;
                }

                Thread.sleep((long)remaingTime);

                nextDrawTime += drawInteval;
            } 
            catch (InterruptedException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void update()
    {
        player.update();
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        
        tileManager.draw(g2);
        player.draw(g2);
        g.dispose();
    }
}
