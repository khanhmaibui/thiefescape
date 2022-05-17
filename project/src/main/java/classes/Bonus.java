package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This class is used to represent the "bonus" in the game.
 * It shows the bonus as a diamond.
 * And the bonus will appear and disappear randomly during the game.
 */

public class Bonus extends GameComponent {

    /**
     * This is the bonus constructor.
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Bonus(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws bonus image onto screen.
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getImage(), this.getPositionX(), this.getPositionY());
    }

    private Image getImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Diamond_.png")));
    }

}