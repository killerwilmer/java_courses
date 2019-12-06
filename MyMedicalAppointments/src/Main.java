import model.Doctor;
import model.Patient;
import model.User;

import java.util.Date;

public class Main {
  public static void main(String[] args) {
    // showMenu();

    Doctor myDoctor = new Doctor("Edwin", "Cardiología");
    myDoctor.addAvailableAppointment(new Date(), "4pm");
    myDoctor.addAvailableAppointment(new Date(), "10am");
    myDoctor.addAvailableAppointment(new Date(), "1pm");

    for (Doctor.AvailableAppointment aA : myDoctor.getAvailableAppointments()) {
      // System.out.println(aA.getDate() + " " + aA.getTime());
    }

    myDoctor.showDataUser();

    Patient myPatient = new Patient("Wilmer", "killerwilmer@gmail.com");
    myPatient.setWeight(55.5);
    // System.out.println(myPatient);
    myPatient.showDataUser();

    User user =
        new User("User", "user@email.com") {
          @Override
          public void showDataUser() {
            System.out.println("Clases anonimas");
          }
        };

    user.showDataUser();
  }
}
