package Main;

import javax.swing.*; //Importing classes from the ``Javax.swing`` package.

public class Main {
    public static void main(String [] args){
        // We will create a Frame Object
        JFrame window = new JFrame();

        //Adding our Panel Class
        Panel pan = new Panel();
        window.add(pan); //Adding panel to our window
        window.pack(); //The window adapts to the dimensions of the panel

       

        // Setting our game properties
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The game terminates when it exited.
        window.setResizable(false); // The game is fixed to specific dimensions
        window.setTitle("Apple Catcher"); // Our game title
        window.setLocationRelativeTo(null); // The game is displayed at the centre of one's screen
        window.setVisible(true); // The pop-up window will be visible

        //Launching our Gamethread
        pan.launch();
    }
}
