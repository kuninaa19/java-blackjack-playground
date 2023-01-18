package blackjack.domain;

import blackjack.contstant.Score;
import blackjack.contstant.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
    }

    @Test
    void 최종수익결과_수익() {
        dealer.addCard(new Card(Score.J, Suit.CLOVERS));
        dealer.addCard(new Card(Score.K, Suit.CLOVERS));

        Player pobi = new Player(new Name("pobi"), new Stake(10000), new Cards(Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.TWO, Suit.DIAMONDS))));
        Player jason = new Player(new Name("pobi"), new Stake(2000), new Cards(Arrays.asList(new Card(Score.THREE, Suit.CLOVERS), new Card(Score.FIVE, Suit.DIAMONDS))));
        Players players = new Players(Arrays.asList(pobi, jason));

        assertThat(dealer.profit(players)).isEqualTo(12000);
    }

    @Test
    void 최종수익결과_손실() {
        dealer.addCard(new Card(Score.TWO, Suit.CLOVERS));
        dealer.addCard(new Card(Score.THREE, Suit.CLOVERS));

        Player pobi = new Player(new Name("pobi"), new Stake(10000), new Cards(Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.TWO, Suit.DIAMONDS))));
        Player jason = new Player(new Name("pobi"), new Stake(2000), new Cards(Arrays.asList(new Card(Score.THREE, Suit.CLOVERS), new Card(Score.FIVE, Suit.DIAMONDS))));
        Players players = new Players(Arrays.asList(pobi, jason));

        assertThat(dealer.profit(players)).isEqualTo(-12000);
    }

    @Test
    void 최종수익결과_부분_수익() {
        dealer.addCard(new Card(Score.TWO, Suit.CLOVERS));
        dealer.addCard(new Card(Score.THREE, Suit.CLOVERS));

        Player pobi = new Player(new Name("pobi"), new Stake(10000), new Cards(Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.TWO, Suit.DIAMONDS))));
        Player jason = new Player(new Name("pobi"), new Stake(2000), new Cards(Arrays.asList(new Card(Score.TWO, Suit.CLOVERS), new Card(Score.TWO, Suit.SPADES))));
        Players players = new Players(Arrays.asList(pobi, jason));

        assertThat(dealer.profit(players)).isEqualTo(-8000);
    }
}
