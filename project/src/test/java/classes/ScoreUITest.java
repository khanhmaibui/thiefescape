package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScoreUITest {

    private ScoreUI scoreUI;

    @BeforeEach
    void setup() {
        scoreUI = new ScoreUI(50);
    }

    @Test
    void createScoreUI() {
        assertNotNull(scoreUI);
        assertEquals(50, scoreUI.getCash());
    }

    @Test
    void add() {
        scoreUI.addBy(10);
        assertEquals(60, scoreUI.getCash());
    }

    @Test
    void subtract() {
        scoreUI.subtractBy(60);
        assertEquals(-10, scoreUI.getCash());
    }

}
