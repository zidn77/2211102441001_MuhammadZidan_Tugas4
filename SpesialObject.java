import greenfoot.*;

public class SpesialObject extends Actor {
    private GreenfootSound collectSound = new GreenfootSound("sounds.wav");

    public SpesialObject() {
        setImage("object.png");
    }

    public void act() {
        moveDown();
        checkForCollision();
    }

    public void moveDown() {
        // Pergerakan SpesialObject ke bawah
        setLocation(getX(), getY() + 1);

        // Saat mencapai batas bawah layar, hapus SpesialObject
        if (getY() >= getWorld().getHeight() - 1) {
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }

    public void checkForCollision() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            player.increaseScore();
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
            playCollectSound(); // Memainkan efek suara
        }
    }

    public void playCollectSound() {
        collectSound.play();
    }
}
