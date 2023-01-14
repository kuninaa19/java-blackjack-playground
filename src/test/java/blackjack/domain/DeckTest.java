package blackjack.domain;

import blackjack.contstant.Score;
import blackjack.contstant.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void draw() {
        Card first_card = deck.draw(0);
        Card last_card = deck.draw(51);

        assertThat(first_card).isEqualTo(new Card(Score.A, Suit.SPADES));
        assertThat(last_card).isEqualTo(new Card(Score.K, Suit.HEARTS));
    }

    @Test
    void draw_range_exception() {
        assertThatThrownBy(() -> {
            deck.draw(-1);

        }).hasMessage(Deck.DECK_RANGE_EXCEPTION);

        assertThatThrownBy(() -> {
            deck.draw(52);
        }).hasMessage(Deck.DECK_RANGE_EXCEPTION);
    }
}
