package blackjack.domain;

import blackjack.contstant.Score;
import blackjack.contstant.Suit;
import java.util.Objects;

public class Card {
    private final Score score;
    private final Suit suit;

    public Card(Score score, Suit suit) {
        this.score = score;
        this.suit = suit;
    }

    public static Card of(Card card) {
        return new Card(card.score, card.suit);
    }

    public int getScore() {
        return score.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return score == card.score && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, suit);
    }

    @Override
    public String toString() {
        if (score.isRank()) {
            return score + suit.getKoreaSpell();
        }

        return score.getScore() + suit.getKoreaSpell();
    }
}
