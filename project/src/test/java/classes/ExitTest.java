package classes;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExitTest {

    private Exit exit;

    @BeforeEach
    void setup() {
        exit = new Exit(40, 40);
    }

    @Test
    void createExit() {
        assertNotNull(exit);
        assertEquals(40, exit.getPositionX());
        assertEquals(40, exit.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, exit.getBoundary());
    }
}
