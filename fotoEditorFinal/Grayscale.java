package fotoEditorFinal;

import java.awt.image.BufferedImage;

public class Grayscale implements Filter 
{
	public Grayscale()
	{

	}

    @Override
    public BufferedImage applyFilter(BufferedImage image)
    {
        System.out.println("Converting to GrayScale.");
		BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		int rgb=0, r=0, g=0, b=0;
		for (int y=0; y<image.getHeight(); y++) 
        {
			for (int x=0; x<image.getWidth(); x++) 
            {
				rgb = (int)(image.getRGB(x, y));
				r = ((rgb >> 16) & 0xFF);
				g = ((rgb >> 8) & 0xFF);
				b = (rgb & 0xFF);
				//rgb = (int)((r+g+b)/3);
				rgb = (int)(0.299 * r + 0.587 * g + 0.114 * b);
				rgb = (255<<24) | (rgb<<16) | (rgb<<8) | rgb;
				grayImage.setRGB(x,y,rgb);
			}
		}
		return grayImage;
    }  
}