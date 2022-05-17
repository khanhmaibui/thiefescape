package classes;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameComponentTest {

    private GameComponent gameComponent;

    @BeforeEach
    void setup() {
        gameComponent = new GameComponent(40, 40);
    }

    @Test
    void createGC() {
        assertNotNull(gameComponent);
        assertEquals(40, gameComponent.getPositionX());
        assertEquals(40, gameComponent.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, gameComponent.getBoundary());
    }
}
