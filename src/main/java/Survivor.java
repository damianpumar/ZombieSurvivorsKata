import java.util.ArrayList;
import java.util.List;

public class Survivor {
    private final int START_EXPERIENCE = 0;
    private final int START_WOUND = 0;

    private final List<Piece> piecesInHand;
    private final List<Piece> piecesInReserve;

    private int wounds;
    private String name;
    private int experience;

    public Survivor(String name) {
        this.name = name;
        this.experience = START_EXPERIENCE;
        this.wounds = START_WOUND;

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

        this.piecesInReserve().clear();

        if (this.piecesInHand.size() > 0) {
            Piece piece = this.piecesInHand.get(0);

            this.piecesInHand.remove(piece);
        }
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

    public int experience() {
        return this.experience;
    }

    public LEVEL level() {
        throw new UnsupportedOperationException();
    }
}
