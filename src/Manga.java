
public class Manga {
  private int id; // Manga id in SQL table
  private String title; // Manga name
  private int publicationYear; // publication year
  private int mangakaID; // foreign key in books table
  // private Genre genres;
  private Status status; // e.g. ongoing, haitus, etc.

  public Manga(String title, int publicationYear, int mangakaID, Status status) {
    this.title = title;
    this.publicationYear = publicationYear;
    this.mangakaID = mangakaID;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int publicationYear) {
    this.publicationYear = publicationYear;
  }

  public int getMangakaID() {
    return mangakaID;
  }

  @Override
  public String toString() {
    return "Manga Title: " + this.title + "\n" +
        "Publication Year: " + this.publicationYear + "\n" +
        "Status: " + this.status;
  }

}
