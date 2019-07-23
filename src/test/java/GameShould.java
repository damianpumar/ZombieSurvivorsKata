import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameShould {
    @Test
    public void game_begins_with_0_survivors() {
        Game game = new Game();

        assertThat(game.survivors().size()).isEqualTo(0);
    }

    @Test
    public void game_can_have_survivors() throws SurvivorDuplicatedException {
        Game game = new Game();

        game.addSurvivor(new Survivor("Damián"));

        assertThat(game.survivors().size()).isEqualTo(1);
    }

    @Test(expected = SurvivorDuplicatedException.class)
    public void game_can_have_unique_survivor_by_name() throws SurvivorDuplicatedException {
        Game game = new Game();

        game.addSurvivor(new Survivor("Damián"));

        game.addSurvivor(new Survivor("Damián"));
    }

    @Test
    public void game_ends_when_all_survivors_is_dead() throws SurvivorDuplicatedException {
        Survivor survivor = new Survivor("Damián");

        Game game = new Game();
        game.addSurvivor(survivor);
        assertThat(game.finished()).isFalse();

        survivor.receiveAttack();
        survivor.receiveAttack();

        assertThat(game.finished()).isTrue();
    }
}
