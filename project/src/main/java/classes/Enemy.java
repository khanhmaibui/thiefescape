package classes;

import classes.barrier.Barrier;
import game.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used to represent the enemy (police).
 * The enemy can move around the map.
 * If the player collides with the enemy, the player lose the game.
 */

public class Enemy extends GameComponent {
    
    private int speedX = 0;
    private int speedY = 0;

    /**
     * This is the enemy constructor.
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Enemy(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws enemy image onto screen.
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getImage(), this.getPositionX(), this.getPositionY());
    }

    /**
     * Updates movement of the enemy.
     * @param targetX the X coordinate of the target
     * @param targetY the Y coordinate of the target
     */
    public void update(int targetX, int targetY) {
        xPosMovement(targetX);
        yPosMovement(targetY);
        collisionCheck();
        positionX += speedX;
        positionY += speedY;
    }

    /**
     * This is the getter for current speedX of enemy.
     * @return current speedX of enemy
     */
    public int getSpeedX() {
        return speedX;
    }
    /**
     * This is the getter for current speedY of enemy.
     * @return current speedY of enemy
     */
    public int getSpeedY() {
        return speedY;
    }

    /**
     * @return a rectangle boundary of object with length = 40 and width = 40
     */
    @Override
    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX+speedX,positionY+speedY,40,40);
    }

    //Determines horizontal movement values
    private void xPosMovement(int targetX) {
        speedX = Integer.compare(targetX, positionX);
    }

    //Determines vertical movement values
    private void yPosMovement(int targetY) {
        speedY = Integer.compare(targetY, positionY);
    }

    private void collisionCheck() {
        ArrayList<Barrier> barriers = Main.getBarrier();
        for (Barrier barriersCheck : barriers) {
            if (getBoundary().intersects(barriersCheck.getBoundary())) {
                speedX = 0;
                speedY = 0;
            }
        }
    }

    private Image getImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/police.png")));
    }
}
