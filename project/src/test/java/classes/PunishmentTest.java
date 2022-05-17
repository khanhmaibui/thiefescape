package classes;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PunishmentTest {

    private Punishment punishment;

    @BeforeEach
    void setup() {
        punishment = new Punishment(40, 40);
    }

    @Test
    void createPunishment() {
        assertNotNull(punishment);
        assertEquals(40, punishment.getPositionX());
        assertEquals(40, punishment.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, punishment.getBoundary());
    }

}
