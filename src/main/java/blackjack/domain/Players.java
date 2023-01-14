package blackjack.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    public static final String DELIMITER = ",";

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Player getPlayer(int idx) {
        return this.players.get(idx);
    }

    public int count() {
        return players.size();
    }

    public String getNames() {
        List<String> names = this.players.stream().map(AbstractPerson::getName).collect(Collectors.toList());
        return String.join(DELIMITER, names);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
