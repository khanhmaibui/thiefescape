package classes;

import game.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

/**
 * This class is used to represent an 'exit' event in the game that, when triggered,
 * will cause the game to exit and determine the player's victory.
 * It shows as a door image in the game UI.
 */

public class Exit extends GameComponent{

    /**
     * This is the exit constructor.
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Exit(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws exit image onto screen.
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getImage(), this.getPositionX(), this.getPositionY());
    }

    /**
     * Checks the status of the game.
     */
    public void update() { winConditionCheck(); }

    private void winConditionCheck() {
        if (Main.getPlayer().get(0).getPositionX() == Main.getExit().get(0).getPositionX()
                && Main.getPlayer().get(0).getPositionY() == Main.getExit().get(0).getPositionY()
                && Main.getReward().size() == 0) {
            Main.setIsRunning(2);
        }
    }

    private Image getImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/door.png")));
    }
}
