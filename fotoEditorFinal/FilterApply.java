package fotoEditorFinal;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FilterApply 
{
    private ArrayList<Filter> appliedFilters;
    private int cursor;
    private BufferedImage initialImage;

    public FilterApply(BufferedImage initialImage) 
    {
        this.initialImage = initialImage;
        this.cursor = 0;
        this.appliedFilters = new ArrayList<>();
    }

    public void addFilter(Filter filter) 
    {
        while (appliedFilters.size() > cursor) 
        {
            appliedFilters.remove(appliedFilters.size() - 1);
        }
        appliedFilters.add(filter);
        cursor++;
    }

    public void undo() 
    {
        if (cursor > 0) 
        {
            cursor--;
        }
    }

    public BufferedImage getRenderBufferedImage() 
    {
        BufferedImage renderedImage = new BufferedImage(initialImage.getColorModel(), initialImage.getRaster(), false, null);

        for (int i = 0; i < cursor; i++) 
        {
            Filter filter = appliedFilters.get(i);
            renderedImage = filter.applyFilter(renderedImage);
        }
        return renderedImage;
    }

    public void redo() 
    {
        if (cursor < appliedFilters.size()) 
        {
            cursor++;
        }
    }
}
