package fotoEditorFinal;

import java.awt.image.BufferedImage;

public class DetectEdges implements Filter 
{
    public DetectEdges()
    {

    }
    
    @Override
    public BufferedImage applyFilter(BufferedImage img)
    {
        int h = img.getHeight(), w = img.getWidth(), threshold=30, p = 0;
        BufferedImage edgeImg = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        int[][] vert = new int[w][h];
        int[][] horiz = new int[w][h];
        int[][] edgeWeight = new int[w][h];

        for (int y=1; y<h-1; y++) 
        {
            for (int x=1; x<w-1; x++) 
            {
                vert[x][y] = (int)(img.getRGB(x+1, y-1)& 0xFF + 2*(img.getRGB(x+1, y)& 0xFF) + img.getRGB(x+1, y+1)& 0xFF
                    - img.getRGB(x-1, y-1)& 0xFF - 2*(img.getRGB(x-1, y)& 0xFF) - img.getRGB(x-1, y+1)& 0xFF);
                horiz[x][y] = (int)(img.getRGB(x-1, y+1)& 0xFF + 2*(img.getRGB(x, y+1)& 0xFF) + img.getRGB(x+1, y+1)& 0xFF
                    - img.getRGB(x-1, y-1)& 0xFF - 2*(img.getRGB(x, y-1)& 0xFF) - img.getRGB(x+1, y-1)& 0xFF);
                edgeWeight[x][y] = (int)(Math.sqrt(vert[x][y] * vert[x][y] + horiz[x][y] * horiz[x][y]));
                if (edgeWeight[x][y] > threshold)
                    p = (255<<24) | (255<<16) | (255<<8) | 255;
                else 
                    p = (255<<24) | (0<<16) | (0<<8) | 0; 
                edgeImg.setRGB(x,y,p);
            }
        }
        return edgeImg;
    }
}
