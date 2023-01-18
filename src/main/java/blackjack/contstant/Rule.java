package blackjack.contstant;

public enum Rule {
    BUST, BLACKJACK, GENERAL;

    public boolean isBlackJack() {
        return this.equals(BLACKJACK);
    }

    public boolean isBust() {
        return this.equals(BUST);
    }

    public boolean isGeneral() {
        return this.equals(GENERAL);
    }
}
