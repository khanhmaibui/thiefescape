package classes.barrier;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Building1Test {

    private Building1 building;

    @BeforeEach
    void setup() {
        building = new Building1(40, 40);
    }

    @Test
    void createBuilding() {
        assertNotNull(building);
        assertEquals(40, building.getPositionX());
        assertEquals(40, building.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, building.getBoundary());
    }

}
