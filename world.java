import greenfoot.*;  
import java.util.Random;

public class world extends World
{
    private int specialObjectDelay = 100; // Delay (dalam langkah) untuk munculnya SpecialObject
    private int specialObjectCounter = 0; // Menghitung langkah yang telah berlalu

    public world()
    {    
        super(600, 400, 1); 
        prepare();
    }

    public void act() {
        

        // Memeriksa apakah sudah waktunya muncul SpecialObject
        if (specialObjectCounter >= specialObjectDelay) {
            spawnSpecialObject();
            specialObjectCounter = 0; // Reset counter
        } else {
            specialObjectCounter++;
        }
    }
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player,66,199);
        Player player2 = new Player();
        addObject(player2,560,203);
        removeObject(player2);
        Enemy enemy = new Enemy();
        addObject(enemy,543,196);
    }
    
    // Fungsi untuk membuat SpecialObject
    private void spawnSpecialObject() {
        Random random = new Random();
        int x = random.nextInt(getWidth()); // Koordinat acak X
        int y = 0; // Koordinat Y di atas layar
        SpesialObject specialObject = new SpesialObject();
        addObject(specialObject, x, y);
    }
}
