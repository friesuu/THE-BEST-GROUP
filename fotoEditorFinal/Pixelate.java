package fotoEditorFinal;

import java.awt.image.BufferedImage;

public class Pixelate implements Filter 
{
    int n;

    Pixelate(int n) 
    {
        this.n = n;
    }

    @Override
    public BufferedImage applyFilter(BufferedImage img) 
    {
        BufferedImage pixImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < img.getHeight(); y += n) 
        {
            for (int x = 0; x < img.getWidth(); x += n) 
            {
                int totalRed = 0, totalGreen = 0, totalBlue = 0, totalAlpha = 0;

                for (int a = 0; a < n; a++) 
                {
                    for (int b = 0; b < n; b++) 
                    {
                        int pixelX = Math.min(x + a, img.getWidth() - 1);
                        int pixelY = Math.min(y + b, img.getHeight() - 1);

                        int rgb = img.getRGB(pixelX, pixelY);
                        totalAlpha += (rgb >> 24) & 0xFF;
                        totalRed += (rgb >> 16) & 0xFF;
                        totalGreen += (rgb >> 8) & 0xFF;
                        totalBlue += rgb & 0xFF;
                    }
                }

                int avgAlpha = totalAlpha / (n * n);
                int avgRed = totalRed / (n * n);
                int avgGreen = totalGreen / (n * n);
                int avgBlue = totalBlue / (n * n);

                int avgColor = (avgAlpha << 24) | (avgRed << 16) | (avgGreen << 8) | avgBlue;

                for (int a = 0; a < n; a++) 
                {
                    for (int b = 0; b < n; b++) 
                    {
                        int pixelX = Math.min(x + a, img.getWidth() - 1);
                        int pixelY = Math.min(y + b, img.getHeight() - 1);
                        pixImg.setRGB(pixelX, pixelY, avgColor);
                    }
                }
            }
        }

        return pixImg;
    }
}
