package blackjack.domain;

import blackjack.contstant.Rule;

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

    public int profit(Person dealer) {
        if (loss(dealer)) {
            return -getStake();
        }

        return benefit(dealer);
    }

    private boolean loss(Person dealer) {
        return this.getRule().isBust() || dealer.getCards().higherThan(getCards());
    }

    private int benefit(Person dealer) {
        if (blackJack(dealer.getRule(), getRule())) {
            return (int) (getStake() * 1.5);
        }

        if (earning(dealer)) {
            return getStake();
        }
        return 0;
    }

    private boolean blackJack(Rule dealerRule, Rule playerRule) {
        return !dealerRule.isBlackJack() && playerRule.isBlackJack();
    }

    private boolean earning(Person dealer) {
        return dealer.getRule().isBust() && !getRule().isBust() || (getCards().higherThan(dealer.getCards()));
    }


}
