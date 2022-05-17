package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This class is used to represent the reward (money).
 * The player can collect the reward to get points.
 * If the player collides with the reward, they will gain 10 points.
 * Collect all the money and dodge enemies to finally reach the exit and win.
 */

public class Reward extends GameComponent {

    /**
     * This is the reward constructor.
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Reward(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws reward image onto screen.
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getImage(), this.getPositionX(), this.getPositionY());
    }
    
    private Image getImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Money.png")));
    }
}