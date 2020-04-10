package controller;

import controller.dto.TableDto;
import domain.command.CommandType;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.menu.OrderedMenus;
import domain.money.PriceCalculator;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenController {
    public void run() {
        try {
            process();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            run();
        }
    }

    private void process() {
        while (true) {
            CommandType commandNumber = CommandType.findMatchingCommand(InputView.inputCommandNumber());

            if (commandNumber == CommandType.ORDER) {
                order();
            }
            if (commandNumber == CommandType.CALCULATE) {
                calculate();
            }
            if (commandNumber == CommandType.FINISH) {
                return;
            }
        }
    }

    private void order() {
        OutputView.printTables(TableDto.list(TableRepository.orderedMenus()));
        int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.getTableBy(tableNumber);

        OutputView.printMenus(MenuRepository.menus());
        Menu menu = MenuRepository.getMenuBy(InputView.inputMenuNumber());
        int count = InputView.inputMenuCount();

        TableRepository.updateTableMenu(table, menu, count);
    }

    private void calculate() {
        OutputView.printTables(TableDto.list(TableRepository.orderedMenus()));
        int tableNumber = InputView.inputTableNumber();

        OrderedMenus menus = TableRepository.getOrderedMenusBy(tableNumber);
        OutputView.printOrder(menus);
        int cashOrCard = InputView.inputCashOrCard(tableNumber);

        double totalAmount = PriceCalculator.from(menus, cashOrCard == 2).calculatePrice();
        OutputView.printTotalAmount(totalAmount);
    }

}
