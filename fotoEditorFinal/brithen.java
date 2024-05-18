package fotoEditorFinal;

import java.awt.image.BufferedImage;

/**
 * brithen
 */
public class brithen implements Filter {
            int precentage;
        
        brithen(int precentage){
            this.precentage = precentage;
        }

    @Override
    public BufferedImage applyFilter(BufferedImage img){


        int r = 0, g = 0, b = 0, rgb = 0, p = 0;
        int amount = (int)(precentage * 255/100);
        BufferedImage newImage= new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < img.getHeight(); y+=1) {
            for (int x = 0; x < img.getWidth(); x+=1) {
                rgb = img.getRGB(x, y);
                r = ((rgb >> 16) & 0xFF)+amount;
                g = ((rgb >> 8) & 0xFF)+amount; 
                b = ((rgb & 0xFF)+amount);
                if(r>255) r = 255;
                if(g>255) g = 255;
                if(b>255) b = 255;
                p = (255<<24) | (r << 16) | (g << 8) | b;
                newImage.setRGB(x, y, p);
    
    
                
            }
            
        }
            return newImage;
    }
    
} 