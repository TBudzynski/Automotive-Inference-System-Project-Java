package ais;
import core.Gamers;
import gui.JFrameForm;
import core.Temporary;

/**
 * Main class.
 *
 * @author Tomasz Budzynski
 */
public class AIS  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* System.out.println("Output test");
        JFrameForm form = new JFrameForm();
        form.setVisible(true);
        Temporary temp = new Temporary();
        temp.model();
        temp.search();*/
       
       
       // Utworzenie obiektu gamers typu Gamers i wywołanie obu metod z klasy Gamers 
          Gamers gamers = new Gamers();
        gamers.model();
        gamers.search();
    }
}