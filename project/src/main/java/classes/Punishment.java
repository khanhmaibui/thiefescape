package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This class is used to represent the game punishment (bomb).
 * If the player collides with the punishment, they will lose 20 points.
 * To get higher scores, the player should avoid the punishment.
 */

public class Punishment extends GameComponent {

    /**
     * This is the punishment constructor.
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Punishment(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws punishment image onto screen.
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getImage(), this.getPositionX(), this.getPositionY());
    }
    
    private Image getImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/bomb.png")));
    }
}
