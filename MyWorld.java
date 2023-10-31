import greenfoot.*;
import java.util.*;
public class MyWorld extends World {
    private LinkedList<snake> snake = new LinkedList<snake>();
    private int dx=1;
    private int dy=0;
    private int tailCounter = 1;
    private boolean dead = false;
    
    public MyWorld() {
        super(25, 20, 32);
        snake body = new snake();
        snake.add(body);
        addObject(body, 2, 2);
        
        apel apel = new apel();
        addObject(apel,
            Greenfoot.getRandomNumber(getWidth()-2)+1,
            Greenfoot.getRandomNumber(getHeight()-2)+1);
        
        for (int x = 0; x < getWidth(); x++) {
            addObject(new border(), x, 0);
            addObject(new border(), x, getHeight() - 1);
        }
        for (int y = 0; y < getHeight(); y++) {
            addObject(new border(), 0 , y);
            addObject(new border(),getWidth() - 1, y);
        }
    }
    public void act() {
        if (dead) return;
        changeDirection();
        snake head = snake.getLast();
        snake newHead = new snake();
        int newHeadX = head.getX() + dx;
        int newHeadY = head.getY() + dy;
        
        List<block> blocks = getObjectsAt(newHeadX, newHeadY, block.class);
        for (block block : blocks) {
            block.collision(this);
        }
        
        addObject(newHead, newHeadX, newHeadY);
        snake.add(newHead);
        if(tailCounter == 0) {
            snake tail = snake.removeFirst();
            removeObject(tail);
        } else {
            tailCounter--;
        }
    }
    private void changeDirection() {
        if(Greenfoot.isKeyDown("left") && dx == 0) {
            dx = -1;
            dy = 0;
        }
        if(Greenfoot.isKeyDown("right") && dx == 0) {
            dx = 1;
            dy = 0;
        }
        if(Greenfoot.isKeyDown("down") && dy == 0) {
            dx = 0;
            dy = 1;
        }
        if(Greenfoot.isKeyDown("up") && dy == 0) {
            dx = 0;
            dy = -1;
        }
    }
    public void dead() {
        dead = true;
    }
    public void grow(int size) {
        tailCounter+=size;
    }
}
