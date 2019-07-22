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
}
