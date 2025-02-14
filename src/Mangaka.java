
public class Mangaka {

  private int id; // id automatically assigned by mySQL
  private String name; // mangaka name

  public Mangaka(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Author Name : " + this.name;
  }

}
