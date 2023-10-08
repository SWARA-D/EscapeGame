package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener
{
    GameManager gm;

    public ActionHandler(GameManager gm)
    {
        this.gm = gm;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String choice = e.getActionCommand();

        switch(choice)
        {
            case "Open Drawers":
                gm.ev1.OpenDrawers();
                break;
            case "Move Drawers":
                gm.ev1.MoveDrawers();
                break;
            case "Look at Painting":
                gm.ev1.LookPainting();
                break;
            case "Move Painting":
                gm.ev1.MovePainting();
                break;
            case "Look at Plant":
                gm.ev1.LookPlant();
                break;
            case "Pluck Plant":
                gm.ev1.PluckPlant();
                break;
            case "nextScene1":
                gm.sc.showScene1();
                break;
            case "nextScene2":
                gm.sc.showScene2();
                break;
            case "Look At Sofa":
                gm.ev1.LookSofa();
                break;
            case "Move Sofa":
                gm.ev1.MoveSofa();
                break;
            case "Look At Door":
                gm.ev1.LookDoor();
                break;
            case "Open Door":
                gm.ev1.OpenDoor();
                break;
        }
    }
}
