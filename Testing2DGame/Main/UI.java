package Testing2DGame.Main;

import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI 
{
    GamePanel gp;
    Graphics2D g2;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp)
    {
        this.gp = gp;

    }

    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2)
    {
        this.g2 = g2;

        if(gp.gameState == gp.playState)
        {
            // Do playState stuff
        }
        if(gp.gameState == gp.pauseState)
        {
            drawPauseScreen();
        }
    }

    public void drawPauseScreen()
    {
        String text = "Paused";
        int x = getXForCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public int getXForCenteredText(String text)
    {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    
}