import java.util.ArrayList;
import java.util.List;

public class Survivor {
    private int wounds = 0;

    private String name;
    private final List<Piece> piecesInHand;
    private final List<Piece> piecesInReserve;

    public Survivor(String name) {
        this.name = name;

        this.piecesInHand = new ArrayList();
        this.piecesInReserve = new ArrayList();
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
        return this.piecesInHand;
    }

    public List<Piece> piecesInReserve() {
        return this.piecesInReserve;
    }

    public void addEquipment(String pieceOfEquipment) {
        if (this.piecesInHand.size() < 2)
            this.piecesInHand.add(new Piece(pieceOfEquipment));
        else if (this.piecesInReserve.size() < 3)
            this.piecesInReserve().add(new Piece(pieceOfEquipment));
    }
}
