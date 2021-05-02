import java.awt.Color;

public class Function_Colour {
    
    GUI gui;

    public Function_Colour(GUI gui) {

        this.gui = gui;
    }

    public void changeColour(String Colour) {

        switch (Colour) {
            case "White": 
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
                break;
            case "Black": 
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
                break;
            case "Blue": 
                gui.window.getContentPane().setBackground(Color.blue);
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(Color.white);
                break;
            
        }
    }
}
