public class Doctor {
  static int id = 0;
  String name;
  String speciality;

  Doctor() {
    System.out.println("Construyendo el objeto doctor");
  }

  Doctor(String name, String speciality) {
    System.out.println("El nombre del Doctor asignado es: " + name);
    id++;
    this.name = name;
    this.speciality = speciality;
  }

  public void showName() {
    System.out.println(name);
  }
}
