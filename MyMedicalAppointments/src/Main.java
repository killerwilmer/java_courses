import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
        Doctor myDoctor = new Doctor();
        myDoctor.name = "Edwin";
        myDoctor.showName();

        showMenu();
    }
}
