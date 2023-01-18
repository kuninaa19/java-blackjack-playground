package blackjack.domain;


import blackjack.contstant.Rule;

public interface Person {
    void addCard(Card card);

    String getName();

    Cards getCards();

    boolean isDrawCondition();

    Rule getRule();

    int getStake();
}
