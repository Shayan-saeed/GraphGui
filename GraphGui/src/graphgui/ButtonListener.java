//BUTTON LISTENER CLASS

package graphgui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ButtonListener implements ActionListener {

    private String buttonName;
    private JFrame help;
    private static int id = 0;
    Canvas c;
    static Graph graph = GraphicalPicturePanel.getGraph();

    public ButtonListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonName = e.getActionCommand();

        if (buttonName.equals("Add Edges")) {
            id = 1;
            graph.setAllEdges();
            GraphGui.getGUI().getCanvas().repaint();
            id = 0;
        }
        if (buttonName.equals("Connected Components")) {
            id = 2;
            graph.DFS(graph.getVertices().get(0));
            GraphGui.getGUI().getCanvas().repaint();
        }
//        if (buttonName.equals("Clear Graph")) {
//            id = 3;
//             
//        }
        if (buttonName.equals("Help")) {
            id = 3;
            help = new JFrame("Help");
            setHelpFrame();
        }
        c = new Canvas() {

            //paint the canvas
            @Override
            public void paint(Graphics g) {
            }

        };
        c.setBackground(Color.white);

        //add mouse listener to canvas
    }

    
    public void setHelpFrame() {
        help.setSize(600, 600);
        help.setBackground(Color.BLACK);
        help.setResizable(false);
        JTextArea helpMenu = new JTextArea();
        helpMenu.setBackground(Color.WHITE);
        helpMenu.setFont(helpMenu.getFont().deriveFont(22f));
        helpMenu.setEditable(false);
        helpMenu.setText("--------------------------------------------------------------------------------------"
                + "\n\tWelcome to the Graph-Gui"
                + "\n\n         To add a vertex click the radio button and click on"
                + "\n the right side of the screen (The canvas) to place a dot."
                + "\n--------------------------------------------------------------------------------------"
                + "\n            Add an edge by clicking on two vertices   "
                + "\n    If you want to add an edge between all vertices \n\t   click add all edges"
                + "\n--------------------------------------------------------------------------------------"
                + "\n            Move a vertex by clicking on a vertex once  "
                + "\n    and click on another part of the canvas to move it"
                + "\n--------------------------------------------------------------------------------------");
        help.add(helpMenu);
        help.setVisible(true);
    }

    public static int idOfButton() {
        return id;
    }

    public static void setIdButton(int newID) {
        id = newID;
    }

    //End of ButtonListener class
}
