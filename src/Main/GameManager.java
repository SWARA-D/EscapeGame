package Main;

import Event.Event01;

public class GameManager
{

    ActionHandler actionHandler = new ActionHandler(this);

    public UI ui = new UI(this);

    public Player player = new Player(this);

    public SceneChanger sc = new SceneChanger(this);

    public Event01 ev1 = new Event01(this);

    public static void main(String[] args)
    {
        new GameManager();
    }

    public GameManager()
    {
        player.setDefault();

        sc.showScene1();


    }
}
