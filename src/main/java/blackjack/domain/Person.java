package blackjack.domain;

import java.util.Objects;

public abstract class Person {
    private final Name name;
    private final Stake stake;
    private final Cards cards;

    public Person(Name name, Stake stake, Cards cards) {
        this.name = name;
        this.stake = stake;
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(stake, person.stake) && Objects.equals(cards, person.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stake, cards);
    }
}
