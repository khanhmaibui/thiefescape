package classes;

import javafx.geometry.Rectangle2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RewardTest {

    private Reward reward;

    @BeforeEach
    void setup() {
        reward = new Reward(40, 40);
    }

    @Test
    void createReward() {
        assertNotNull(reward);
        assertEquals(40, reward.getPositionX());
        assertEquals(40, reward.getPositionY());
    }

    @Test
    void checkBounds() {
        Rectangle2D newRec = new Rectangle2D(40, 40, 40, 40);
        assertEquals(newRec, reward.getBoundary());
    }
}
