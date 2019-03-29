package frames;

import static com.sun.webkit.perf.WCFontPerfLogger.reset;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Compiler.command;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import utiliities.Random;
import shapes.SSquare;
import painter.SPainter;
import static utilities.Random.color;

/**
 *
 * @author nicho
 */
public class SV2Frame extends JFrame implements ActionListener {

    JButton blueButton;
    JButton redButton;
    JButton yellowButton;
    JButton colorButton;
    JButton mfdButton;
    JButton mbkButton;
    JButton mrtButton;
    JButton mltButton;
    JButton lrtButton;
    JButton lltButton;
    JButton lmfButton;
    JButton srtButton;
    JButton sltButton;
    JButton nopButton;
    JButton clearButton;
    JButton cleanButton;
    JButton resetButton;
    JButton thing1Button;
    JButton thing2Button;
    JButton thing3Button;
    JButton thing4Button;
    JButton thing5Button;
    JPanel reflector;
    JTextArea output;
    JTextField input;
    SPainter painter;
    SSquare square;
    static private Color BLUE = new Color(51, 21, 255);
    static private Color RED = new Color(255, 51, 100);
    static private Color YELLOW = new Color(255, 233, 51);

    public SV2Frame(String title) {
        super(title);
        this.square = new SSquare(20);
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents(getContentPane());
        addListeners();
        setVisible(true);
        setResizable(false);

    }

    private void addComponents(Container contentPane) {
        //north region

        clearButton = new JButton("Clear");
        cleanButton = new JButton("Clean");
        resetButton = new JButton("Rest");
        JPanel controlPanel = new JPanel();

        //controlPanel.setLayout(new FlowLayout());
        controlPanel.add(clearButton);
        controlPanel.add(cleanButton);
        controlPanel.add(resetButton);

        //western region
        blueButton = new JButton("BLUE");
        redButton = new JButton("RED");
        yellowButton = new JButton("YELLOW");
        colorButton = new JButton("COLOR");
        mfdButton = new JButton("MFD");
        mbkButton = new JButton("MBK");
        mrtButton = new JButton("MRT");
        mltButton = new JButton("MLT");
        lrtButton = new JButton("LRT");
        lltButton = new JButton("LLT");
        lmfButton = new JButton("LMF");
        srtButton = new JButton("SRT");
        sltButton = new JButton("SLT");
        nopButton = new JButton("NOP");

        JPanel controlPanelleft = new JPanel(new GridLayout(14, 1, 0, 1));
        controlPanelleft.add(blueButton);
        controlPanelleft.add(redButton);
        controlPanelleft.add(yellowButton);
        controlPanelleft.add(colorButton);
        controlPanelleft.add(mfdButton);
        controlPanelleft.add(mbkButton);
        controlPanelleft.add(mrtButton);
        controlPanelleft.add(mltButton);
        controlPanelleft.add(lrtButton);
        controlPanelleft.add(lltButton);
        controlPanelleft.add(lmfButton);
        controlPanelleft.add(srtButton);
        controlPanelleft.add(sltButton);
        controlPanelleft.add(nopButton);

        //eastern region
        thing1Button = new JButton("THING1");
        thing2Button = new JButton("THING2");
        thing3Button = new JButton("THING3");
        thing4Button = new JButton("THING4");
        thing5Button = new JButton("THING5");

        JPanel controlPanelright = new JPanel(new GridLayout(5, 1, 0, 1));
        controlPanelright.add(thing1Button);
        controlPanelright.add(thing2Button);
        controlPanelright.add(thing3Button);
        controlPanelright.add(thing4Button);
        controlPanelright.add(thing5Button);

        int width = 730;
        int height = 315;
        reflector = new JPanel();
        reflector.setSize(new Dimension(width,height));
        painter = new SPainter(reflector);
        output = new JTextArea(width, height);
        output.setBackground(Color.WHITE);
        output.setWrapStyleWord(true);
        output.setLineWrap(true);
        Container centralRegion = new Container();
        centralRegion.setLayout(new GridLayout(2, 1, 6, 6));
        //centralRegion.add(reflector);
        centralRegion.add(output);
        centralRegion.add(painter);
        //southern region
        input = new JTextField();

        contentPane.setLayout(new BorderLayout());
        contentPane.add(controlPanel, BorderLayout.NORTH);
        contentPane.add(centralRegion, BorderLayout.CENTER);
        contentPane.add(input, BorderLayout.SOUTH);
        contentPane.add(controlPanelleft, BorderLayout.WEST);
        contentPane.add(controlPanelright, BorderLayout.EAST);
    }

