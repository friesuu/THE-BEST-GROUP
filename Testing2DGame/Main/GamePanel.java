package Testing2DGame.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import Testing2DGame.Entity.Player;
import Testing2DGame.Tile.TileManager;
import Testing2DGame.object.SuperObject;
import javax.swing.JButton;

public class GamePanel extends JPanel implements Runnable 
{
    // Screen settings
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 30;
    public final int maxScreenRow = 18;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 60;
    public final int wordWidt = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // FPS
    int FPS = 60;

    // System
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandle = new KeyHandler(this);
    Thread gameThread;
    JButton button;
    public CollisionChecker checker = new CollisionChecker(this);
    public ObjectPlacer objectPlacer = new ObjectPlacer(this);
    private boolean gamePaused = false;

    // Objects and Player
    public SuperObject object[] = new SuperObject[10]; // Prepares 10 slots for objects, can display 10 objects at the same time
    public Player player = new Player(this, keyHandle);

    // Game state
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public GamePanel() 
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandle);
        this.setFocusable(true); // GamePanel can be "focused" to receive key input
    }

    public void setupGame()
    {
        objectPlacer.setObject();
        gameState = playState;
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
            if (!gamePaused) // Check if the game is not paused
            { 
                update();
                repaint();
            }

            // update();

            // repaint();

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
                // Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
    
    public void update()
    {
        if(gameState == playState)
        {
            player.update();
        }
        if(gameState == pauseState)
        {
            // Nothing
        }
    }
        
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        tileManager.draw(g2); // TILES
        
        // OBJECT
        for(int i = 0; i < object.length; i++)
        {
            if(object[i] != null)
            {
                object[i].draw(g2, this);
            }
        }
                
        player.draw(g2); // PLAYER
        g.dispose();
    }

}
                