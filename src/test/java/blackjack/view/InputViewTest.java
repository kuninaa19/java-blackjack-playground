package blackjack.view;

import blackjack.domain.Name;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.domain.Stake;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    void 이름_입력_1개() {
        List<Name> names = InputView.inputNames("pobi");

        assertThat(names).isEqualTo(Arrays.asList(new Name("pobi")));
    }

    @Test
    void 이름_입력_2개() {
        List<Name> names = InputView.inputNames("pobi,jason");

        assertThat(names).isEqualTo(Arrays.asList(new Name("pobi"), new Name("jason")));
    }

    @Test
    void 사용자_입력에_따른_Stakes_생성() {
        Name pobi = new Name("pobi");
        Stake stakes = InputView.inputStake("1", pobi);

        assertThat(stakes).isEqualTo(new Stake(1));
    }

    @Test
    void 이름_입력_베팅금액_입력_플레이어_생성() {
        List<Name> names = Arrays.asList(new Name("pobi"), new Name("jason"));
        List<Stake> stakes = Arrays.asList(new Stake(10000), new Stake(20000));
        Players players = InputView.inputPlayers(names, stakes);

        Player pobi = new Player(new Name("pobi"), new Stake(10000));
        Player jason = new Player(new Name("jason"), new Stake(20000));

        assertThat(players).isEqualTo(new Players(Arrays.asList(pobi, jason)));
    }
}
