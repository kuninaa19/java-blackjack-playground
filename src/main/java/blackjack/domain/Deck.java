package blackjack.domain;

import blackjack.contstant.Draw;
import blackjack.contstant.Score;
import blackjack.contstant.Suit;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    public static final String DECK_RANGE_EXCEPTION = "카드 덱의 범위가 아닙니다.";
    private static final Random random = ThreadLocalRandom.current();
    private static final int CARD_COUNT = 51;
    private static final int MIN = 0;
    private final HashSet<Integer> deck;

    public Deck() {
        deck = new HashSet<>(CARD_COUNT);
    }

    public void draw(Person person, Draw draw){
        for (int i = 0; i < draw.getCount(); i++) {
            Card card = this.draw(Deck.randomNumberInRange());
            person.addCard(card);
        }
    }

    public Card draw(int randomNumber) {
        checkDeckRange(randomNumber);
        checkContainNumber(randomNumber);

        deck.add(randomNumber);

        return new Card(Score.fromOrdinal(randomNumber), Suit.fromOrdinal(randomNumber));
    }

    private void checkContainNumber(int randomNumber) {
        if (deck.contains(randomNumber)) {
            this.draw(Deck.randomNumberInRange());
        }
    }

    private void checkDeckRange(int randomNumber) {
        if (randomNumber < MIN || randomNumber > CARD_COUNT) {
            throw new IllegalArgumentException(DECK_RANGE_EXCEPTION);
        }
    }

    public static int randomNumberInRange() {
        return MIN + random.nextInt(CARD_COUNT - MIN + 1);
    }
}