//MAIN CLASS

package graphgui;
import java.awt.Canvas;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class GraphGui {
private static Gui gui;
    
    public static void main(String[] args) {
        Canvas c = new Canvas();
        try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
		gui = new Gui();
	}
	public static Gui getGUI() {
		return gui;
	
    }
    
}
