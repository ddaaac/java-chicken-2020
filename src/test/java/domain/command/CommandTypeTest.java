package domain.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTypeTest {
    @ParameterizedTest
    @MethodSource("generateCommands")
    void findMatching(int input, CommandType expected) {
        assertThat(CommandType.findMatchingCommand(input)).isEqualTo(expected);

    }

    static Stream<Arguments> generateCommands() {
        return Stream.of(Arguments.of(1, CommandType.ORDER),
                Arguments.of(2, CommandType.CALCULATE),
                Arguments.of(3, CommandType.FINISH));
    }

    @Test
    void findMatchingInvalid() {
        assertThatThrownBy(() -> {
            CommandType.findMatchingCommand(4);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1, 2, 3 중 하나를 선택해주세요.");
    }
}