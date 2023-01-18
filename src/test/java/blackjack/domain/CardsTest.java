package blackjack.domain;

import blackjack.contstant.Rule;
import blackjack.contstant.Score;
import blackjack.contstant.Suit;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {
    @Test
    void 카드_추가() {
        Cards cards = new Cards(Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.TWO, Suit.DIAMONDS)));
        cards.addCard(new Card(Score.THREE, Suit.HEARTS));
        cards.addCard(new Card(Score.THREE, Suit.HEARTS));

        List<Card> expected = Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.TWO, Suit.DIAMONDS), new Card(Score.THREE, Suit.HEARTS));

        assertThat(cards).isEqualTo(new Cards(expected));
    }

    @Test
    void 카드_조회() {
        Cards cards = new Cards(Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.TWO, Suit.DIAMONDS)));

        assertThat(cards.getCards()).isEqualTo(Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.TWO, Suit.DIAMONDS)));
    }

    @Test
    void 카드_결과_버스트() {
        Cards cards = new Cards(Arrays.asList(new Card(Score.J, Suit.CLOVERS), new Card(Score.J, Suit.DIAMONDS), new Card(Score.TWO, Suit.DIAMONDS)));

        assertThat(cards.getRule()).isEqualTo(Rule.BUST);
    }

    @Test
    void 카드_합_계산_A_11_계산() {
        Cards cards = new Cards(Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.J, Suit.DIAMONDS)));

        assertThat(cards.getRule()).isEqualTo(Rule.BLACKJACK);
    }

    @Test
    void 카드_합_계산_A_2개() {
        Cards cards = new Cards(Arrays.asList(new Card(Score.J, Suit.DIAMONDS), new Card(Score.NINE, Suit.DIAMONDS), new Card(Score.A, Suit.CLOVERS), new Card(Score.A, Suit.CLOVERS)));

        assertThat(cards.getRule()).isEqualTo(Rule.BLACKJACK);
    }


    @Test
    void 카드_합_계산_A_1_계산() {
        Cards cards = new Cards(Arrays.asList(new Card(Score.A, Suit.CLOVERS), new Card(Score.J, Suit.DIAMONDS), new Card(Score.K, Suit.DIAMONDS)));

        assertThat(cards.getRule()).isEqualTo(Rule.BLACKJACK);
    }

    @Test
    void 카드_합_계산_A제외() {
        Cards cards = new Cards(Arrays.asList(new Card(Score.TWO, Suit.CLOVERS), new Card(Score.NINE, Suit.DIAMONDS), new Card(Score.K, Suit.CLOVERS)));

        assertThat(cards.getRule()).isEqualTo(Rule.BLACKJACK);
    }
}
