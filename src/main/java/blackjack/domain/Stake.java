package blackjack.domain;

import java.util.Objects;

public class Stake {
    public static final String STAKES_AMOUNT_EXCEPTION = Stake.MIN_STAKES_AMOUNT + "을 초과하는 금액을 베팅해주세요";
    private static final int MIN_STAKES_AMOUNT = 0;
    private final int stakes;

    public Stake(int money) {
        checkStakes(money);
        this.stakes = money;
    }

    private void checkStakes(int money) {
        if (money <= MIN_STAKES_AMOUNT) {
            throw new IllegalArgumentException(STAKES_AMOUNT_EXCEPTION);
        }
    }

    public int getStake() {
        return stakes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stake stakes1 = (Stake) o;
        return stakes == stakes1.stakes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stakes);
    }
}