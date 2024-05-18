package fotoEditorFinal;

import java.awt.image.BufferedImage;

public class Brighten implements Filter
{
    int percentage;

    Brighten(int percentage)
    {
        this.percentage = percentage;
    }

    @Override
    public BufferedImage applyFilter(BufferedImage img)
    {
        BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);

        int r=0, g=0, b=0, rgb=0, alp=0;
        float fac = 1.0f + (percentage / 100.0f);

        for (int y=0; y<img.getHeight(); y++) 
        {
            for (int x=0; x<img.getWidth(); x++) 
            {
                rgb = img.getRGB(x, y);
                
                r = (rgb >> 16) & 0xFF;
                g = (rgb >> 8) & 0xFF;
                b = rgb & 0xFF;
                alp = (rgb >> 24) & 0xFF;
                
                r = (int) (r * fac);
                g = (int) (g * fac);
                b = (int) (b * fac);

                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                alp = (255<<24) | (r<<16) | (g<<8) | b;
                newImage.setRGB(x,y,alp);
            }
        }
        return newImage;
    }  
} 