import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Game
 */
public class GameTest {
    BoundedQueue<Action> queue1 = new BoundedQueue<Action>(3, false);

    @Test
    public void gameTest1() {
        Game game = new Game();
        BoundedQueue<Action> queue1 = new BoundedQueue<Action>(3, false);
        game.generateMovements(queue1);
        assertEquals(2, queue1.count(), "there should be 2 items in queue1");
        game.process(queue1);
        assertEquals(0,queue1.count(), "there should be 0 item in queue1");
    }

    @Test
    public void gameTest2() {
        Game game = new Game();
        BoundedQueue<MoveAction> queue1 = new BoundedQueue<MoveAction>(3, false);
        game.generateMovements(queue1);
        assertEquals(2, queue1.count(), "there should be 2 items in queue1");
        game.process(queue1);
        assertEquals(0,queue1.count(), "there should be 0 item in queue1");
    }

    @Test
    public void gameTest3() {
        Game game = new Game();
        queue1 = new BoundedQueue<MoveAction>(3, false);
        game.generateMovements(queue1);
        assertEquals(2, queue1.count(), "there should be 2 items in queue1");
        game.process(queue1);
        assertEquals(0,queue1.count(), "there should be 0 item in queue1");
    }
}