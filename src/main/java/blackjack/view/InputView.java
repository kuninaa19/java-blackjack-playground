package blackjack.view;

import blackjack.domain.Name;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.domain.Stake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INPUT_STAKES = "의 배팅 금액은?";
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자를 입력해주세요";
    public static final String NAME_SPLIT_REGEX = ",";

    private static Scanner scanner = new Scanner(System.in);

    public static Players inputPlayers() {
        List<Name> names = inputNames();
        List<Stake> stakes = inputStakes(names);

        return inputPlayers(names, stakes);
    }

    public static Players inputPlayers(List<Name> names, List<Stake> stakes) {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), stakes.get(i)));
        }

        return new Players(players);
    }

    public static List<Name> inputNames() {
        System.out.println(INPUT_NAMES);
        return inputNames(scanner.nextLine());
    }

    public static List<Name> inputNames(String input) {
        try {
            String[] inputNames = input.split(NAME_SPLIT_REGEX);
            return inputNames(inputNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    private static List<Name> inputNames(String[] inputNames) {
        List<Name> names = new ArrayList<>();

        for (String inputName : inputNames) {
            names.add(new Name(inputName));
        }

        return names;
    }

    public static Stake inputStake(Name name) {
        System.out.println(name.getName() + INPUT_STAKES);
        return inputStake(scanner.nextLine(), name);
    }

    public static Stake inputStake(String input, Name name) {
        try {
            return new Stake(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_EXCEPTION);
            return inputStake(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputStake(name);
        }
    }

    private static List<Stake> inputStakes(List<Name> names) {
        List<Stake> stakes = new ArrayList<>();

        for (Name name : names) {
            emptyLine();
            stakes.add(inputStake(name));
        }

        return stakes;
    }

    private static void emptyLine(){
        System.out.println();
    }
}
