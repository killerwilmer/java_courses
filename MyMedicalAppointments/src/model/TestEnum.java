package model;

public class TestEnum {
  public enum Day {
    SATURDAY("Sabado", "土曜日");

    private String spanish;
    private String japanese;

    Day(String spanish, String japanese) {
      this.spanish = spanish;
      this.japanese = japanese;
    }

    public String getSpanish() {
      return spanish;
    }

    public String getJapanese() {
      return japanese;
    }

    public static void main(String[] args) {
      Day day = Day.SATURDAY;

      switch (day) {
        case SATURDAY:
          System.out.println("Spanish: " + day.getSpanish() + " Japanese: " + day.getJapanese());
          break;
      }
    }
  }
}
