package blackjack.domain;

import org.junit.jupiter.api.BeforeEach;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
        deck = new Deck();
    }
}
