package blackjack.domain;

public class Player extends AbstractPerson {

    public static final int DRAW_CONDITION = 21;

    public Player(Name name, Stake stake, Cards cards) {
        super(name, stake, cards);
    }

    @Override
    public boolean isDrawCondition() {
        Cards cards = getCards();

        return cards.sum() < DRAW_CONDITION;
    }
}
