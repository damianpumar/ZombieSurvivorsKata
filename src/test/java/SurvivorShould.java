import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SurvivorShould {
    private Survivor survivor;

    @Before
    public void setup() {
        this.survivor = new Survivor("Damián");
    }

    @Test
    public void has_a_name() {
        assertThat(survivor.name()).isEqualTo("Damián");
    }

    @Test
    public void begins_zero_wounds() {
        assertThat(survivor.wounds()).isEqualTo(0);
    }

    @Test
    public void dies_immediately_when_receives_2_wounds() {
        survivor.receiveAttack();
        survivor.receiveAttack();

        assertThat(survivor.isAlive()).isFalse();
    }

    @Test
    public void additional_wounds_are_ignored() {
        survivor.receiveAttack();
        survivor.receiveAttack();

        survivor.receiveAttack();

        assertThat(survivor.wounds()).isEqualTo(2);
    }

    @Test
    public void first_2_pieces_of_equipment_carry_in_hand() {
        survivor.addEquipment("BaseBall bat");
        survivor.addEquipment("Frying pan");

        assertThat(survivor.piecesInHand().size()).isEqualTo(2);
    }

    @Test
    public void after_2_pieces_of_equipment_carry_in_reserve() {
        survivor.addEquipment("BaseBall bat");
        survivor.addEquipment("Frying pan");

        survivor.addEquipment("Katana");
        survivor.addEquipment("Pistol");
        survivor.addEquipment("Molotov");

        assertThat(survivor.piecesInReserve().size()).isEqualTo(3);
    }

    @Test
    public void has_maximum_5_pieces_of_equipment() {
        survivor.addEquipment("BaseBall bat");
        survivor.addEquipment("Frying pan");
        survivor.addEquipment("Katana");
        survivor.addEquipment("Pistol");
        survivor.addEquipment("Molotov");

        survivor.addEquipment("Bottled Water");

        assertThat(survivor.piecesInHand().size()).isEqualTo(2);
        assertThat(survivor.piecesInReserve().size()).isEqualTo(3);
    }

    @Test
    public void reduces_pieces_of_equipment_carry_by_1_each_wound() {
        survivor.addEquipment("BaseBall bat");
        survivor.addEquipment("Frying pan");
        survivor.addEquipment("Katana");
        survivor.addEquipment("Pistol");
        survivor.addEquipment("Molotov");

        survivor.receiveAttack();

        assertThat(survivor.piecesInHand().size()).isEqualTo(1);
        assertThat(survivor.piecesInReserve().size()).isEqualTo(0);
    }

    @Test
    public void each_survivor_begins_with_0_experience() {
        assertThat(survivor.experience()).isEqualTo(0);
    }

    @Test
    public void each_survivor_begins_at_level_blue() {
        assertThat(survivor.level()).isEqualTo(LEVEL.blue);
    }
}
