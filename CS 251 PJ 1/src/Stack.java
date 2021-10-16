
public class Stack<Item>
{
	// The pointer to the first node of the stack
	private StackNode<Item> first;
	
	/**
	 * Constructor of the class.
	 * TO DO BY STUDENT
	 */
	public Stack() {
	}
	
	/**
	 * Indicates whether the stack is empty or not.
	 * TO DO BY STUDENT
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Peeks the item at the top of the stack.
	 * TO DO BY STUDENT
	 */
	public Item peek() throws EmptyStackException {
		if (first == null) {
			throw new EmptyStackException();
		}
		return first.item;
	}
	
	/**
	 * Pops the item at the top of the stack.
	 * TO DO BY STUDENT
	 */
	public Item pop() throws EmptyStackException {
		if (first == null) {
			throw new EmptyStackException();
		}
		Item newNode = first.item;
		first = first.next;
		return newNode;
	}
	
	/**
	 * Pushes an item into the stack.
	 * TO DO BY STUDENT
	 */
	public void push(Item item) {
		if (first != null) {
			StackNode<Item> temp = first;
			first = new StackNode<>(item);
			first.next = temp;
		} else {
			first = new StackNode<>(item);
		}

	}
	
	/**
	 * Returns the number of items in the stack.
	 * TO DO BY STUDENT
	 */
	public int size() {
		int count = 1;
		if (first == null) {
			return 0;
		}
		StackNode<Item> traverse = first;
		while (traverse.next != null) {
			count++;
			traverse = traverse.next;
		}
		return count;
	}

}
