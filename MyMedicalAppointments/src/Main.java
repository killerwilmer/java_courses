import static ui.UIMenu.*;

public class Main {
  public static void main(String[] args) {
    // showMenu();

    Doctor myDoctor = new Doctor("Edwin", "Cardiología");

    Patient myPatient = new Patient("Wilmer", "killerwilmer@gmail.com");
    myPatient.setWeight(55.5);
    System.out.println("Weight: " + myPatient.getWeight());
  }
}
