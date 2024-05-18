package fotoEditorFinal;

import javax.swing.JFrame;

public class Main 
{
    public static void main(String[] args) 
    {
        FotoEditorGUI editor = new FotoEditorGUI();
        editor.setExtendedState(JFrame.MAXIMIZED_BOTH);
        editor.setVisible(true);
    }
}