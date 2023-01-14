package blackjack.contstant;

public enum Suit {
    SPADES("스페이드"),
    DIAMONDS("다이아몬드"),
    CLOVERS("클로버"),
    HEARTS("하트");

    private final String koreaSpell;

    Suit(String name) {
        this.koreaSpell = name;
    }

    public static Suit fromOrdinal(int suit) {
        return values()[getNum(suit)];
    }

    private static int getNum(int randomNumber) {
        return randomNumber % Suit.getSize();
    }

    private static int getSize() {
        return values().length;
    }

    public String getKoreaSpell() {
        return koreaSpell;
    }
}