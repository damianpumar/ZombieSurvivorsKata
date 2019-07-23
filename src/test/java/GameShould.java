import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameShould {
    private Game game;

    @Before
    public void setup() {
        this.game = new Game();
    }

    @Test
    public void game_begins_with_0_survivors() {
        assertThat(game.survivors().size()).isEqualTo(0);
    }

    @Test
    public void game_can_have_survivors() throws SurvivorDuplicatedException {
        game.addSurvivor(new Survivor("Damián"));

        assertThat(game.survivors().size()).isEqualTo(1);
    }

    @Test(expected = SurvivorDuplicatedException.class)
    public void game_can_have_unique_survivor_by_name() throws SurvivorDuplicatedException {
        game.addSurvivor(new Survivor("Damián"));

        game.addSurvivor(new Survivor("Damián"));
    }

    @Test
    public void game_ends_when_all_survivors_is_dead() throws SurvivorDuplicatedException {
        Survivor survivor = new Survivor("Damián");
        game.addSurvivor(survivor);
        assertThat(game.finished()).isFalse();

        survivor.receiveAttack();
        survivor.receiveAttack();

        assertThat(game.finished()).isTrue();
    }

    @Test
    public void game_has_level_maximum_survivor_level() throws SurvivorDuplicatedException {
        Survivor survivor1 = new Survivor("Damián");
        Survivor survivor2 = new Survivor("Lucas");

        game.addSurvivor(survivor1);
        game.addSurvivor(survivor2);

        survivor1.killZombie();
        survivor1.killZombie();
        survivor1.killZombie();
        survivor1.killZombie();
        survivor1.killZombie();
        survivor1.killZombie();

        assertThat(game.level()).isEqualTo(LEVEL.yellow);
    }

    @Test
    public void game_begin_a_level_blue() {
        assertThat(game.level()).isEqualTo(LEVEL.blue);
    }
}
