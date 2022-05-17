package classes.barrier;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BarrierTest {

    private Barrier barrier;

    @BeforeEach
    void setup() {
        barrier = new Barrier(40, 40);
    }

    @Test
    void createBarrier() {
        assertNotNull(barrier);
        assertEquals(40, barrier.getPositionX());
        assertEquals(40, barrier.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, barrier.getBoundary());
    }

}
