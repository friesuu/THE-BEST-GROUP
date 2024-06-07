package PokemonKantoAdventure;//package assigment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game {

    JFrame window;
    Container con;//base
    JPanel titleNP, startButtonPanel, mainTextPanel, choiceButtonPanel, rivalTextPanel;
    JLabel titleJL;
    Font titleFont = new Font("Times New Roman",Font.PLAIN,80);
    Font startButtonFont = new Font("Times New Roman",Font.PLAIN,23);
    Font normalFont = new Font("Times New Roman",Font.PLAIN,22);
    JButton startButton, ch1Button, ch2Button, ch3Button, ch4Button, ch5Button;
    JTextArea mainTextArea,rivalJTextArea;
    String position;

    TitleScreenHandler tScreenHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        // PokemonKantoAdventure.Dijkstra dijkstra = new PokemonKantoAdventure.Dijkstra();
        // String tt = dijkstra.getRandomTargetTown();
        // System.out.println(tt);
        new Game();
    }

    public Game(){

        //MAKING A WINDOW
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//CAN CLOSE THE WINDOW
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);//SO THAT WINDOW IS VISIBLE
        con = window.getContentPane();


        titleNP = new JPanel();//CREATING SPACE FOR THE TITLE
        titleNP.setBounds(100, 100, 600, 150);//XY STARTING POINT
        titleNP.setBackground(Color.black);//colour of the space created
        titleJL = new JLabel("ADVENTURE");//CREATING THE TEXT FOR TITLE
        titleJL.setForeground(Color.white); //colour of the text
        titleJL.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(startButtonFont);
        startButton.addActionListener(tScreenHandler);//WHEN BUTTON CLICK IT WILL HAVE ACTION
        startButton.setFocusPainted(false);

        titleNP.add(titleJL);
        startButtonPanel.add(startButton);

        con.add(titleNP);//SHOW THE SPACE CREATED ERLIER
        con.add(startButtonPanel);

    }

    public void createGameScreen (){
        titleNP.setVisible(false);//WHEN START BUTTON CLICK THIS WILL BE INVISIBLE
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,50,630,280);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("add text here");
        mainTextArea.setBounds(100, 50, 630, 280);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);//LAP THE TEXT IF TOO LONG TEXT
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(5, 1));
        con.add(choiceButtonPanel);

        ch1Button = new JButton("1");
        ch1Button.setBackground(Color.black);
        ch1Button.setForeground(Color.white);
        ch1Button.setFont(startButtonFont);
        ch1Button.setFocusPainted(false);
        ch1Button.addActionListener(choiceHandler);//when click the button it fx
        ch1Button.setActionCommand("c1");//for program to recognice which button
        choiceButtonPanel.add(ch1Button);

        ch2Button = new JButton("2");
        ch2Button.setBackground(Color.black);
        ch2Button.setForeground(Color.white);
        ch2Button.setFont(startButtonFont);
        ch2Button.setFocusPainted(false);
        ch2Button.addActionListener(choiceHandler);
        ch2Button.setActionCommand("c2");
        choiceButtonPanel.add(ch2Button);

        ch3Button = new JButton("3");
        ch3Button.setBackground(Color.black);
        ch3Button.setForeground(Color.white);
        ch3Button.setFont(startButtonFont);
        ch3Button.setFocusPainted(false);
        ch3Button.addActionListener(choiceHandler);
        ch3Button.setActionCommand("c3");
        choiceButtonPanel.add(ch3Button);

        ch4Button = new JButton("4");
        ch4Button.setBackground(Color.black);
        ch4Button.setForeground(Color.white);
        ch4Button.setFont(startButtonFont);
        ch4Button.setFocusPainted(false);
        ch4Button.addActionListener(choiceHandler);
        ch4Button.setActionCommand("c4");
        choiceButtonPanel.add(ch4Button);

        ch5Button = new JButton("5");
        ch5Button.setBackground(Color.black);
        ch5Button.setForeground(Color.white);
        ch5Button.setFont(startButtonFont);
        ch5Button.setFocusPainted(false);
        ch5Button.addActionListener(choiceHandler);
        ch5Button.setActionCommand("c5");
        choiceButtonPanel.add(ch5Button);

        playerSetup();
    }

    private void playerSetup() {
        SaffronCity();
    }

    public void SaffronCity(){
        position = "SaffronCity";
        mainTextArea.setText("-------------------------------------------------------\n" +
                "You are currently in Saffron PokemonKantoAdventure.City:\n" +
                "-------------------------------------------------------\n" +
                "[1] Move to:\r\n" + //
                " a.Cerulean PokemonKantoAdventure.City b.Lavender Town c.Vermillion PokemonKantoAdventure.City d.Celadon PokemonKantoAdventure.City\n"+ //
                "[2] Challenge Gym leader [Sabrina- Psychic type]\r\n" + //
                "[3] Fight Wild PokemonKantoAdventure.Pokemon\r\n" + //
                "[4] PokemonKantoAdventure.Player Options\r\n" + //
                " a.Show map b.Show My PokemonKantoAdventure.Pokemon c.Show My badges d.Save and Exit\r\n" + //
                "[5] Rival’s Race");

        ch1Button.setText("1");
        ch2Button.setText("2");
        ch3Button.setText("3");
        ch4Button.setText("4");
        ch5Button.setText("5");
    }
    public void CeruleanCity(){
        position = "CeruleanCity";
        mainTextArea.setText("-------------------------------------------------------\n" +
                "You are currently in Cerulean PokemonKantoAdventure.City:\n" +
                "-------------------------------------------------------\n" +
                "[1] Move to:\r\n" + //
                " a.Saffron PokemonKantoAdventure.City b.Lavender Town c.Vermillion PokemonKantoAdventure.City d.Celadon PokemonKantoAdventure.City\n"+ //
                "[2] Challenge Gym leader [Sabrina- Psychic type]\r\n" + //
                "[3] Fight Wild PokemonKantoAdventure.Pokemon\r\n" + //
                "[4] PokemonKantoAdventure.Player Options\r\n" + //
                " a.Show map b.Show My PokemonKantoAdventure.Pokemon c.Show My badges d.Save and Exit\r\n" + //
                "[5] Rival’s Race");

        ch1Button.setText("1");
        ch2Button.setText("2");
        ch3Button.setText("3");
        ch4Button.setText("4");
        ch5Button.setText("5");
    }
    public void LavenderTown(){
        position = "LavenderTown";
        mainTextArea.setText("-------------------------------------------------------\n" +
                "You are currently in Lavender Town:\n" +
                "-------------------------------------------------------\n" +
                "[1] Move to:\r\n" + //
                " a.Cerulean PokemonKantoAdventure.City b.Saffron PokemonKantoAdventure.City c.Vermillion PokemonKantoAdventure.City d.Celadon PokemonKantoAdventure.City\n"+ //
                "[2] Challenge Gym leader [Sabrina- Psychic type]\r\n" + //
                "[3] Fight Wild PokemonKantoAdventure.Pokemon\r\n" + //
                "[4] PokemonKantoAdventure.Player Options\r\n" + //
                " a.Show map b.Show My PokemonKantoAdventure.Pokemon c.Show My badges d.Save and Exit\r\n" + //
                "[5] Rival’s Race");

        ch1Button.setText("1");
        ch2Button.setText("2");
        ch3Button.setText("3");
        ch4Button.setText("4");
        ch5Button.setText("5");
    }
    public void VermillionCity(){
        position = "VermillionCity";
        mainTextArea.setText("-------------------------------------------------------\n" +
                "You are currently in Vermillion PokemonKantoAdventure.City:\n" +
                "-------------------------------------------------------\n" +
                "[1] Move to:\r\n" + //
                " a.Cerulean PokemonKantoAdventure.City b.Lavender Town c.Saffron PokemonKantoAdventure.City d.Celadon PokemonKantoAdventure.City\n"+ //
                "[2] Challenge Gym leader [Sabrina- Psychic type]\r\n" + //
                "[3] Fight Wild PokemonKantoAdventure.Pokemon\r\n" + //
                "[4] PokemonKantoAdventure.Player Options\r\n" + //
                " a.Show map b.Show My PokemonKantoAdventure.Pokemon c.Show My badges d.Save and Exit\r\n" + //
                "[5] Rival’s Race");

        ch1Button.setText("1");
        ch2Button.setText("2");
        ch3Button.setText("3");
        ch4Button.setText("4");
        ch5Button.setText("5");
    }
    public void CeladonCity(){
        position = "CeladonCity";
        mainTextArea.setText("-------------------------------------------------------\n" +
                "You are currently in Celadon PokemonKantoAdventure.City:\n" +
                "-------------------------------------------------------\n" +
                "[1] Move to:\r\n" + //
                " a.Cerulean PokemonKantoAdventure.City b.Lavender Town c.Vermillion PokemonKantoAdventure.City d.Saffron PokemonKantoAdventure.City\n"+ //
                "[2] Challenge Gym leader [Sabrina- Psychic type]\r\n" + //
                "[3] Fight Wild PokemonKantoAdventure.Pokemon\r\n" + //
                "[4] PokemonKantoAdventure.Player Options\r\n" + //
                " a.Show map b.Show My PokemonKantoAdventure.Pokemon c.Show My badges d.Save and Exit\r\n" + //
                "[5] Rival’s Race");

        ch1Button.setText("1");
        ch2Button.setText("2");
        ch3Button.setText("3");
        ch4Button.setText("4");
        ch5Button.setText("5");
    }


    public void choice1(){
        position="choice1";
        mainTextArea.setText("Where you wanna go?");

        ch1Button.setText("Cerulean PokemonKantoAdventure.City");
        ch2Button.setText("Lavender Town");
        ch3Button.setText("Vermillion PokemonKantoAdventure.City");
        ch4Button.setText("Celadon PokemonKantoAdventure.City");
        ch5Button.setText("<");

    }
    public void choice2(){
    }
    public void choice3(){

    }
    public void choice4(){
        position="choice4";
        mainTextArea.setText("Options: ");

        ch1Button.setText("Show Map");
        ch2Button.setText("Show my pokemon");
        ch3Button.setText("Show My Badges");
        ch4Button.setText("Save and Exit");
        ch5Button.setText("<");
    }


    public void choice5(){
        position ="choice5";
        choiceButtonPanel.setVisible(false);//remove the choice button

        Dijkstra dijkstra = new Dijkstra();
        String tt = dijkstra.getRandomTargetTown();
        String sp = dijkstra.getShortestPath();

        mainTextArea.setText("\nThe battle has begun! Your rival Gary has challenged you to a race to\n" + //
                tt+"\n\n"+sp+"\n\nGoodluck on your race!");
    }


    public class TitleScreenHandler implements ActionListener  {
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed (ActionEvent event){
            String yourChoice = event.getActionCommand();//either c1,c2,c3,c4,c5 as string

            switch (position) {
                case "SaffronCity":
                    switch (yourChoice) {
                        case "c1": choice1();break;
                        case "c2": choice2();break;
                        case "c3": choice3();break;
                        case "c4": choice4();break;
                        case "c5": choice5();break;
                        default:break;
                    } break;
                case "choice1":
                    switch (yourChoice) {
                        case "c1": CeruleanCity();break;
                        case "c2": LavenderTown();break;
                        case "c3": VermillionCity();;break;
                        case "c4": CeladonCity();break;
                        case "c5": SaffronCity();break;
                        default:break;
                    }break;
                case "choice4":
                    switch (yourChoice) {
                        case "c1": ;break;
                        case "c2": ;break;
                        case "c3": ;break;
                        case "c4": ;break;
                        case "c5": SaffronCity();break;
                        default:break;
                    }break;
            }

        }
    }
}
