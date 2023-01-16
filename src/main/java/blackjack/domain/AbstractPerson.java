package blackjack.domain;

import java.util.Objects;

public abstract class AbstractPerson implements Person {
    private final Name name;
    private final Stake stake;
    private final Cards cards;

    public AbstractPerson(Name name, Stake stake, Cards cards) {
        this.name = name;
        this.stake = stake;
        this.cards = cards;
    }

    @Override
    public void addCard(Card card) {
        cards.addCard(card);
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public Cards getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPerson person = (AbstractPerson) o;
        return Objects.equals(name, person.name) && Objects.equals(stake, person.stake) && Objects.equals(cards, person.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stake, cards);
    }

    @Override
    public String toString() {
        return name.getName() + " 카드: " + cards.getCardNames() + " - 결과: " + cards.sum();
    }
}
