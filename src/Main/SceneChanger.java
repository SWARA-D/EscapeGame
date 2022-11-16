package Main;

public class SceneChanger
{
    GameManager gm;

    public SceneChanger(GameManager gm)
    {
        this.gm = gm;
    }

    public void showScene1()
    {
        gm.ui.bgPanel[0].setVisible(true);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.messageText.setText("Enter the Green Room");
    }

    public void showScene2()
    {
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.messageText.setText("Enter the Red Room");
    }

    public void showScene3()
    {
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
    }
}
