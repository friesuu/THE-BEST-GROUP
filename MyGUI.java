// package Testing2DGame.Main;

// import java.awt.CardLayout;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;

// import Testing2DGame.Entity.Player;

// public class MyGUI extends JFrame
// {
//     public Player player;
//     public static CardLayout cardLayout;
//     public static JPanel cardPanel;
//     public KeyHandler keyHandler;

//     public MyGUI() 
//     {
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setResizable(true);
//         setTitle("Pokemon-Kanto Adventures");

//         GamePanel panel = new GamePanel();
//         add(panel);

//         pack();

//         setLocationRelativeTo(null);
//         setVisible(true);
        
//         panel.setupGame();
//         panel.startGameThread();

//         // // Create a CardLayout
//         cardLayout = new CardLayout();
//         cardPanel = new JPanel(cardLayout);

//         // Create panels for different screens
//         JPanel mainPanel = new JPanel();
//         JPanel otherPanel = new JPanel();

//         // Add components to the main panel
//         // mainPanel.add(new JLabel("Main Screen"));
//         // JButton switchButton = new JButton("Switch to Other Screen");
//         // switchButton.addActionListener(new ActionListener() {
//         //     @Override
//         //     public void actionPerformed(ActionEvent e) {
//         //         // Call method to switch panels
//         //         switchToOtherPanel();
//         //     }
//         // });
//         // mainPanel.add(switchButton);

//         // Add components to the other panel
//         otherPanel.add(new JLabel("Other Screen"));
//         JButton backButton = new JButton("Go Back");
//         backButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) 
//             {
//                 // Call method to switch panels
//                 // panel.update();
//                 // panel.repaint();
//                 //panel.startGameThread();
//                 if(panel.gameState == panel.playState)
//                 {
//                     panel.gameState = panel.pauseState;
//                     }
//                     else if(panel.gameState == panel.pauseState)
//                     {
//                         panel.gameState = panel.playState;
//                         }
            
//                 switchToMainPanel();

//                 //new MyGUI();
//             }
//         });
//         otherPanel.add(backButton);

//         // Add the panels to the cardPanel
//         cardPanel.add(panel, "main"); // Constraints acts as an identifier (key)
//         cardPanel.add(otherPanel, "other");

//         // Add the cardPanel to the frame
//         add(cardPanel);

//         setVisible(true);
//     }

//     public static void switchToOtherPanel() 
//     {
//         cardLayout.show(cardPanel, "other");
//     }

//     // Method to switch back to the main panel
//     public void switchToMainPanel() 
//     {
//         cardLayout.show(cardPanel, "main");
//     }
        
//     // public static void main(String[] args) 
//     // {
//     //     new MyGUI();
//     // }
// }
