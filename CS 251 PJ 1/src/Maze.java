
/**
 * The class representing a maze.
 */
public class Maze extends Grid
{
	/**
	 * Constructor of the class.
	 */
	public Maze(String filepath) {
		super(filepath);
	}

	/**
	 * Finds a path in the maze from (i1, j1) to (i2, j2). If no path then return null.
	 * TO DO BY STUDENT
	 */
	public Pair[] findPath(int i1, int j1, int i2, int j2) throws EmptyStackException {
		Stack<Pair> currentPath = new Stack();
		//Stack<Coordinate> coordPairs = new Stack<>();
		Pair firstPair = new Pair(i1, j1);
		Pair exitPair = new Pair(i2, j2);

		currentPath.push(firstPair);
		int[][] visitedCoords = new int[nRows][nColumns];
		Pair pair = firstPair;
		visitedCoords[pair.a][pair.b] = 1;
		Pair nextPair = null;
		while (true) {
			if (pair.a == exitPair.a && pair.b == exitPair.b) {
				break;
			}

			if (grid[pair.a][pair.b] == 1) {
				//if (pair.a - 1 > nRows) {
				if (visitedCoords[pair.a - 1][pair.b] == 0) {
					pair = new Pair(pair.a - 1, pair.b);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
				//}
			}

			if (grid[pair.a][pair.b] == 2) {
				//if (pair.a + 1 < nRows)
				if (visitedCoords[pair.a + 1][pair.b] == 0) {
					pair = new Pair(pair.a + 1, pair.b);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 3) {
				if (visitedCoords[pair.a + 1][pair.b] == 0) {
					pair = new Pair(pair.a + 1, pair.b);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a - 1][pair.b] == 0) {
					pair = new Pair(pair.a - 1, pair.b);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 4) {
				if (visitedCoords[pair.a][pair.b + 1] == 0) {
					pair = new Pair(pair.a, pair.b + 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 5) {
				if (visitedCoords[pair.a - 1][pair.b] == 0) {
					pair = new Pair(pair.a - 1, pair.b );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a][pair.b + 1] == 0) {
					pair = new Pair(pair.a, pair.b + 1 );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 6) {
				if (visitedCoords[pair.a + 1][pair.b] == 0) {
					pair = new Pair(pair.a + 1, pair.b );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a][pair.b + 1] == 0) {
					pair = new Pair(pair.a, pair.b + 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 7) {
				if (visitedCoords[pair.a + 1][pair.b] == 0) {
					pair = new Pair(pair.a + 1, pair.b );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a][pair.b + 1] == 0) {
					pair = new Pair(pair.a, pair.b + 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a - 1][pair.b] == 0) {
					pair = new Pair(pair.a - 1, pair.b );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 8) {

				if (visitedCoords[pair.a][pair.b - 1] == 0) {
					pair = new Pair(pair.a, pair.b - 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

			}

			if (grid[pair.a][pair.b] == 9) {

				if (visitedCoords[pair.a][pair.b - 1] == 0) {
					pair = new Pair(pair.a, pair.b - 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a - 1][pair.b] == 0) {
					pair = new Pair(pair.a - 1, pair.b );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

			}

			if (grid[pair.a][pair.b] == 10) {

				if (visitedCoords[pair.a][pair.b - 1] == 0) {
					pair = new Pair(pair.a, pair.b - 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a + 1][pair.b] == 0) {
					pair = new Pair(pair.a + 1, pair.b );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

			}

			if (grid[pair.a][pair.b] == 11) {

				if (visitedCoords[pair.a][pair.b - 1] == 0) {
					pair = new Pair(pair.a, pair.b - 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a + 1][pair.b] == 0) {
					pair = new Pair(pair.a + 1, pair.b );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a - 1][pair.b] == 0) {
					pair = new Pair(pair.a - 1, pair.b );
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 12) {
				if (visitedCoords[pair.a][pair.b + 1] == 0) {
					pair = new Pair(pair.a, pair.b + 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a][pair.b - 1] == 0) {
					pair = new Pair(pair.a, pair.b - 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 13) {

				if (visitedCoords[pair.a][pair.b + 1] == 0) {
					pair = new Pair(pair.a, pair.b + 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a][pair.b - 1] == 0) {
					pair = new Pair(pair.a, pair.b - 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a - 1][pair.b] == 0) {
					pair = new Pair(pair.a - 1, pair.b);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 14) {

				if (visitedCoords[pair.a][pair.b + 1] == 0) {
					pair = new Pair(pair.a, pair.b + 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a][pair.b - 1] == 0) {
					pair = new Pair(pair.a, pair.b - 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a + 1][pair.b] == 0) {
					pair = new Pair(pair.a + 1, pair.b);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}
			}

			if (grid[pair.a][pair.b] == 15) {

				if (visitedCoords[pair.a][pair.b + 1] == 0) {
					pair = new Pair(pair.a, pair.b + 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a][pair.b - 1] == 0) {
					pair = new Pair(pair.a, pair.b - 1);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a + 1][pair.b] == 0) {
					pair = new Pair(pair.a + 1, pair.b);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

				if (visitedCoords[pair.a - 1][pair.b] == 0) {
					pair = new Pair(pair.a - 1, pair.b);
					currentPath.push(pair);
					visitedCoords[pair.a][pair.b] = 1;
					continue;
				}

			}

			currentPath.pop(); //All that's needed for backtracking!
			if (currentPath.isEmpty()) {
				return null;
			}
			pair = currentPath.peek();
		}

		int count = currentPath.size() - 1;
		Pair[] path = new Pair[currentPath.size()];
		while (count != -1) {
			path[count] = currentPath.pop();
			count--;
		}
		return path;
	}	


	/**
	 * Prints the contents of the maze.
	 */
	public void printMaze()
	{
		for (int i = 0; i < nRows; i += 1)
		{
			for (int j = 0; j < nColumns; j += 1)
			{
				if ((grid[i][j] & Direction.NORTH.getBit()) == 0)
				{
					System.out.print("+---");
				}
				else
				{
					System.out.print("+   ");
				}
			}

			System.out.println("+");

			for (int j = 0; j < nColumns; j += 1)
			{
				if ((grid[i][j] & Direction.WEST.getBit()) == 0)
				{
					System.out.print("|   ");
				}
				else
				{
					System.out.print("    ");
				}
			}

			System.out.println("|");
		}

		for (int j = 0; j < nColumns; j += 1)
		{
			System.out.print("+---");
		}

		System.out.println("+");
	}

	public static void main(String[] args) {
		try {

			Maze m = new Maze(args[0]);

			if (args.length < 5) {
				m.printMaze();
				return;
			}

			int i1 = Integer.parseInt(args[1]);
			int j1 = Integer.parseInt(args[2]);
			int i2 = Integer.parseInt(args[3]);
			int j2 = Integer.parseInt(args[4]);

			Pair[] path = m.findPath(i1, j1, i2, j2);
			if (path == null) {
				System.out.println("no path");
				return;
			}

			System.out.println(path.length);
			for (int i = 0; i < path.length; i++) {
				System.out.println(path[i].a + " " + path[i].b);
			}

		} catch (EmptyStackException e) {
			System.out.println("Error in Queue implementation");
		}
	}
}
