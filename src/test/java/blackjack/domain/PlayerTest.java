package blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    void 플레이어_생성() {
        Name pobi = new Name("pobi");
        Stake stakes = new Stake(1);
        Player player = new Player(pobi, stakes);

        assertThat(player).isEqualTo(new Player(pobi, stakes));
    }
}
