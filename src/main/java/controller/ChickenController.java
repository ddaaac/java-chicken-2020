package controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenController {
    public void run() {
        int commandNumber = InputView.inputCommandNumber();
        if (commandNumber == 1) {
            order();
        } else if (commandNumber == 2) {
            
        }
    }

    private void order() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        TableRepository.getTableBy(tableNumber);

        OutputView.printMenus(MenuRepository.menus());
        Menu menu = MenuRepository.getMenuBy(InputView.inputMenuNumber());
        int count = InputView.inputMenuCount();

        TableRepository.updateTableBy(tableNumber, menu, count);
    }

}
