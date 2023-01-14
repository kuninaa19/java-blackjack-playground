package blackjack.view;

import blackjack.domain.Cards;
import blackjack.domain.Person;
import blackjack.domain.Players;

public class OutputView {
    public static void initCardDraw(Person dealer, Players players) {
        System.out.println(dealer.getName() + "와 " + players.getNames() + "에게 2장의 나누었습니다.");

        OutputView.printPersonInfo(dealer);
        OutputView.printPlayersInfo(players);
        emptyLine();
    }

    public static void printPersonInfo(Person person) {
        Cards cards = person.getCards();
        System.out.println(person.getName() + "카드: " + cards.getCardNames());
    }

    public static void printPlayersInfo(Players players) {
        for (int i = 0; i < players.count(); i++) {
            OutputView.printPersonInfo(players.getPlayer(i));
        }
    }

    private static void emptyLine() {
        System.out.println();
    }
}
