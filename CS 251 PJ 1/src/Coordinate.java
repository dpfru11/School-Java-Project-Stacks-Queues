import java.nio.file.Path;

public class Coordinate {
    public boolean visited = false;
    public Pair coordinates = null;
    public Pair parent = null;

    public Coordinate(Pair coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinate(Pair coordinates, Pair parent) {
        this.coordinates = coordinates;
        this.parent = parent;
    }

    public void setVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return this.visited;
    }
}
