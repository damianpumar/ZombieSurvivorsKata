import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SurvivorShould {
    @Test
    public void has_a_name() {
        Survivor survivor = new Survivor("Damián");

        assertThat(survivor.name()).isEqualTo("Damián");
    }

    @Test
    public void begins_zero_wounds() {
        Survivor survivor = new Survivor("Damián");

        assertThat(survivor.wounds()).isEqualTo(0);
    }

    @Test
    public void dies_immediately_when_receives_2_wounds() {
        Survivor survivor = new Survivor("Damián");

        survivor.receiveAttack();
        survivor.receiveAttack();

        assertThat(survivor.isAlive()).isFalse();
    }

    @Test
    public void additional_wounds_are_ignored() {
        Survivor survivor = new Survivor("Damián");
        survivor.receiveAttack();
        survivor.receiveAttack();

        survivor.receiveAttack();

        assertThat(survivor.wounds()).isEqualTo(2);
    }

    @Test
    public void first_2_pieces_of_equipment_carry_in_hand() {
        Survivor survivor = new Survivor("Damián");

        survivor.addEquipment("BaseBall bat");
        survivor.addEquipment("Frying pan");

        assertThat(survivor.piecesInHand().size()).isEqualTo(2);
    }
}
