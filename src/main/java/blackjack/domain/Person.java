package blackjack.domain;


public interface Person {
    void addCard(Card card);

    String getName();

    Cards getCards();

    boolean isDrawCondition();
}
