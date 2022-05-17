package classes;

/**
 * This class is used to represent and update the current score of the game.
 */

public class ScoreUI {

    private int cash;

    /**
     * This is the scoreUI constructor.
     *@param cash the initial cash value for the game
     */
    public ScoreUI(int cash) {
        this.cash = cash;
    }

    /**
     * Adds a certain value to the current score.
     * @param integer the amount we want to add up by
     */
    public void addBy(int integer) {
        cash = cash + integer;
    }

    /**
     * Subtracts a certain value off the current score.
     * @param integer the amount we want to subtract by
     */
    public void subtractBy(int integer) {
        cash = cash - integer;
    }

    /**
     * Getter to get current score value
     * @return current score
     */
    public int getCash() {
        return cash;
    }
}