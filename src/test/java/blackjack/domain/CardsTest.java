package blackjack.domain;

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

        assertThat(cards.isBust()).isTrue();
    }
}
