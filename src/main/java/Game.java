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

    public void addSurvivor(Survivor survivor) throws SurvivorDuplicatedException {
        if (this.survivorExists(survivor))
            throw new SurvivorDuplicatedException();

        this.survivors.add(survivor);
    }

    private boolean survivorExists(Survivor survivor) {
        return this.survivors.stream().anyMatch(s -> s.name().equals(survivor.name()));
    }

    public boolean finished() {
        return this.survivors.stream().allMatch(s -> !s.isAlive());
    }
}
