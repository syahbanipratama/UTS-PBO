import greenfoot.*;
public class apel extends block
{
    public void act()
    {
        // Add your action code here.
    }
    public void collision(MyWorld world) {
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()-2) +1,
            Greenfoot.getRandomNumber(getWorld().getHeight()-2) +1);
        world.grow(2);
    }
}
