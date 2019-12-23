package by.bsuir.alexkomar.cultureis;

public class CultureISLauncher {
    public static void main(String[] args) {
        CultureISGui gui = new CultureISGui();
        CultureISController controller = new CultureISController();
        SqlManager sqlManager = new SqlManager();

        sqlManager.connect();

        controller.setSqlManager(sqlManager);

        gui.setController(controller);
        gui.createGui();
        System.out.println("Start app");
    }
}
