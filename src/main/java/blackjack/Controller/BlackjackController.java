package blackjack.Controller;

import blackjack.contstant.Draw;
import blackjack.domain.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {

    private final Dealer dealer;
    private final Deck deck;

    public BlackjackController() {
        dealer = new Dealer();
        deck = new Deck();
    }

    public void run() {
        Players players = InputView.inputPlayers();

        play(players, Draw.INIT);
        play(players, Draw.HIT);
        OutputView.showProfit(dealer,players);
    }

    private void play(Players players, Draw draw) {
        for (int i = 0; i < players.count(); i++) {
            draw(players.getPlayer(i), draw);
        }

        draw(dealer, draw);

        OutputView.cardDraw(dealer, players, draw);
    }

    private void draw(Person person, Draw drawCount) {
        if (drawCount.isInit()) {
            deck.draw(person, drawCount);
            return;
        }

        hit(person, drawCount);
    }

    private void hit(Person person, Draw drawCount) {
        if (person instanceof Player && person.isDrawCondition()) {
            InputView.hit(person, deck, Draw.HIT);
            return;
        }

        if (person instanceof Dealer && person.isDrawCondition()) {
            OutputView.printDealerCardDraw(dealer);
            deck.draw(person, drawCount);
        }
    }
}
