package classes.barrier;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This class is used to represent the "wall" in the game.
 * It is one of the barrier types
 */
public class Wall extends Barrier {

    /**
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Wall(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws wall image onto screen
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getWall(), this.getPositionX(), this.getPositionY());
    }

    private Image getWall() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/wall.jpg")));
    }

}