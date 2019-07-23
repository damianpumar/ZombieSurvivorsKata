import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Survivor> survivors;

    public Game() {
        this.survivors = new ArrayList();
    }

    public List<Survivor> survivors() {
        return this.survivors;
    }
}
