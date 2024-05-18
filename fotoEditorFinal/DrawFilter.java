package fotoEditorFinal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

/**
 * DrawFilter
 */
public class DrawFilter implements Filter
{
    GeneralPath path;

    DrawFilter(GeneralPath path) 
    {
        this.path = path;
    }

    @Override
    public BufferedImage applyFilter(BufferedImage input) 
    {
        BufferedImage result = new BufferedImage(input.getWidth(), input.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = result.createGraphics();

        g2d.drawImage(input, 0, 0, null);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(path);
        g2d.dispose();
        return result;
    }
}