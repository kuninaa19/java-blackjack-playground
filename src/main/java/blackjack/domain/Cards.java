package blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cards {
    public static final String DELIMITER = ", ";
    public static final int BLACKJACK = 21;
    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public Cards(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public int sum() {
        return this.cards.stream().map(Card::getScore).reduce(0, Integer::sum);
    }

    public boolean isBust() {
        return sum() > BLACKJACK;
    }

    public void addCard(Card card) {
        this.cards.add(Card.of(card));
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public String getCardNames() {
        List<String> cardNames = this.cards.stream().map(Card::toString).collect(Collectors.toList());
        return String.join(DELIMITER, cardNames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards1 = (Cards) o;
        return Objects.equals(cards, cards1.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
