package blackjack.domain;

import java.util.Objects;

public class Player {
    private final Name name;
    private final Stake stake;

    public Player(Name name, Stake stake) {
        this.name = name;
        this.stake = stake;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(stake, player.stake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stake);
    }
}
