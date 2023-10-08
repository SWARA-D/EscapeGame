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
    
    public void createArrow(int bgNum, int arrX, int arrY, int arrW, int arrH, String arrN, String comm)
    {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrN));

        JButton arrowB = new JButton();
        arrowB.setBounds(arrX,arrY,arrW,arrH);
        arrowB.setBackground(null);
        arrowB.setContentAreaFilled(false);
        arrowB.setFocusPainted(false);
        arrowB.setIcon(arrowIcon);
        arrowB.addActionListener(gm.actionHandler);
        arrowB.setActionCommand(comm);
        arrowB.setBorderPainted(false);

        bgPanel[bgNum].add(arrowB);
    }

    public void createPlayerField()
    {
        lifepanel = new JPanel();
        lifepanel.setBounds(50,0,250,50);
        lifepanel.setBackground(Color.lightGray);
        lifepanel.setLayout(new GridLayout(1,5));
        window.add(lifepanel);

        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("liferose.png"));

        int i = 0;
        while(i<5)
        {
            lifelabel[i] = new JLabel();
            lifelabel[i].setIcon(lifeIcon);

            lifepanel.add(lifelabel[i]);

            i++;
        }

        inventorypanel = new JPanel();
        inventorypanel.setBounds(1050,0,100,50);
        inventorypanel.setBackground(Color.lightGray);
        inventorypanel.setLayout(new GridLayout(1,2));

        watercanlabel = new JLabel();
        keylabel = new JLabel();

        ImageIcon waterIcon = new ImageIcon(getClass().getClassLoader().getResource("watercan.png"));
        watercanlabel.setIcon(waterIcon);

        ImageIcon keyIcon = new ImageIcon(getClass().getClassLoader().getResource("key.png"));
        keylabel.setIcon(keyIcon);

        inventorypanel.add(watercanlabel);
        inventorypanel.add(keylabel);

        window.add(inventorypanel);
    }

    public void generateScreen()
    {
        createBackground(0,"greenroom.png");

        createObject(225,250,200,115, "drawers.png",0, "Open", "Move","Open Drawers", "Move Drawers");
        createObject(730,100,100,99,"paintings.png",0, "Look", "Move","Look at Painting", "Move Painting");
        createObject(255,177,38,83,"plant.png",0, "Look", "Pluck","Look at Plant", "Pluck Plant");

        createArrow(0,0,150, 50, 50, "arrowleft.png", "nextScene2");

        bgPanel[0].add(bgLabel[0]);

        createBackground(1,"redroom.jpg");

        createObject(225,160,300,204, "sofa.png",1, "Look", "Move","Look At Sofa", "Move Sofa");
        createObject(725,75,100,207, "door.png",1, "Look", "Open","Look At Door", "Open Door");

        createArrow(1,1050,150, 50, 50, "arrowright.png", "nextScene1");

        bgPanel[1].add(bgLabel[1]);

        createBackground(2, "outside.png");

        bgPanel[2].add(bgLabel[2]);
    }
}
