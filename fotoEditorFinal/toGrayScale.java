package fotoEditorFinal;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * ConverToGrayScale
 */
public class toGrayScale implements Filter {

    @Override
    public BufferedImage applyFilter(BufferedImage image)
    {
        System.out.println("converting to GrayScale");
        BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = grayImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return grayImage;
    }

    
}