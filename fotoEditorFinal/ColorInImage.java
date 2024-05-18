package fotoEditorFinal;

import java.awt.image.BufferedImage;

public class ColorInImage implements Filter
{
    public ColorInImage()
    {

    }
    
    @Override
    public BufferedImage applyFilter(BufferedImage image)
    {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage colorinImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) 
        {
            for (int x = 0; x < width; x++) 
            {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = ((rgb >> 8) & 0xFF) + 30 ;
                int blue = rgb & 0xFF;

                int invertred = 255-red;
                int invertgreen = 255-green;
                int invertblue = 255-blue;

                // Create a new color with only the green channel
                int newRgb = (invertred << 16) | ((invertgreen) << 8) | invertblue;

                colorinImage.setRGB(x, y, newRgb);
            }
        }
        return colorinImage;
    }
}
