

public class Queue<Item>
{
	Item[] array;
	static int initSize = 0;
	int front = 0;
	int back =  0;
	
	/**
	 * Constructor of the class.
	 * TO DO BY STUDENT
	 */
	public Queue() {
		array = (Item[]) new Object[1];
		initSize = 1;
		front = 0;
		back = 1;
	}
	
	/**
	 * Constructor of the class with initial capacity.
	 * TO DO BY STUDENT
	 */
	public Queue(int n) {
		array = (Item[]) new Object[n];
		initSize = n;
		front = 0;
		back = 1;
	}
	
	/**
	 * Dequeue the next item.
	 * TO DO BY STUDENT
	 */
	public Item dequeue() throws EmptyQueueException {
		Item item;
		Item[] newItemArr = (Item[]) new Object[array.length];
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		}

		if (front == array.length) {
			front = 0;
		}
		item = array[front];
		array[front] = null;
		front++;

		if (back == array.length) {
			back = 0;
		}

		if ((array.length * 0.25 == this.size()) /*&& (this.size() >
				initSize)*/ && ((array.length / 2) > initSize)) {
			newItemArr = (Item[]) new Object[array.length / 2];
			int count = front;
			int newFront = 0;
			while (true) {
				if (newFront == this.size()) {
					break;
				}
				if (count == array.length) {
					count = 0;
				}

				newItemArr[newFront] = array[count];
				count++;
				newFront++;
			}
			front = 0;
			back = newFront;
			array = newItemArr;
		}
		return item;
	}
	
	/**
	 * Enqueues an item.
	 * TO DO BY STUDENT
	 */
	public void enqueue(Item item) {
		Item[] newItemArr;

		if (back == array.length && array.length != 1 && front != 0) {
			back = 0;
		}

		if (array.length == back) {
			back = 0;
		}
		array[back] = item;
		back++;

		if (array.length == this.size()) {
			newItemArr = (Item[]) new Object[array.length * 2];
			int count = front;
			int newStart = 0;
			while (newStart < this.size()) {
				if (count == array.length) {
					count = 0;
				}
				newItemArr[newStart] = array[count];
				newStart++;
				count++;
			}
			front = 0;
			array = newItemArr;
			back = this.size();
		}

	}
	
	/**
	 * Returns the array with the content of the queue.
	 * DO NOT DELETE OR MODIFY. REQUIRED FOR TESTING AND GRADING. ANY MODIFICATION OF THIS FUNCTION
	 * WILL BE CONSIDERED ACADEMIC DISHONESTY AND PENALIZED WITH 0 FOR THE ENTIRE PROJECT.
	 */
	public Item[] getArray() 
	{
		return array;
	}
	
	/**
	 * Indicates whether the queue is empty or not.
	 * TO DO BY STUDENT
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	/**
	 * Peeks the next item to be dequeued.
	 * TO DO BY STUDENT
	 */
	public Item peek() throws EmptyQueueException {
		if (this.size() == 0) {
			throw new EmptyQueueException();
		}
		return array[front];
	}
	
	/**
	 * Returns the size of the queue.
	 * TO DO BY STUDENT
	 */
	public int size() {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				count++;
			}
		}
		return count;
	}

}
