package classes;

import classes.barrier.Wall;
import game.Main;
import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    private Enemy enemy;
    private Wall wall;

    @BeforeEach
    void setup() {
        enemy = new Enemy(40, 40);
        wall = new Wall(0,0);
    }

    @Test
    void createEnemy() {
        assertNotNull(enemy);
        assertEquals(40, enemy.getPositionX());
        assertEquals(40, enemy.getPositionY());
        assertEquals(0, enemy.getSpeedX());
        assertEquals(0, enemy.getSpeedY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, enemy.getBoundary());
    }

    @Test
    void checkLeftMove() {
        enemy.update(30, 40);
        assertNotNull(enemy);
        assertEquals(39, enemy.getPositionX());
        assertEquals(40, enemy.getPositionY());
    }

    @Test
    void checkRightMove() {
        enemy.update(50, 40);
        assertNotNull(enemy);
        assertEquals(41, enemy.getPositionX());
        assertEquals(40, enemy.getPositionY());
    }

    @Test
    void checkUpMove() {
        enemy.update(40, 30);
        assertNotNull(enemy);
        assertEquals(40, enemy.getPositionX());
        assertEquals(39, enemy.getPositionY());
    }

    @Test
    void checkDownMove() {
        enemy.update(40, 50);
        assertNotNull(enemy);
        assertEquals(40, enemy.getPositionX());
        assertEquals(41, enemy.getPositionY());
    }

    @Test
    void checkPlayerWallCollision1() {
        enemy.setPositionX(22);
        enemy.setPositionY(23);

        //expect enemy to not change its position
        wall.setPositionX(23);
        wall.setPositionY(23);

        Main.getBarrier().add(wall);

        enemy.update(70, 23);

        assertEquals(0, Main.isRunning);
        assertEquals(22, enemy.getPositionX());
        assertEquals(23, enemy.getPositionY());

        Main.getBarrier().clear();
    }

    @Test
    void checkPlayerWallCollision2() {
        enemy.setPositionX(50);
        enemy.setPositionY(23);

        //expect enemy to not change its position
        wall.setPositionX(49);
        wall.setPositionY(23);

        Main.getBarrier().add(wall);

        enemy.update(10, 23);

        assertEquals(0, Main.isRunning);
        assertEquals(50, enemy.getPositionX());
        assertEquals(23, enemy.getPositionY());

        Main.getBarrier().clear();
    }

    @Test
    void checkPlayerWallCollision3() {
        enemy.setPositionX(50);
        enemy.setPositionY(67);

        //expect enemy to not change its position
        wall.setPositionX(50);
        wall.setPositionY(68);

        Main.getBarrier().add(wall);

        enemy.update(50, 100);

        assertEquals(0, Main.isRunning);
        assertEquals(50, enemy.getPositionX());
        assertEquals(67, enemy.getPositionY());

        Main.getBarrier().clear();
    }

    @Test
    void checkPlayerWallCollision4() {
        enemy.setPositionX(50);
        enemy.setPositionY(66);

        //expect enemy to not change its position
        wall.setPositionX(50);
        wall.setPositionY(68);

        Main.getBarrier().add(wall);

        enemy.update(50, 10);

        assertEquals(0, Main.isRunning);
        assertEquals(50, enemy.getPositionX());
        assertEquals(66, enemy.getPositionY());

        Main.getBarrier().clear();
    }

    @Test
    void checkPlayerWallCollision5() {
        enemy.setPositionX(50);
        enemy.setPositionY(66);

        //expect enemy to change its position
        //since enemy and wall don't collide
        wall.setPositionX(50);
        wall.setPositionY(150);

        Main.getBarrier().add(wall);

        enemy.update(50, 10);

        assertEquals(0, Main.isRunning);
        assertEquals(50, enemy.getPositionX());
        assertEquals(65, enemy.getPositionY());

        Main.getBarrier().clear();
    }

}
