package blackjack.domain;

import blackjack.contstant.Score;
import blackjack.contstant.Suit;
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
        stake = new Stake(1000);
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

    @Test
    void 수익_조회() {
        player.addCard(new Card(Score.J, Suit.CLOVERS));
        player.addCard(new Card(Score.K, Suit.CLOVERS));

        Dealer dealer = new Dealer();
        dealer.addCard(new Card(Score.NINE, Suit.CLOVERS));
        dealer.addCard(new Card(Score.J, Suit.DIAMONDS));

        assertThat(player.profit(dealer)).isEqualTo(1000);
    }

    @Test
    void 수익_조회_블랙잭() {
        player.addCard(new Card(Score.A, Suit.CLOVERS));
        player.addCard(new Card(Score.K, Suit.CLOVERS));

        Dealer dealer = new Dealer();
        dealer.addCard(new Card(Score.NINE, Suit.CLOVERS));
        dealer.addCard(new Card(Score.J, Suit.DIAMONDS));

        assertThat(player.profit(dealer)).isEqualTo(1500);
    }

    @Test
    void 수익_조회_마이너스() {
        player.addCard(new Card(Score.TWO, Suit.CLOVERS));
        player.addCard(new Card(Score.K, Suit.CLOVERS));

        Dealer dealer = new Dealer();
        dealer.addCard(new Card(Score.NINE, Suit.CLOVERS));
        dealer.addCard(new Card(Score.J, Suit.DIAMONDS));

        assertThat(player.profit(dealer)).isEqualTo(-1000);
    }

    @Test
    void 수익_조회_마이너스_버스트() {
        player.addCard(new Card(Score.TWO, Suit.CLOVERS));
        player.addCard(new Card(Score.K, Suit.CLOVERS));
        player.addCard(new Card(Score.J, Suit.CLOVERS));

        Dealer dealer = new Dealer();
        dealer.addCard(new Card(Score.NINE, Suit.CLOVERS));
        dealer.addCard(new Card(Score.J, Suit.DIAMONDS));

        assertThat(player.profit(dealer)).isEqualTo(-1000);
    }
}
