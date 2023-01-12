package blackjack.domain;

import java.util.Objects;

public class Name {
    public static final String EMPTY_EXCEPTION = "이름을 입력해주세요";
    public static final String EMPTY = "";
    private final String name;

    public Name(String name) {
        checkValidName(name);
        this.name = name;
    }

    private void checkValidName(String name) {
        String trimName = name.trim();

        if (trimName.equals(EMPTY)) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
