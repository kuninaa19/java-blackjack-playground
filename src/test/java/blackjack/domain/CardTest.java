package blackjack.domain;

import blackjack.contstant.Score;
import blackjack.contstant.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @Test
    void 카드_생성() {
        Card card = new Card(Score.TWO, Suit.HEARTS);

        assertThat(card).isEqualTo(new Card(Score.TWO, Suit.HEARTS));
    }

    @Test
    void 객체_복사() {
        Card card = new Card(Score.TWO, Suit.HEARTS);

        assertThat(card).isEqualTo(Card.of(card));
    }

    @Test
    void 일반_카드_정보출력() {
        Card card = new Card(Score.TWO, Suit.HEARTS);

        assertThat(card).hasToString(new Card(Score.TWO, Suit.HEARTS).toString());
    }

    @Test
    void RANK카드_정보_출력() {
        Card ace = new Card(Score.A, Suit.HEARTS);
        Card jack = new Card(Score.J, Suit.CLOVERS);
        Card queen = new Card(Score.Q, Suit.DIAMONDS);
        Card king = new Card(Score.K, Suit.SPADES);

        assertThat(ace).hasToString(new Card(Score.A, Suit.HEARTS).toString());
        assertThat(jack).hasToString(new Card(Score.J, Suit.CLOVERS).toString());
        assertThat(queen).hasToString(new Card(Score.Q, Suit.DIAMONDS).toString());
        assertThat(king).hasToString(new Card(Score.K, Suit.SPADES).toString());
    }

    @Test
    void 카드_숫자_조회() {
        Card jack = new Card(Score.J, Suit.HEARTS);
        Card two = new Card(Score.TWO, Suit.HEARTS);

        assertThat(jack.getScore()).isEqualTo(Score.J.getScore());
        assertThat(two.getScore()).isEqualTo(Score.TWO.getScore());
    }
}
