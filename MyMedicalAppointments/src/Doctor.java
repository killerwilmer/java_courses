public class Doctor {
  static int id = 0;
  private String name;
  private String speciality;

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

  public static int getId() {
    return id;
  }

  public static void setId(int id) {
    Doctor.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }
}
