package classes;

import classes.barrier.*;

import game.Main;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used to represent the game player (thief).
 * The player can move around the map.
 * The player can get higher scores and dodge enemies to finally reach the exit and win.
 */

public class Player extends GameComponent {

    int speedX = 0;
    int speedY = 0;
    int accel = 5;
    int currentCash = 0;

    ScoreUI display = new ScoreUI(currentCash);

    /**
     * This is the player constructor.
     *@param positionX the X coordinate of the object
     *@param positionY the Y coordinate of the object
     */
    public Player(int positionX, int positionY) {
        super(positionX, positionY);
    }

    /**
     * Draws player image onto screen.
     * @param load the graphic context in Main that we want to load the image on
     */
    public void render(GraphicsContext load) {
        load.drawImage(getImage(), this.getPositionX(), this.getPositionY());
    }

    /**
     * Updates movement of the enemy.
     */
    public void update() {
        statusUpdateCheck();
        collisionEnemyCheck();
        collisionBombCheck();
        collisionRewardCheck();
        collisionBonusCheck();
        collisionBarrierCheck();
        positionX += speedX;
        positionY += speedY;
    }

    /**
     * Gets current score value.
     * @return current score value
     */
    public int getCurrentCash() {
        return currentCash;
    }

    /**
     * Controls movement of player using arrow keys.
     * @param scene current scene of the game (in Main)
     */
    public void control(Scene scene) {
        scene.setOnKeyPressed(event -> {
                    if (event.getCode().equals(KeyCode.UP)) {
                        speedY -= accel;
                    } else if (event.getCode().equals(KeyCode.DOWN)) {
                        speedY += accel;
                    } else if (event.getCode().equals(KeyCode.LEFT)) {
                        speedX -= accel;
                    } else if (event.getCode().equals(KeyCode.RIGHT)) {
                        speedX += accel;
                    }
                }
        );

        scene.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.UP)) {
                speedY = 0;
            }
            if (event.getCode().equals(KeyCode.DOWN)) {
                speedY = 0;
            }
            if (event.getCode().equals(KeyCode.LEFT)) {
                speedX = 0;
            }
            if (event.getCode().equals(KeyCode.RIGHT)) {
                speedX = 0;
            }
        });
    }

    /**
     * @return a rectangle boundary of object with length = 35 and width = 35
     */
    @Override
    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX + speedX, positionY + speedY, 35, 35);
    }

    /**
     * This is the getter for current speedX of player.
     * @return current speedX of player
     */
    public int getSpeedX() {
        return speedX;
    }

    /**
     * This is the getter for current speedY of player.
     * @return current speedY of player
     */
    public int getSpeedY() {
        return speedY;
    }

    // Handles collision checks of all components in the maze
    private void collisionEnemyCheck() {
        ArrayList<Enemy> enemies = Main.getEnemy();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemyCheck = enemies.get(i);
            if (intersects(enemyCheck)) {
                Main.getEnemy().remove(enemyCheck);
                Main.setIsRunning(1);
            }
        }
    }

    private void collisionBombCheck() {
        ArrayList<Punishment> bombs = Main.getPunishment();
        for (int i = 0; i < bombs.size(); i++) {
            Punishment bombsCheck = bombs.get(i);
            if (intersects(bombsCheck)) {
                Main.getPunishment().remove(bombsCheck);

//                if (currentCash >= 0) {
//              Use function call instead of if condition
                display.subtractBy(20);
                currentCash = display.getCash();
                statusUpdateCheck();
//                }
            }
        }
    }

    private void collisionRewardCheck() {
        ArrayList<Reward> rewards = Main.getReward();
        for (int i = 0; i < rewards.size(); i++) {
            Reward rewardsCheck = rewards.get(i);
            if (intersects(rewardsCheck)) {
                Main.getReward().remove(rewardsCheck);

                if (currentCash >= 0) {
                    display.addBy(10);
                    currentCash = display.getCash();
                }
            }
        }
    }

    private void collisionBonusCheck() {
        ArrayList<Bonus> bonuses = Main.getBonus();
        if (Main.checkBonus) {
            for (int i = 0; i < bonuses.size(); i++) {
                Bonus bonusesCheck = bonuses.get(i);
                if (intersects(bonusesCheck)) {
                    Main.getBonus().remove(bonusesCheck);

                    if (currentCash >= 0) {
                        display.addBy(20);
                        currentCash = display.getCash();
                    }
                }
            }
        }
    }

    private void collisionBarrierCheck() {
        ArrayList<Barrier> barriers = Main.getBarrier();
        for (int i = 0; i < barriers.size(); i++) {
            Barrier barriersCheck = barriers.get(i);
            if (getBoundary().intersects(barriersCheck.getBoundary())) {
                speedX = 0;
                speedY = 0;
            }
        }
    }


    private void statusUpdateCheck() {
        if (currentCash < 0) {
            Main.setIsRunning(1);
        }
    }

    private Image getImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Thief.jpg")));
    }
}