    private void addListeners() {
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        colorButton.addActionListener(this);
        mfdButton.addActionListener(this);
        mbkButton.addActionListener(this);
        mrtButton.addActionListener(this);
        mltButton.addActionListener(this);
        lrtButton.addActionListener(this);
        lmfButton.addActionListener(this);
        lltButton.addActionListener(this);
        srtButton.addActionListener(this);
        sltButton.addActionListener(this);
        nopButton.addActionListener(this);
        clearButton.addActionListener(this);
        clearButton.addActionListener(this);
        cleanButton.addActionListener(this);
        resetButton.addActionListener(this);
        thing1Button.addActionListener(this);
        thing2Button.addActionListener(this);
        thing3Button.addActionListener(this);
        thing4Button.addActionListener(this);
        thing5Button.addActionListener(this);
        //reflector.addActionListener(this);
        input.addActionListener(this);
        //output.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        processCommand(command);
        if (event.getSource() instanceof JTextField) {
            input.setText("");
        }
    }

    private void processCommand(String command) {
        output.append(command.toUpperCase() + " ");
        if (command.equalsIgnoreCase("RED")) {
            red();
        } else if (command.equalsIgnoreCase("YELLOW")) {
            yellow();
        } else if (command.equalsIgnoreCase("BLUE")) {
            blue();
        } else if (command.equalsIgnoreCase("COLOR")) {
            color();
        } else if (command.equalsIgnoreCase("MFD")) {
            mfd();
        } else if (command.equalsIgnoreCase("MBK")) {
            mbk();
        } else if (command.equalsIgnoreCase("MRT")) {
            mrt();
        } else if (command.equalsIgnoreCase("MLT")) {
            mlt();
        } else if (command.equalsIgnoreCase("LMF")) {
            lmf();
        } else if (command.equalsIgnoreCase("SRT")) {
            srt();
        } else if (command.equalsIgnoreCase("SLT")) {
            slt();
        } else if (command.equalsIgnoreCase("LRT")) {
            lrt();
        } else if (command.equalsIgnoreCase("LLT")) {
            llt();
        } else if (command.equalsIgnoreCase("LMF")) {
            lmf();
        } else if (command.equalsIgnoreCase("SRT")) {
            srt();
        } else if (command.equalsIgnoreCase("SLT")) {
            slt();
        } else if (command.equalsIgnoreCase("NOP")) {
            nop();
        } else if (command.equalsIgnoreCase("CLEAN")) {
            clean();
        } else if (command.equalsIgnoreCase("CLEAR")) {
            clear();
        } else if (command.equalsIgnoreCase("RESET")) {
            reset();
        } else if (command.equalsIgnoreCase("THING1")) {
            thing1();
        } else if (command.equalsIgnoreCase("THING2")) {
            thing2();
        } else if (command.equalsIgnoreCase("THING3")) {
            thing3();
        } else if (command.equalsIgnoreCase("THING4")) {
            thing4();
        } else if (command.equalsIgnoreCase("THING5")) {
            thing5();
        } else {
            output.append("### UNRECOGNIZED COMMAND: " + command.toUpperCase() + " ### ");
        }
    }

    private void red() {
        painter.setColor(RED);
        paintSquare();
    }

    private void yellow() {
        painter.setColor(YELLOW);
        paintSquare();
    }

    private void blue() {
        painter.setColor(BLUE);
        paintSquare();
    }

    private void color() {
        painter.setColor(Random.color());
        paintSquare();
    }

    private void paintSquare() {
        painter.paint(square);
    }

    private void mfd() {
        painter.mfd(square.side());
    }

    private void mbk() {
        painter.mbk(square.side());
    }

    private void mrt() {
        painter.mrt(square.side());
    }

    private void mlt() {
        painter.mlt(square.side());
    }

    private void lrt() {
        painter.mfd(square.side());
        painter.tr();
        painter.mfd(square.side());
    }

    private void llt() {
        painter.mfd(square.side());
        painter.tl();
        painter.mfd(square.side());
    }

    private void lmf() {
        painter.mfd(square.side() * 2);
    }

    private void srt() {
        painter.tr();
    }

    private void slt() {
        painter.tl();
    }

    private void nop() {
        output.append("");
    }

    private void clean() {
        painter.wash();
    }

    private void clear() {
        output.setText(null);
    }

    public void reset() {
        painter.moveToCenter();
        painter.faceNorth();
        painter.wash();
        painter.setColor(Color.WHITE);
        painter.paint(new SSquare(1000));
        output.setText(null);
    }

    private void thing1() {
        llt();
        llt();
        red();
        blue();
        llt();
        lmf();
        blue();
    }

    private void thing2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void thing3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void thing4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void thing5() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
