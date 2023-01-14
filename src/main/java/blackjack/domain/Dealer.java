package blackjack.domain;

public class Dealer extends AbstractPerson {

    private static final String NAME = "딜러";
    private static final int MONEY = 1;

    public Dealer() {
        super(new Name(NAME), new Stake(MONEY), new Cards());
    }
}
