package domain.command;

import java.util.stream.Stream;

public enum CommandType {
    ORDER("1"),
    CALCULATE("2"),
    FINISH("3");

    private String commandNumber;

    CommandType(String commandNumber) {
        this.commandNumber = commandNumber;
    }

    public static CommandType findMatchingCommand(int commandNumber) {
        return Stream.of(values())
                .filter(command -> command.commandNumber.equals(Integer.toString(commandNumber)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1, 2, 3 중 하나를 선택해주세요."));
    }
}
