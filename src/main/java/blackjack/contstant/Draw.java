package blackjack.contstant;

public enum Draw {
    INIT(2),
    HIT(1),
    STAY(0);

    public static final String WRONG_INPUT_EXCEPTION = "(예는 y, 아니오는 n)을 입력해주세요";
    public static final String INPUT_HIT = "y";
    public static final String INPUT_STAY = "n";
    private final int count;

    Draw(int count) {
        this.count = count;
    }

    public static Draw getStatus(String input) {
        if (input.equals(INPUT_HIT)) {
            return HIT;
        }

        if (input.equals(INPUT_STAY)) {
            return STAY;
        }

        throw new IllegalArgumentException(WRONG_INPUT_EXCEPTION);
    }

    public boolean isInit() {
        return this.equals(INIT);
    }

    public boolean isHit() {
        return this.equals(HIT);
    }

    public int getCount() {
        return count;
    }
}