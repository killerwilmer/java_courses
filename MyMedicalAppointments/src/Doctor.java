import java.util.ArrayList;
import java.util.Date;

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

  ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

  public void addAvailableAppointment(Date date, String time) {
    availableAppointments.add(new Doctor.AvailableAppointment(date, time));
  }

  public ArrayList<AvailableAppointment> getAvailableAppointments() {
    return availableAppointments;
  }

  public static class AvailableAppointment {
    private int id;
    private Date date;
    private String time;

    public AvailableAppointment(Date date, String time) {
      this.date = date;
      this.time = time;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public String getTime() {
      return time;
    }

    public void setTime(String time) {
      this.time = time;
    }
  }
}
