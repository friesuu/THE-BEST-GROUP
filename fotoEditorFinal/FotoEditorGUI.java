package fotoEditorFinal;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FotoEditorGUI extends JFrame 
{
    private BufferedImage image;
    private JLabel imageLabel;
    private GeneralPath currentPath;
    private boolean drawingMode = false; // flag to indicate drawing mode
    private FilterApply filterApply;

    public FotoEditorGUI() 
    {
        setTitle("Image Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

        imageLabel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                if (drawingMode) 
                {
                    startDrawing(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) 
            {
                if (drawingMode) 
                {
                    stopDrawing();
                }
            }
        });

        imageLabel.addMouseMotionListener(new MouseMotionAdapter() 
        {
            @Override
            public void mouseDragged(MouseEvent e) 
            {
                if (drawingMode) 
                {
                    continueDrawing(e.getX(), e.getY());
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        JButton startDrawingButton = new JButton("Start Drawing");
        startDrawingButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                drawingMode = !drawingMode;
                if (drawingMode) 
                {
                    startDrawingButton.setText("Stop Drawing");
                } 
                else 
                {
                    startDrawingButton.setText("Start Drawing");
                }
            }
        });

        JButton openButton = new JButton("Open Image");
        openButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                openImage();
            }
        });

        JButton saveButton = new JButton("Save Image");
        saveButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                saveImage();
            }
        });

        JButton grayscaleButton = new JButton("Grayscale Image");
        grayscaleButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                filterApply.addFilter(new Grayscale());
                render();
            }
        });

        JButton invertButton = new JButton("Invert Image Color");
        invertButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                filterApply.addFilter(new ColorInImage());
                render();
            }
        });

        JButton heavyBlurButton = new JButton("Heavy Blur");
        heavyBlurButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                filterApply.addFilter(new HeavyBlur());
                render();
            }
        });

        JButton edgeDetectionButton = new JButton("Edge Detection");
        edgeDetectionButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                filterApply.addFilter(new DetectEdges());
                render();
            }
        });

        JButton blurButton = new JButton("Blur Image");
        blurButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                filterApply.addFilter(new Blur());
                render();
            }
        });

        JButton brightnessButton = new JButton("Adjust Brightness");
        brightnessButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    String input = JOptionPane.showInputDialog(FotoEditorGUI.this, "Enter brightness adjustment level:");
                    int percentage = Integer.parseInt(input);
                    filterApply.addFilter(new Brighten(percentage));
                    render();
                } 
                catch (NumberFormatException ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Invalid brightness level input", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Error adjusting brightness", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton pixelateButton = new JButton("Pixelate Image");
        pixelateButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    String input = JOptionPane.showInputDialog(FotoEditorGUI.this, "Enter pixel size for pixelation:");
                    int pixelSize = Integer.parseInt(input);
                    filterApply.addFilter(new Pixelate(pixelSize));
                    render();
                } 
                catch (NumberFormatException ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Invalid pixel size input", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Error applying pixelation", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton resizeButton = new JButton("Resize Image");
        resizeButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    String input = JOptionPane.showInputDialog(FotoEditorGUI.this, "Enter new height for resizing:");
                    String inputWidth = JOptionPane.showInputDialog(FotoEditorGUI.this, "Enter new width for resizing:");
                    int newHeight = Integer.parseInt(input);
                    int newWidth = Integer.parseInt(inputWidth);
                    filterApply.addFilter(new Resize(newHeight, newWidth));
                    render();
                } 
                catch (NumberFormatException ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Invalid height or width input", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Error resizing image", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    filterApply.undo();
                    render();
                } 
                catch (NumberFormatException ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Invalid height input", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Error resizing image", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    filterApply.redo();
                    render();
                } 
                catch (NumberFormatException ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Invalid height input", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FotoEditorGUI.this, "Error resizing image", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPanel.add(startDrawingButton);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(grayscaleButton);
        buttonPanel.add(invertButton);
        buttonPanel.add(heavyBlurButton);
        buttonPanel.add(edgeDetectionButton);
        buttonPanel.add(blurButton);
        buttonPanel.add(brightnessButton);
        buttonPanel.add(pixelateButton);
        buttonPanel.add(resizeButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);

        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);

        add(buttonPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);

        filterApply = new FilterApply(image);
        render();
    }

    private void startDrawing(int x, int y) 
    {
        currentPath = new GeneralPath();
        currentPath.moveTo(x, y);
    }

    private void continueDrawing(int x, int y) 
    {
        if (currentPath != null) 
        {
            currentPath.lineTo(x, y);
            render();
        }
    }

    private void stopDrawing() 
    {
        if (currentPath != null) 
        {
            filterApply.addFilter(new DrawFilter(currentPath));
            currentPath = null;
            render();
        }
    }

    private void render() 
    {
        BufferedImage image = filterApply.getRenderBufferedImage();
        imageLabel.setIcon(new ImageIcon(image));
    }

    private void openImage() 
    {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            try 
            {
                BufferedImage image = ImageIO.read(selectedFile);
                filterApply = new FilterApply(image);
                render();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    private void saveImage() 
    {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            try 
            {
                ImageIO.write(filterApply.getRenderBufferedImage(), "PNG", selectedFile);
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
