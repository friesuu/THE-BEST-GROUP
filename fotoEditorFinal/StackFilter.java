package fotoEditorFinal;

import java.awt.image.BufferedImage;

public class StackFilter implements Filter 
{
    BufferedImage[] otherImage;

    StackFilter(BufferedImage[] img) 
    {
        this.otherImage = img;
    }

    @Override
    public BufferedImage applyFilter(BufferedImage input) 
    {  
        return null;
    }
}
