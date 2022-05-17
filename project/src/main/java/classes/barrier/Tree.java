package classes.barrier;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This class is used to represent the "tree" in the game.
 * It is one of the barrier types
 */
public class Tree extends Barrier {

    /**
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Tree(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws tree image onto screen
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getTree(), this.getPositionX(), this.getPositionY());
    }

    private Image getTree() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/tree.png")));
    }

}