
public class Manga {
  private int id; // Manga id in SQL table
  private String title; // Manga name
  private int publicationYear; // publication year
  private int mangakaID; // foreign key in books table
  // private Genre genres;
  private Status status; // e.g. ongoing, haitus, etc.
  private String mangakaName;

  public Manga(String title, int publicationYear, Status status, String mangakaName) {
    this.title = title;
    this.publicationYear = publicationYear;
    this.status = status;
    this.mangakaName = mangakaName; // create manga object by mangaka name
  }

  public Manga(int id, String title, int publicationYear, Status status, int mangakaID, String mangakaName) {
    this.id = id; // stores id when fetching from db
    this.title = title;
    this.publicationYear = publicationYear;
    this.status = status;
    this.mangakaID = mangakaID;
    this.mangakaName = mangakaName; // printing name
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

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public int getMangakaID() {
    return mangakaID;
  }

  public String getMangakaName() {
    return mangakaName;
  }

  public void setMangakaName(String mangakaName) {
    this.mangakaName = mangakaName;
  }

  @Override
  public String toString() {
    return "Manga Title: " + this.title + "\n" +
        "Publication Year: " + this.publicationYear + "\n" +
        "Status: " + this.status;
  }

}
