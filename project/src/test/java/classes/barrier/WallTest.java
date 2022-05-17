package classes.barrier;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WallTest {

    private Wall wall;

    @BeforeEach
    void setup() {
        wall = new Wall(40, 40);
    }

    @Test
    void createWall() {
        assertNotNull(wall);
        assertEquals(40, wall.getPositionX());
        assertEquals(40, wall.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, wall.getBoundary());
    }

}
