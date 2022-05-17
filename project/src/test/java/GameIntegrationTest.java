import classes.*;
import game.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameIntegrationTest {

    private Player player;
    private Enemy enemy;
    private Reward reward;
    private Bonus bonus;
    private Punishment bomb;
    private Exit exit;

    @BeforeEach
    void setup() {
        player = new Player(0,0);
        enemy = new Enemy(0, 0);
        reward = new Reward(0, 0);
        bonus = new Bonus(0,0);
        bomb = new Punishment(0, 0);
        exit = new Exit(0, 0);
        Main.isRunning = 0;
    }

    @Test
    void checkPlayerEnemyCollision1() {
        player.setPositionX(56);
        player.setPositionY(56);
        enemy.setPositionX(56);
        enemy.setPositionY(56);

        Main.enemies.add(enemy);

        player.update();
        assertEquals(1, Main.isRunning);
        Main.enemies.clear();
    }

    @Test
    void checkPlayerEnemyCollision2() {
        player.setPositionX(49);
        player.setPositionY(49);

        //since player bounds are set to 35
        //expect game to continue
        enemy.setPositionX(84);
        enemy.setPositionY(84);

        Main.enemies.add(enemy);

        player.update();
        assertEquals(0, Main.isRunning);
        assertEquals(84, enemy.getPositionX());
        assertEquals(84, enemy.getPositionY());
        Main.enemies.clear();
    }

    @Test
    void checkPlayerRewardCollision1() {
        player.setPositionX(23);
        player.setPositionY(23);

        //expect to get reward
        reward.setPositionX(23);
        reward.setPositionY(23);

        Main.rewards.add(reward);

        player.update();
        assertEquals(0, Main.isRunning);
        assertEquals(10, player.getCurrentCash());
        Main.rewards.clear();
    }

    @Test
    void checkPlayerRewardCollision2() {
        player.setPositionX(40);
        player.setPositionY(40);

        //expect to not get reward, cash is 0
        reward.setPositionX(90);
        reward.setPositionY(90);

        Main.rewards.add(reward);

        player.update();
        assertEquals(0, Main.isRunning);
        assertEquals(0, player.getCurrentCash());
        assertEquals(90, Main.rewards.get(0).getPositionX());
        assertEquals(90, Main.rewards.get(0).getPositionY());
        Main.rewards.clear();
    }

    @Test
    void checkPlayerBonusCollision1() {
        player.setPositionX(23);
        player.setPositionY(23);

        //expect to get bonus
        bonus.setPositionX(23);
        bonus.setPositionY(23);

        Main.bonuses.add(bonus);

        player.update();
        assertTrue(Main.checkBonus);
        assertEquals(0, Main.isRunning);
        assertEquals(20, player.getCurrentCash());
        Main.bonuses.clear();
    }

    @Test
    void checkPlayerBonusCollision2() {
        player.setPositionX(50);
        player.setPositionY(50);

        //expect to not get bonus, cash is 0
        bonus.setPositionX(10);
        bonus.setPositionY(10);

        Main.getBonus().add(bonus);

        player.update();
        assertEquals(0, Main.isRunning);
        assertEquals(0, player.getCurrentCash());
        assertEquals(10, Main.bonuses.get(0).getPositionX());
        assertEquals(10, Main.bonuses.get(0).getPositionY());
        Main.getBonus().clear();
    }

    @Test
    void checkPlayerBonusCollision3() {
        player.setPositionX(10);
        player.setPositionY(10);

        //expect to not get bonus, cash is 0
        bonus.setPositionX(10);
        bonus.setPositionY(10);

        Main.getBonus().add(bonus);

        Main.checkBonus = false;

        player.update();
        assertEquals(0, Main.isRunning);
        assertEquals(0, player.getCurrentCash());
        assertEquals(10, Main.bonuses.get(0).getPositionX());
        assertEquals(10, Main.bonuses.get(0).getPositionY());
        Main.getBonus().clear();
    }

    @Test
    void checkPlayerBombCollision1() {
        player.setPositionX(50);
        player.setPositionY(50);

        //expect to get bomb, cash is -20, game is lost
        bomb.setPositionX(50);
        bomb.setPositionY(50);

        Main.getPunishment().add(bomb);

        player.update();
        assertEquals(1, Main.isRunning);
        assertEquals(-20, player.getCurrentCash());
        Main.getPunishment().clear();
    }

    @Test
    void checkPlayerBombCollision2() {
        player.setPositionX(50);
        player.setPositionY(50);

        //expect to get reward
        reward.setPositionX(50);
        reward.setPositionY(50);

        Main.getReward().add(reward);

        //cash is 10
        player.update();

        player.setPositionX(60);
        player.setPositionY(60);

        //expect to get reward
        reward.setPositionX(60);
        reward.setPositionY(60);

        Main.getReward().add(reward);

        //cash is 20
        player.update();

        //expect to get bomb, cash is reduced to 0, game is still running
        bomb.setPositionX(50);
        bomb.setPositionY(51);

        Main.getPunishment().add(bomb);

        player.update();
        assertEquals(0, Main.isRunning);
        assertEquals(0, player.getCurrentCash());
        Main.getPunishment().clear();
        Main.getReward().clear();
    }

    @Test
    void checkPlayerBombCollision3() {
        player.setPositionX(50);
        player.setPositionY(50);

        //expect to get reward
        reward.setPositionX(50);
        reward.setPositionY(50);

        Main.getReward().add(reward);

        //cash is 10
        player.update();

        //expect to not get bomb, cash is still 10, game is still running
        bomb.setPositionX(100);
        bomb.setPositionY(90);

        Main.getPunishment().add(bomb);

        player.update();
        assertEquals(0, Main.isRunning);
        assertEquals(10, player.getCurrentCash());
        assertEquals(100, Main.bombs.get(0).getPositionX());
        assertEquals(90, Main.bombs.get(0).getPositionY());
        Main.getPunishment().clear();
        Main.getReward().clear();
    }

    @Test
    void checkWin1() {
        player.setPositionX(90);
        player.setPositionY(33);
        reward.setPositionX(90);
        reward.setPositionY(33);

        Main.getPlayer().add(player);
        Main.getReward().add(reward);

        //rewards size is reduced to 0
        player.update();

        //player and exit positions are the same
        //expect to win game
        exit.setPositionX(90);
        exit.setPositionY(33);
        Main.getExit().add(exit);

        player.update();
        exit.update();
        assertEquals(2, Main.isRunning);
        Main.getPlayer().clear();
        Main.getReward().clear();
        Main.getExit().clear();
    }

    @Test
    void checkWin2() {
        player.setPositionX(90);
        player.setPositionY(33);
        reward.setPositionX(100);
        reward.setPositionY(80);

        Main.getPlayer().add(player);
        Main.getReward().add(reward);

        //rewards size is 1
        //since player and reward are not in the same position
        player.update();

        //player and exit positions are the same
        //expect to game to continue running since all rewards haven't got collected
        exit.setPositionX(90);
        exit.setPositionY(33);
        Main.getExit().add(exit);

        player.update();
        exit.update();
        assertEquals(0, Main.isRunning);
        Main.getPlayer().clear();
        Main.getReward().clear();
        Main.getExit().clear();
    }

    @Test
    void checkWin3() {
        player.setPositionX(90);
        player.setPositionY(33);
        reward.setPositionX(90);
        reward.setPositionY(33);

        Main.getPlayer().add(player);
        Main.getReward().add(reward);

        //rewards size is reduced to 0
        player.update();

        //player and exit positions are not the same
        //expect to yet not win
        //game is expected to continue to be in running state
        exit.setPositionX(40);
        exit.setPositionY(23);
        Main.getExit().add(exit);

        player.update();
        exit.update();
        assertEquals(0, Main.isRunning);
        Main.getPlayer().clear();
        Main.getReward().clear();
        Main.getExit().clear();
    }

}

