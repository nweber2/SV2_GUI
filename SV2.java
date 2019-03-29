/*
SV2 is the second program in a swquence of "Squaresville" programs. This
one refines the stubs of the parrot in a way that results in a primitive 
sort of Logo like system, but one in which the turle is referred to as 
a robot. This system is proimitive becouse its primitives are primitive,
but also becouse it provides no mechanism for defining new commands.
 */
package gui;

import frames.SV2Frame;
import javax.swing.SwingUtilities;

/**
 *
 * @author nicho
 */
public class SV2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ThreadForGUI());
    }

    private static class ThreadForGUI implements Runnable {

        public void run() {
            SV2 sv = new SV2();
        }
    }

    public SV2() {
        SV2Frame frame = new SV2Frame("Squareville");
        frame.reset();
    }
}
