package Main;

public class Player
{
    GameManager gm;

    public int maxLife;
    public int currentLife;

    public int hasCan;
    public int hasKey;

    public Player(GameManager gm)
    {
        this.gm = gm;
    }

    public void setDefault()
    {
        maxLife = 5;
        currentLife = 3;

        hasCan = 0;
        hasKey = 0;

        updateStatus();
    }

    public void updateStatus()
    {
        int i = 0;
        while(i<5)
        {
            gm.ui.lifelabel[i].setVisible(false);
            i++;
        }

        int lifeCount = currentLife;

        while(lifeCount!=0)
        {
            gm.ui.lifelabel[lifeCount-1].setVisible(true);
            lifeCount--;
        }

        if(hasCan == 0)
        {
            gm.ui.watercanlabel.setVisible(false);
        }

        if(hasCan == 1)
        {
            gm.ui.watercanlabel.setVisible(true);
        }

        if(hasKey == 0)
        {
            gm.ui.keylabel.setVisible(false);
        }

        if(hasKey == 1)
        {
            gm.ui.keylabel.setVisible(true);
        }
    }

}
