package Event;

import Main.GameManager;

public class Event01
{
    GameManager gm;

    public Event01(GameManager gm)
    {
        this.gm = gm;
    }

    public void OpenDrawers()
    {
        if(gm.player.hasKey == 0)
        {
            if(gm.player.currentLife == gm.player.maxLife) {
                gm.ui.messageText.setText("Found a Key!");
                gm.player.hasKey = 1;
                gm.player.updateStatus();
            }

            else {
                gm.ui.messageText.setText("You need five lives to open the drawer");
            }
        }

        else
        {
            gm.ui.messageText.setText("You already have the Key");
        }
    }

    public void MoveDrawers()
    {
        gm.ui.messageText.setText("Too Heavy to Move!");
    }

    public void LookPainting()
    {
        gm.ui.messageText.setText("Ooh! Vey Pretty!");
    }

    public void MovePainting()
    {
        gm.ui.messageText.setText("Nothing here");
    }

    public void LookPlant()
    {
        if(gm.player.hasCan == 1 && gm.player.currentLife!=gm.player.maxLife)
        {
            gm.ui.messageText.setText("Gained a Life!");
            gm.player.currentLife++;
            gm.player.updateStatus();
        }

        else if(gm.player.currentLife==gm.player.maxLife)
        {
            gm.ui.messageText.setText("Max Life reached");
        }

        else {
            gm.ui.messageText.setText("Needs Water!");
        }
    }

    public void PluckPlant()
    {
        if(gm.player.currentLife != 0) {
            gm.ui.messageText.setText("Lost a Life!");
            gm.player.currentLife--;
            gm.player.updateStatus();
        }

        else
        {
            gm.ui.messageText.setText("No more life to lose!");
        }

    }
    
    public void LookSofa() { gm.ui.messageText.setText("Ohh! So Dusty!");
    }

    public void MoveSofa() {

        if(gm.player.hasCan == 0) {
            gm.ui.messageText.setText("Found Watering Can!");
            gm.player.hasCan = 1;
            gm.player.updateStatus();
        }

        else
        {
            gm.ui.messageText.setText("You have the Watering Can!");
        }
    }
    
    public void LookDoor() { gm.ui.messageText.setText("Maybe a Way Out?");
    }

    public void OpenDoor()
    {
        if(gm.player.hasKey == 1)
        {
            gm.ui.messageText.setText("Found a way out!");
            gm.sc.showScene3();
        }

        else
        {
            gm.ui.messageText.setText("Needs a Key!");
        }
    }
}
