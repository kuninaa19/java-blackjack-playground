package blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StakeTest {
    @Test
    void 베팅금액() {
        int money = 1;
        Stake stakes = new Stake(money);

        assertThat(stakes).isEqualTo(new Stake(1));
    }

    @Test
    void 베팅금액_최소값_미만_에러() {
        int money = 0;

        assertThatThrownBy(() -> {
            Stake stakes = new Stake(money);
        }).hasMessage(Stake.STAKES_AMOUNT_EXCEPTION);
    }
}
