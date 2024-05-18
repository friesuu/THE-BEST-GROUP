package fotoEditorFinal;

import java.awt.image.BufferedImage;

public class Blur implements Filter
{
    public Blur()
    {
        
    }
    
    @Override
    public BufferedImage applyFilter(BufferedImage img)
    {
        BufferedImage blurImage = new BufferedImage(img.getWidth()-4, img.getHeight()-4, BufferedImage.TYPE_INT_ARGB);

        for (int y =0; y <blurImage.getHeight(); y++) 
        {
            for (int x =0; x <blurImage.getWidth(); x++) 
            {
                int numPixels =0;
                int r_sum =0, g_sum =0, b_sum =0, alpha_sum =0;

                for (int yOffSet = -2; yOffSet <=2; yOffSet++) 
                {
                    for (int xOffSet = -2; xOffSet <=2; xOffSet++) 
                    {
                        int pixelX = x + xOffSet + 2; 
                        int pixelY = y + yOffSet + 2; 

                        if (pixelX >=0 && pixelX < img.getWidth() && pixelY >=0 && pixelY < img.getHeight()) 
                        {
                            int pixel = img.getRGB(pixelX, pixelY);
                            r_sum += (pixel >>16) & 0xFF;
                            g_sum += (pixel >>8) & 0xFF;
                            b_sum += pixel & 0xFF;
                            alpha_sum += (pixel >>24) & 0xFF;
                            numPixels++;
                        }
                    }
                }
                int red = r_sum / numPixels;
                int green = g_sum / numPixels;
                int blue = b_sum / numPixels;
                int alpha = alpha_sum / numPixels;

                int p = (alpha <<24) | (red <<16) | (green <<8) | blue;
                blurImage.setRGB(x, y, p);
            }
        }
        return blurImage;
    }
}
