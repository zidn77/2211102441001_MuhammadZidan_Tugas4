import greenfoot.*;

public class Player extends Actor {
    private int score = 0;
    
    public Player() {
        setImage("player.png");
    }

    public void act() {
        checkForCollision();
        moveWithArrowKeys();
        checkGameOver(); // Pemanggilan metode checkGameOver
    }
    
    public void checkForCollision() {
        Actor object = getOneIntersectingObject(SpesialObject.class);
        if (object != null) {
            increaseScore();
            getWorld().removeObject(object);
        }
    }

    public void increaseScore() {
        score += 10;
        getWorld().showText("Score: " + score, 50, 25);
    }

    public void moveWithArrowKeys() {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 5);
        }
    }
    
    public void checkGameOver(){
        if (score >= 100) { // Ubah dari Score menjadi score
            getWorld().showText("Game Over You Win!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        } else if (getWorld().getObjects(Player.class).isEmpty()) { // Ubah dari getObjects menjadi getWorld().getObjects
            getWorld().showText("Game Over You Lose!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }        
    }
}

