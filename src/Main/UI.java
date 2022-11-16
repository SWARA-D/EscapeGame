package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class UI
{
    JFrame window;
    GameManager gm;

    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    JPanel lifepanel;
    JLabel lifelabel[] = new JLabel[5];
    JPanel inventorypanel;
    public JLabel watercanlabel, keylabel;

    public UI(GameManager gm)
    {
        this.gm = gm;

        createMainField();

        createPlayerField();

        generateScreen();

        window.setVisible(true);
    }


    public void createMainField()
    {
        window = new JFrame();
        window.setSize(1200,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.lightGray);
        window.setLayout(null);

        messageText = new JTextArea("HELLO, KHELO");
        messageText.setBounds(40,480,1100,200);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Helvetica", Font.PLAIN, 22));

        window.add(messageText);

    }

    public void createBackground(int bgNum, String bgName)
    {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(40,50, 1100, 400);
        bgPanel[bgNum].setBackground(Color.white);
        bgPanel[bgNum].setLayout(null);

        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,1100,400);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgName));

        bgLabel[bgNum].setIcon(bgIcon);

    }

    public void createObject(int objX, int objY, int objW, int objH, String objN, int bgNum, String choice1, String choice2, String comm1, String comm2)
    {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItem[] = new JMenuItem[3];

        menuItem[0] = new JMenuItem(choice1);
        menuItem[0].addActionListener(gm.actionHandler);
        menuItem[0].setActionCommand(comm1);
        popupMenu.add(menuItem[0]);

        menuItem[1] = new JMenuItem(choice2);
        menuItem[1].addActionListener(gm.actionHandler);
        menuItem[1].setActionCommand(comm2);
        popupMenu.add(menuItem[1]);

        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objX, objY, objW, objH);

        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e))
                {
                    popupMenu.show(objectLabel,e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objN));
        objectLabel.setIcon(objectIcon);

        bgPanel[bgNum].add(objectLabel);
    }
}
