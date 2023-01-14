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

        initDraw(players);
        OutputView.initCardDraw(dealer, players);
    }

    private void initDraw(Players players) {
        for (int i = 0; i < players.count(); i++) {
            Player player = players.getPlayer(i);
            deck.draw(player, Draw.INIT);
        }

        deck.draw(dealer, Draw.INIT);
    }
}
