package blackjack.domain;

public class Dealer extends AbstractPerson {

    private static final String NAME = "딜러";
    private static final int MONEY = 1;
    public static final int DRAW_CONDITION = 17;

    public Dealer() {
        super(new Name(NAME), new Stake(MONEY), new Cards());
    }

    public boolean isDrawCondition() {
        Cards cards = getCards();

        return cards.sum() < DRAW_CONDITION;
    }

    public int profit(Players players) {
        int profit = 0;

        for (int i = 0; i < players.count(); i++) {
            Player player = players.getPlayer(i);
            profit += -player.profit(this);
        }

        return profit;
    }
}
