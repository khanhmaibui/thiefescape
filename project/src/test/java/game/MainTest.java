package game;

import classes.*;
import classes.barrier.Barrier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainTest {

    private ArrayList<Enemy> enemies;
    private ArrayList<Punishment> punishments;
    private ArrayList<Reward> rewards;
    private ArrayList<Barrier> barriers;
    private ArrayList<Bonus> bonuses;

    //set up some sample objects with their positions similar to Main
    @BeforeEach
    void setup() {
        enemies = new ArrayList<>();
        Enemy enemy = new Enemy(80, 200);
        enemies.add(enemy);

        punishments = new ArrayList<>();
        Punishment punishment = new Punishment(560, 80);
        punishments.add(punishment);

        rewards = new ArrayList<>();
        Reward reward = new Reward(320, 240);
        rewards.add(reward);

        barriers = new ArrayList<>();
        Barrier barrier = new Barrier(280, 40);
        barriers.add(barrier);

        bonuses = new ArrayList<>();
        Bonus bonus = new Bonus(560, 120);
        bonuses.add(bonus);

    }

    @Test
    void createLists() {
        assertNotNull(enemies);
        assertNotNull(punishments);
        assertNotNull(rewards);
        assertNotNull(barriers);
        assertNotNull(bonuses);
    }

    //check position of each object in each array list
    @Test
    void checkPosition() {
        assertEquals(80, enemies.get(0).getPositionX());
        assertEquals(200, enemies.get(0).getPositionY());

        assertEquals(560, punishments.get(0).getPositionX());
        assertEquals(80, punishments.get(0).getPositionY());

        assertEquals(320, rewards.get(0).getPositionX());
        assertEquals(240, rewards.get(0).getPositionY());

        assertEquals(280, barriers.get(0).getPositionX());
        assertEquals(40, barriers.get(0).getPositionY());

        assertEquals(560, bonuses.get(0).getPositionX());
        assertEquals(120, bonuses.get(0).getPositionY());
    }
}
