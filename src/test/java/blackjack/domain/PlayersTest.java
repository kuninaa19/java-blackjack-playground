package blackjack.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    void 플레이어_1명_생성() {
        Player pobi = new Player(new Name("pobi"), new Stake(10000));
        Players players = new Players(Arrays.asList(pobi));

        assertThat(players).isEqualTo(new Players(Arrays.asList(pobi)));

    }

    @Test
    void 플레이어_2명_생성() {
        Player pobi = new Player(new Name("pobi"), new Stake(10000));
        Player jason = new Player(new Name("jason"), new Stake(20000));
        Players players = new Players(Arrays.asList(pobi, jason));

        assertThat(players).isEqualTo(new Players(Arrays.asList(pobi, jason)));

    }
}