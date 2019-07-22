import java.util.ArrayList;
import java.util.List;

public class Survivor {
    private int wounds = 0;

    private String name;

    public Survivor(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public int wounds() {
        return this.wounds;
    }

    public boolean isAlive() {
        return this.wounds < 2;
    }

    public void receiveAttack() {
        if (!this.isAlive())
            return;

        this.wounds++;
    }

    public List<Piece> piecesInHand() {
        return new ArrayList<Piece>();
    }
}
