package classes.barrier;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This class is used to represent the "building2" in the game.
 * It is one of the barrier types
 */
public class Building2 extends Barrier {

    /**
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Building2(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws building image onto screen
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getBuilding(), this.getPositionX(), this.getPositionY());
    }

    private Image getBuilding() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/building2.png")));
    }

}
