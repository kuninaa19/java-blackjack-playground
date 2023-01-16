package blackjack.view;

import blackjack.contstant.Draw;
import blackjack.domain.*;

public class OutputView {
    public static final String INPUT_DEALER_ADD_CARD = "는 16이하라 한장의 카드를 더 받았습니다.";

    public static void cardDraw(Person dealer, Players players, Draw draw) {
        if (draw.isInit()) {
            System.out.println(dealer.getName() + "와 " + players.getNames() + "에게 2장의 나누었습니다.");
        }

        emptyLine();
        printDrawInfo(dealer, players, draw);
    }

    private static void printDrawInfo(Person dealer, Players players, Draw draw) {
        OutputView.printCardInfo(dealer, () -> draw.equals(Draw.INIT));

        for (int i = 0; i < players.count(); i++) {
            OutputView.printCardInfo(players.getPlayer(i), () -> draw.equals(Draw.INIT));
        }

        emptyLine();
    }

    public static void printCardInfo(Person person, PrintStrategy printStrategy) {
        if (printStrategy.gameRunning()) {
            Cards cards = person.getCards();
            System.out.println(person.getName() + "카드: " + cards.getCardNames());
            return;
        }

        System.out.println(person);
    }

    public static void printDealerCardDraw(Person person) {
        emptyLine();
        System.out.println(person.getName() + INPUT_DEALER_ADD_CARD);
    }

    private static void emptyLine() {
        System.out.println();
    }
}
