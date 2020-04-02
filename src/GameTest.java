import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Game
 */
public class GameTest {
    BoundedQueue<Action> queue1 = new BoundedQueue<Action>(3, false);
    BoundedQueue<MoveAction> queue2 = new BoundedQueue<MoveAction>(3, false);
    Game game = new Game();

    @Test
    public void gameGetX() {
        assertEquals(0, game.getX(), "the X should be 0");
    }

    @Test
    public void gameSetX() {
        game.setX(5);
        assertEquals(5, game.getX(), "the X should be 5");
    }

    @Test
    public void gameGetY() {
        assertEquals(0, game.getY(), "the Y should be 0");
    }

    @Test
    public void gameSetY() {
        game.setY(5);
        assertEquals(5, game.getY(), "the Y should be 5");
    }

    @Test
    public void gameGetScore() {
        assertEquals(0, game.getScore(), "the Score should be 0");
    }

    @Test
    public void gameSetScore() {
        game.setScore(5);
        assertEquals(5, game.getScore(), "the Score should be 5");
    }


    @Test
    public void gameTest1() {
        game.generateMovements(queue1);
        assertEquals(2, queue1.count(), "there should be 2 items in queue1");
        game.process(queue1);
        assertEquals(0, queue1.count(), "there should be 0 item in queue1");
    }

    @Test
    public void gameTest2() {
        game.generateMovements(queue2);
        assertEquals(2, queue2.count(), "there should be 2 items in queue1");
        game.process(queue2);
        assertEquals(0, queue2.count(), "there should be 0 item in queue1");
    }


}