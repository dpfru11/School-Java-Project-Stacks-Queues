/**
 * The class representing a map.
 */
public class BeachLine extends Grid
{
	/**
	 * Constructor of the class.
	 */
	public BeachLine(String filepath) 
	{
		super(filepath);
	}
	
	
	/**
	 * Finds the beach line by starting the search at (i, j).
	 * TO DO BY STUDENT
	 */
	public Pair[] findBeachLine(int i, int j) throws EmptyQueueException
	{
		Queue<Pair> beachlineFind = new Queue<>();
		Queue<Pair> beachlineTrace = new Queue<>();
		Pair pair = new Pair(i, j);

		int[][] visited = new int[nRows][nColumns];
		int iteration = 0;

		beachlineFind.enqueue(pair);
		visited[i][j] = 1;

		//Find first water grid if the input is on land
		if (grid[i][j] == 1) {
			while (true) {
				if (grid[pair.a][pair.b] == 0) {
					beachlineTrace.enqueue(pair);
					break;
				}
				if (pair.a - 1 >= 0) {
					if (visited[pair.a - 1][pair.b] == 0) {
						beachlineFind.enqueue(new Pair(pair.a - 1, pair.b));
						visited[pair.a - 1][pair.b] = 1;
					}
				}
				if (pair.b + 1 < nColumns) {
					if (visited[pair.a][pair.b + 1] == 0) {
						beachlineFind.enqueue(new Pair(pair.a, pair.b + 1));
						visited[pair.a][pair.b + 1] = 1;
					}
				}
				if (pair.a + 1 < nRows) {
					if (visited[pair.a + 1][pair.b] == 0) {
						beachlineFind.enqueue(new Pair(pair.a + 1, pair.b));
						visited[pair.a + 1][pair.b] = 1;
					}
				}
				if (pair.b - 1 >= 0) {
					if (visited[pair.a][pair.b - 1] == 0) {
						beachlineFind.enqueue(new Pair(pair.a, pair.b - 1));
						visited[pair.a][pair.b - 1] = 1;
					}
				}
				pair = beachlineFind.dequeue();
			}
		} else {
			while (true) {
				//Find first land value from water
				if (grid[pair.a][pair.b] == 1) {
					break;
				}
				if (pair.a - 1 >= 0) {
					if (visited[pair.a - 1][pair.b] == 0) {
						beachlineFind.enqueue(new Pair(pair.a - 1, pair.b));
						visited[pair.a - 1][pair.b] = 1;
					}
				}
				if (pair.b + 1 < nColumns) {
					if (visited[pair.a][pair.b + 1] == 0) {
						beachlineFind.enqueue(new Pair(pair.a, pair.b + 1));
						visited[pair.a][pair.b + 1] = 1;
					}
				}
				if (pair.a + 1 < nRows) {
					if (visited[pair.a + 1][pair.b] == 0) {
						beachlineFind.enqueue(new Pair(pair.a + 1, pair.b));
						visited[pair.a + 1][pair.b] = 1;
					}
				}
				if (pair.b - 1 >= 0) {
					if (visited[pair.a][pair.b - 1] == 0) {
						beachlineFind.enqueue(new Pair(pair.a, pair.b - 1));
						visited[pair.a][pair.b - 1] = 1;
					}
				}
				pair = beachlineFind.dequeue();
			}
		}

			visited[pair.a][pair.b] = 1;
			//Find water cell to start tracing from if initial position wasn't land
			visited = new int[nRows][nColumns];
			while (true) {
				if (grid[i][j] != 1) {
					if (grid[pair.a - 1][pair.b] == 0) {
						pair = new Pair(pair.a - 1, pair.b);
						beachlineTrace.enqueue(pair);
						visited[pair.a - 1][pair.b] = 1;
						break;
					}
					if (grid[pair.a][pair.b + 1] == 0 && visited[pair.a][pair.b + 1] == 0) {
						pair = new Pair(pair.a, pair.b + 1);
						beachlineTrace.enqueue(pair);
						visited[pair.a][pair.b + 1] = 1;
						break;
					}
					if (grid[pair.a + 1][pair.b] == 0 && visited[pair.a + 1][pair.b] == 0) {
						pair = new Pair(pair.a + 1, pair.b);
						beachlineTrace.enqueue(pair);
						visited[pair.a + 1][pair.b] = 1;
						break;
					}
					if (grid[pair.a][pair.b - 1] == 0 && visited[pair.a][pair.b - 1] == 0) {
						pair = new Pair(pair.a, pair.b - 1);
						beachlineTrace.enqueue(pair);
						visited[pair.a][pair.b - 1] = 1;
						break;
					}
				} else {
					break;
				}
			}

			//Tracing
			visited = new int[nRows][nColumns];
			Pair initialPair = pair;
			visited[pair.a][pair.b] = 1;
			while (true) {
				iteration++;
				if (pair.a - 1 >= 0) {
					if (grid[pair.a - 1][pair.b] == 1 && grid[pair.a][pair.b - 1] == 0) {
						visited[pair.a - 1][pair.b] = 1;
						pair = new Pair(pair.a, pair.b - 1);
						if (pair.equals(initialPair)) {
							break;
						}
						beachlineTrace.enqueue(pair);
						continue;
					}
				}
				if (pair.a + 1 < nRows) {
					if (grid[pair.a + 1][pair.b] == 1 && grid[pair.a][pair.b + 1] == 0) {
						visited[pair.a + 1][pair.b] = 1;
						pair = new Pair(pair.a, pair.b + 1);
						if (pair.equals(initialPair)) {
							break;
						}
						beachlineTrace.enqueue(pair);
						continue;
					}
				}
				if (pair.b + 1 < nColumns) {
					if (grid[pair.a][pair.b + 1] == 1 && grid[pair.a - 1][pair.b] == 0) {
						visited[pair.a][pair.b + 1] = 1;
						pair = new Pair(pair.a - 1, pair.b);
						if (pair.equals(initialPair)) {
							break;
						}
						beachlineTrace.enqueue(pair);
						continue;
					}
				}
				if (pair.b - 1 >= 0) {
					if (grid[pair.a][pair.b - 1] == 1 && grid[pair.a + 1][pair.b] == 0) {
						visited[pair.a][pair.b - 1] = 1;
						pair = new Pair(pair.a + 1, pair.b);
						if (pair.equals(initialPair)) {
							break;
						}
						beachlineTrace.enqueue(pair);
						continue;
					}
				}
				if (pair.a - 1 >= 0 && pair.b + 1 < nColumns) {
					if (grid[pair.a - 1][pair.b + 1] == 1 && grid[pair.a - 1][pair.b] == 0) {
						visited[pair.a - 1][pair.b + 1] = 1;
						pair = new Pair(pair.a - 1, pair.b);
						if (pair.equals(initialPair)) {
							break;
						}
						beachlineTrace.enqueue(pair);
						continue;
					}
				}
				if (pair.a + 1 < nRows && pair.b + 1 < nColumns) {
					if (grid[pair.a + 1][pair.b + 1] == 1 && grid[pair.a][pair.b + 1] == 0) {
						visited[pair.a + 1][pair.b + 1] = 1;
						pair = new Pair(pair.a, pair.b + 1);
						if (pair.equals(initialPair)) {
							break;
						}
						beachlineTrace.enqueue(pair);
						continue;
					}
				}
				if (pair.a + 1 < nRows && pair.b - 1 >= 0) {
					if (grid[pair.a + 1][pair.b - 1] == 1 && grid[pair.a + 1][pair.b] == 0) {
						visited[pair.a + 1][pair.b - 1] = 1;
						pair = new Pair(pair.a + 1, pair.b );
						if (pair.equals(initialPair)) {
							break;
						}
						beachlineTrace.enqueue(pair);
						continue;
					}
				}
				if (pair.a - 1 >= 0 && pair.b - 1 >= 0) {
					if (grid[pair.a - 1][pair.b - 1] == 1 && grid[pair.a][pair.b - 1] == 0) {
						visited[pair.a - 1][pair.b - 1] = 1;
						pair = new Pair(pair.a, pair.b - 1);
						if (pair.equals(initialPair)) {
							break;
						}
						beachlineTrace.enqueue(pair);
						continue;
					}
				}
			}
			Pair[] finalResult = new Pair[beachlineTrace.size()];
			int count = 0;
			while (!beachlineTrace.isEmpty()) {
				finalResult[count] = beachlineTrace.dequeue();
				count++;
			}
			return finalResult;

		}

	
	/**
	 * Prints the content of the map.
	 */
	public void printMap() {
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++) {
				if (grid[i][j] == 0)
					System.out.print("\u2591 ");
				else
					System.out.print("\u2593 ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		try {

			BeachLine B = new BeachLine(args[0]);

			if (args.length < 3) {
				B.printMap();
				return;
			}

			int a = Integer.parseInt(args[1]);
			int b = Integer.parseInt(args[2]);
			Pair[] line = B.findBeachLine(a, b);
			System.out.println(line.length);
			for (int i = 0; i < line.length; i++) {
				System.out.println(line[i].a + " " + line[i].b);
			}

		} catch (EmptyQueueException e) {
			System.out.println("Error in Queue implementation");
		}
	}
}
