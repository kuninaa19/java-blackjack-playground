package blackjack.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Name pobi;
    private Stake stake;
    private Player player;

    @BeforeEach
    void setUp() {
        pobi = new Name("pobi");
        stake = new Stake(1);
        player = new Player(pobi, stake, new Cards());
    }

    @Test
    void 플레이어_생성() {
        assertThat(player).isEqualTo(new Player(pobi, stake, new Cards()));
    }

    @Test
    void 카드_조회() {
        assertThat(player.getCards()).isEqualTo(new Cards());
    }

    @Test
    void 이름_조회() {
        assertThat(player.getName()).isEqualTo(new Name("pobi"));
    }
}
