package classes;

import javafx.geometry.Rectangle2D;

/**
 * This class is used to get the position of boundary.
 * The boundaries will check whether the
 * objects collide during the game.
 */

public class GameComponent {

    /**
     * This is to store current positionX of object.
     */
    protected int positionX;

    /**
     * This is to store current positionY of object.
     */
    protected int positionY;

    /**
     * This is the game component constructor.
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public GameComponent(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * This is the getter for current positionX of object.
     * @return current X coordinate of object
     */
    public int getPositionX() {
        return this.positionX;
    }
    /**
     * This is the getter for current positionY of object.
     * @return current Y coordinate of object
     */
    public int getPositionY() {
        return this.positionY;
    }

    /**
     * This is the setter for setting current positionX of object.
     * @param positionX value to set current positionX
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * This is the setter for setting current positionY of object.
     * @param positionY value to set current positionX
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * @return a rectangle boundary of object with length = 40 and width = 40
     */
    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, 40, 40);
    }

    /**
     * Checks whether the objects intersect.
     * @param newGC the object we want to check collision with
     * @return true or false depending on whether the object collide
     */
    public boolean intersects(GameComponent newGC) {
        return getBoundary().intersects(newGC.getBoundary());
    }
}
