package classes.barrier;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TreeTest {

    private Tree tree;

    @BeforeEach
    void setup() {
        tree = new Tree(40, 40);
    }

    @Test
    void createTree() {
        assertNotNull(tree);
        assertEquals(40, tree.getPositionX());
        assertEquals(40, tree.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, tree.getBoundary());
    }

}
