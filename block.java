import greenfoot.*;
public class block extends Actor
{
    public void act()
    {
        // Add your action code here.
    }
    public void collision(MyWorld world) {
        world.dead();
    }
}
