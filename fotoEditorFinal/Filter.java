package fotoEditorFinal;

import java.awt.image.BufferedImage;

public interface Filter 
{
    public BufferedImage applyFilter(BufferedImage input);
} 