import greenfoot.*;

public class Enemy extends Actor {
    private int speed = 4; // Kecepatan pergerakan musuh
    private int proximity = 40; // Jarak minimum yang diperlukan untuk "Game Over"

    public Enemy() {
        setImage("enemy.png");
    }

    public void act() {
        Player player = (Player) getWorld().getObjects(Player.class).get(0); // Dapatkan referensi ke Player

        if (player != null) {
            followPlayer(player);

            // Periksa jarak antara Enemy dan Player
            if (getDistance(player) <= proximity) {
                // Musuh menyentuh Player dalam jarak yang ditentukan
                getWorld().showText("Game Over You Lose!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                Greenfoot.stop();
            }
        }
    }

    private void followPlayer(Player player) {
        int targetX = player.getX();
        int targetY = player.getY();
        int deltaX = targetX - getX();
        int deltaY = targetY - getY();

        if (Math.abs(deltaX) > 1 || Math.abs(deltaY) > 1) {
            double angle = Math.atan2(deltaY, deltaX);
            int moveX = (int) (speed * Math.cos(angle));
            int moveY = (int) (speed * Math.sin(angle));

            setLocation(getX() + moveX, getY() + moveY);
        }
    }

    private int getDistance(Player player) {
        int deltaX = player.getX() - getX();
        int deltaY = player.getY() - getY();
        return (int) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
