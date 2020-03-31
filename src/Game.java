/**
 * This file contains the Game class and Action classes
 */

/**
 * Represents the state of the game and the player.
 */
public class Game {
    private int x;
    private int y;
    private int score;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void process(BoundedQueue<? extends Action> action) {
        while (!action.empty()) { // action is not empty
            action.get().actOn(this); // Take out each action from 'action' queue and Act on each action on game object by call 'actOn' function
        }// End of while-loop

    }

    public void generateMovements(BoundedQueue<? super MoveAction> move) {
        MoveAction move1 = new MoveAction(5,10);
        MoveAction move2 = new MoveAction(-5, 5);
        move.put(move1);
        move.put(move2);
    }
}

abstract class Action {
    public abstract void actOn(Game game);
}




class ScoreAction extends Action {
    private int scoreChange;

    public ScoreAction(int scoreChange) {
        this.scoreChange = scoreChange;
    }

    public void actOn(Game game) {
        int newScore = game.getScore() + scoreChange;
        game.setScore(newScore);
    }
}

class MoveAction extends Action {
    private int x;
    private int y;

    public MoveAction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void actOn(Game game) {
        int newMoveX = game.getX() + x;
        int newMoveY = game.getY() + y;
        game.setX(newMoveX);
        game.setY(newMoveY);
    }
}


