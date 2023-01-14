package blackjack.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    void 플레이어_1명_생성() {
        Player pobi = new Player(new Name("pobi"), new Stake(10000), new Cards());
        Players players = new Players(Arrays.asList(pobi));

        assertThat(players).isEqualTo(new Players(Arrays.asList(pobi)));

    }

    @Test
    void 플레이어_2명_생성() {
        Player pobi = new Player(new Name("pobi"), new Stake(10000), new Cards());
        Player jason = new Player(new Name("jason"), new Stake(20000), new Cards());
        Players players = new Players(Arrays.asList(pobi, jason));

        assertThat(players).isEqualTo(new Players(Arrays.asList(pobi, jason)));
    }

    @Test
    void 플레이어_인원_수() {
        Player pobi = new Player(new Name("pobi"), new Stake(10000), new Cards());
        Player jason = new Player(new Name("jason"), new Stake(20000), new Cards());
        Players players = new Players(Arrays.asList(pobi, jason));

        assertThat(players.count()).isEqualTo(2);
    }

    @Test
    void 플레이어_이름_리스트_출력() {
        Player pobi = new Player(new Name("pobi"), new Stake(10000), new Cards());
        Player jason = new Player(new Name("jason"), new Stake(20000), new Cards());
        Players players = new Players(Arrays.asList(pobi, jason));

        assertThat(players.getNames()).isEqualTo("pobi,jason");
    }
}