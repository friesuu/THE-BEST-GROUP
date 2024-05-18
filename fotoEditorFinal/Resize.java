package fotoEditorFinal;

import java.awt.image.BufferedImage;

public class Resize implements Filter 
{
    int newHeight;
    int newWidth;

    Resize(int newHeight, int newWidth) 
    {
        this.newHeight = newHeight;
        this.newWidth = newWidth;
    }

    @Override
    public BufferedImage applyFilter(BufferedImage img) 
    {
        BufferedImage inputImage = img;

        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        
        outputImage.createGraphics().drawImage(inputImage.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH),0, 0, null);

        System.out.println("Image resized successfully.");
        return outputImage;
    }
}