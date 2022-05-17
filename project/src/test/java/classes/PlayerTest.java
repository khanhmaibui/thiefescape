package classes;

import classes.barrier.Wall;
import game.Main;
import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;
    private Wall wall;

    @BeforeEach
    void setup() {
        player = new Player(40, 40);
        wall = new Wall(0,0);
    }

    @Test
    void createPlayer() {
        assertNotNull(player);
        assertEquals(40, player.getPositionX());
        assertEquals(40, player.getPositionY());
        assertEquals(0, player.getSpeedX());
        assertEquals(0, player.getSpeedY());
        assertEquals(0, player.getCurrentCash());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 35, 35);
        assertEquals(newRec, player.getBoundary());
    }

    @Test
    void checkLeftMove() {
        player.speedX -= player.accel;
        player.update();
        assertNotNull(player);
        assertEquals(35, player.getPositionX());
        assertEquals(40, player.getPositionY());
    }

    @Test
    void checkRightMove() {
        player.speedX += player.accel;
        player.update();
        assertNotNull(player);
        assertEquals(45, player.getPositionX());
        assertEquals(40, player.getPositionY());
    }

    @Test
    void checkUpMove() {
        player.speedY -= player.accel;
        player.update();
        assertNotNull(player);
        assertEquals(40, player.getPositionX());
        assertEquals(35, player.getPositionY());
    }

    @Test
    void checkDownMove() {
        player.speedY += player.accel;
        player.update();
        assertNotNull(player);
        assertEquals(40, player.getPositionX());
        assertEquals(45, player.getPositionY());
    }

    @Test
    void checkPlayerWallCollision1() {
        player.setPositionX(22);
        player.setPositionY(23);

        //expect player to not change its position
        wall.setPositionX(23);
        wall.setPositionY(23);

        Main.getBarrier().add(wall);
        player.speedX += player.accel;
        player.update();

        assertEquals(0, Main.isRunning);
        assertEquals(22, player.getPositionX());
        assertEquals(23, player.getPositionY());

        Main.getBarrier().clear();
    }

    @Test
    void checkPlayerWallCollision2() {
        player.setPositionX(24);
        player.setPositionY(23);

        //expect player to not change its position
        wall.setPositionX(23);
        wall.setPositionY(23);

        Main.getBarrier().add(wall);
        player.speedX -= player.accel;
        player.update();

        assertEquals(0, Main.isRunning);
        assertEquals(24, player.getPositionX());
        assertEquals(23, player.getPositionY());

        Main.getBarrier().clear();
    }

    @Test
    void checkPlayerWallCollision3() {
        player.setPositionX(23);
        player.setPositionY(22);

        //expect player to not change its position
        wall.setPositionX(23);
        wall.setPositionY(23);

        Main.getBarrier().add(wall);
        player.speedY -= player.accel;
        player.update();

        assertEquals(0, Main.isRunning);
        assertEquals(23, player.getPositionX());
        assertEquals(22, player.getPositionY());

        Main.getBarrier().clear();
    }

    @Test
    void checkPlayerWallCollision4() {
        player.setPositionX(23);
        player.setPositionY(24);

        //expect player to not change its position
        wall.setPositionX(23);
        wall.setPositionY(23);

        Main.getBarrier().add(wall);
        player.speedY += player.accel;
        player.update();

        assertEquals(0, Main.isRunning);
        assertEquals(23, player.getPositionX());
        assertEquals(24, player.getPositionY());

        Main.getBarrier().clear();
    }

    @Test
    void checkPlayerWallCollision5() {
        player.setPositionX(23);
        player.setPositionY(24);

        //expect player to change its position
        //since player and wall don't collide
        wall.setPositionX(70);
        wall.setPositionY(100);

        Main.getBarrier().add(wall);

        player.speedY += player.accel;
        player.update();

        assertEquals(0, Main.isRunning);
        assertEquals(23, player.getPositionX());
        assertEquals(29, player.getPositionY());

        Main.getBarrier().clear();
    }
}
