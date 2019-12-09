package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

  public static final String[] MONTHS = {
    "Enero",
    "Febrero",
    "Marzo",
    "Abril",
    "Mayo",
    "Junio",
    "Julio",
    "Agosto",
    "Septiembre",
    "Octubre",
    "Noviembre",
    "Diciembre"
  };

  public static void showMenu() {
    System.out.println("Welcome to My Appointments");
    System.out.println("Selecciona la opción deseada");

    int response = 0;
    do {
      System.out.println("1. model.Doctor");
      System.out.println("2. model.Patient");
      System.out.println("0. Salir");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          response = 0;
          System.out.println("Doctor");
          authUser(1);
          break;
        case 2:
          response = 0;
          authUser(2);
          break;
        case 0:
          System.out.println("Thank you for you visit");
          break;
        default:
          System.out.println("Please select a correct answer");
      }
    } while (response != 0);
  }

  static void showPatientMenu() {
    int response = 0;
    do {
      System.out.println("\n\n");
      System.out.println("model.Patient");
      System.out.println("1. Book an appointment");
      System.out.println("2. My appointments");
      System.out.println("0. Return");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
        case 1:
          System.out.println("::Book an appointment");
          for (int i = 0; i < 3; i++) {
            System.out.println(i + 1 + " . " + MONTHS[i]);
          }
          break;
        case 2:
          System.out.println("::My appointments");
          break;
        case 0:
          showMenu();
          break;
      }
    } while (response != 0);
  }

  private static void authUser(int userType) {
    // 1 Doctor
    // 2 Paciente
    ArrayList<Doctor> doctors = new ArrayList<>();
    doctors.add(new Doctor("Doctor 1", "emaildoctor1@mail.com"));
    doctors.add(new Doctor("Doctor 2", "emaildoctor2@mail.com"));
    doctors.add(new Doctor("Doctor 3", "emaildoctor3@mail.com"));

    ArrayList<Patient> patients = new ArrayList<>();
    patients.add(new Patient("Paciente1", "emailpaciente1@mail.com"));
    patients.add(new Patient("Paciente2", "emailpaciente2@mail.com"));
    patients.add(new Patient("Paciente3", "emailpaciente3@mail.com"));

    boolean emailCorrect = false;

    do{
      System.out.println("Insert your email: [a@a.com]");
      Scanner scanner = new Scanner(System.in);
      String email = scanner.nextLine();

      if (userType == 1) {
        for (Doctor doctor : doctors) {
          if (doctor.getEmail().equals(email)) {
            emailCorrect = true;
          }
        }
      } else if (userType == 2) {
        for (Patient patient : patients) {
            if(patient.getEmail().equals(email)) {
              emailCorrect = true;
            }
        }
      }
    }while(!emailCorrect);
  }
}
