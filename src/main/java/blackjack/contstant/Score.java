package blackjack.contstant;

public enum Score {
    A(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(10),
    Q(10),
    K(10);

    private final int score;

    Score(int score) {
        this.score = score;
    }

    public static Score fromOrdinal(int randomNumber) {
        return values()[getNum(randomNumber)];
    }

    private static int getNum(int randomNumber) {
        return randomNumber % Score.getSize();
    }

    public static int getSize() {
        return values().length;
    }

    public boolean isRank() {
        return this.equals(A) || this.equals(J) || this.equals(Q) || this.equals(K);
    }

    public boolean isAce() {
        return this.equals(A);
    }

    public int getScore() {
        return score;
    }
}

