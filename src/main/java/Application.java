import controller.ChickenController;

public class Application {
    public static void main(String[] args) {
        new ChickenController().run();

//        final List<Table> tables = TableRepository.tables();
//        OutputView.printTables(tables);
//
//        final int tableNumber = InputView.inputTableNumber();
//
//        final List<Menu> menus = MenuRepository.menus();
//        OutputView.printMenus(menus);
    }
}
