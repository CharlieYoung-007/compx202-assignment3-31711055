/**
 * Fixed-capacity collection that supports adding to one end and
 * removing from the other.
 */
public class BoundedQueue<T> {

    private int capacity;
    private boolean dropOldest;
    private int countN = 0;
    private T[] array;
    static int BQNum = 0;
    static int droppedNum = 0;

    /**
     * Constructs an empty BoundedQueue with the given capacity.
     * <p>
     * The parameter dropOldest specifies what will happen when put()
     * is called and the queue is full. If dropOldest is true, the
     * oldest item (which would be returned by get()) is dropped. If
     * dropOldest is false, the new item is dropped.
     */
    public BoundedQueue(int capacity, boolean dropOldest) {
        this.capacity = capacity;
        this.dropOldest = dropOldest;
        makeArray(capacity);
        BQNum++;
    }

    /**
     * Returns the number of items in the queue.
     */
    public int count() {
        for (int i = 0; i < capacity; i++) {
            if (array[i] != null) {
                countN++;
            }
        }
        return countN;
    }

    /**
     * Returns true if the queue does not contain any items.
     */
    public boolean empty() {
        for (int i = 0; i < capacity; i++) {
            if (array[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the queue has reached its capacity.
     */
    public boolean full() {
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds the item to the queue.
     * <p>
     * If the queue is full, an item is dropped as described in the
     * constructor.
     */
    public void put(T item) {
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null) {
                array[i] = item;
                break;
            }
            if (full()) {
                if (this.dropOldest) {
                    get();
                } else {
                    countN = 0;
                    array[capacity-1] =item;
                }

            }
        }
    }

    /**
     * Retrieves and removes the oldest item in the queue.
     * <p>
     * If the queue is empty, returns null.
     */
    public T get() {
        if (array[0] == null) {
            return null;
        } else {
            T num = array[0];
            droppedNum++;
            countN = 0;
            for (int i = 0; i < capacity - 1; i++) {
                array[i] = array[i + 1];
            }
            array[capacity - 1] = null;
            return num;
        }
    }

    /**
     * Helper for creating an array with T as the element type. The
     * elements are initialized to null.
     */
    private T[] makeArray(int size) {
        // We would normally use "new T[size]", but we can't because T
        // is a type parameter and Java does not support generic array
        // creation. The following is an imperfect workaround.
        array = (T[]) new Object[size];
        return array;
    }

    static void reportStats() {
        System.out.println("number of BoundedQueue instances: " + BQNum);
        System.out.println("number of dropped items: " + droppedNum);
    }
}
