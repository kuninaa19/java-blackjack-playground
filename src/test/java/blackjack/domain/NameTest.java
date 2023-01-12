package blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void 단어하나_이름구성() {
        Name pobi = new Name("pobi");

        assertThat(pobi).isEqualTo(new Name("pobi"));
    }

    @Test
    void 빈값입력_에러() {
        assertThatThrownBy(() -> {
            new Name(" ");
        }).hasMessage(Name.EMPTY_EXCEPTION);
    }
}