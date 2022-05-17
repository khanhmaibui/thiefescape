package classes;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class BonusTest {

    private Bonus bonus;

    @BeforeEach
    void setup() {
        bonus = new Bonus(40, 40);
    }

    @Test
    void createBonus() {
        assertNotNull(bonus);
        assertEquals(40, bonus.getPositionX());
        assertEquals(40, bonus.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, bonus.getBoundary());
    }
}
