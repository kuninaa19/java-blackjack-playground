package blackjack.contstant;

public enum Draw {
    INIT(2);

    private final int count;

    Draw(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}