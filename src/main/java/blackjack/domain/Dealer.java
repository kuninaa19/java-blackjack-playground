package blackjack.domain;

public class Dealer extends Person {

    private static final String NAME = "딜러";
    private static final int MONEY = 0;

    public Dealer() {
        super(new Name(NAME), new Stake(MONEY), new Cards());
    }
}
