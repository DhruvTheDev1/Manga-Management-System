import java.util.List;
import java.util.Scanner;

public class UserInterface {
  private MangaDAO mangaDao;
  private Scanner scanner;

  public UserInterface() {
    this.mangaDao = new MangaDaoImpl();
    this.scanner = new Scanner(System.in);
  }

  public void start() {
    while (true) {
      System.out.println("---MANGA MANAGEMENT---");
      System.out.println("1. View All Mangas");
      System.out.println("2. Add a manga");
      System.out.println("3. Search manga by title");
      System.out.println("4. Update a manga");
      System.out.println("5. Delete a manga");
      System.out.println("6. Exit");
      int userChoice = Integer.parseInt(scanner.nextLine());

      if (userChoice == 1) { // view all mangas
        getAllMangas();
      } else if (userChoice == 2) { // add a manga to db
        addManga();
      } else if (userChoice == 3) { // get manga by title
        getMangaByTitle();
      } else if (userChoice == 4) { // update manga
        updateManga();
      } else if (userChoice == 5) { // delete manga
        deleteManga();
      } else if (userChoice == 6) { 
        System.out.println("Exiting Manga Management");
        break;
      } else {
        System.out.println("Please enter a valid choice");
      }
    }
    scanner.close();
  }

  // view all mangas
  public void getAllMangas() {
    List<Manga> mangaList = mangaDao.getAllMangas();

    for (Manga manga : mangaList) {
      System.out.println("Title: " + manga.getTitle());
      System.out.println("Year: " + manga.getPublicationYear());
      System.out.println("Status: " + manga.getStatus());
      System.out.println("Mangaka: " + manga.getMangakaName());
      System.out.println("-------------------");
    }

  }

  // add manga to db
  public void addManga() {
    System.out.println("Enter Manga Title");
    String title = scanner.nextLine();

    System.out.println("Enter Publication Year");
    int year = Integer.parseInt(scanner.nextLine());

    System.out.println("Enter Status: ");
    Status status = getStatus(null);

    System.out.println("Enter Mangaka Name");
    String mangakaName = scanner.nextLine();
    // adding manga
    mangaDao.addManga(new Manga(title, year, status, mangakaName));
    // printing result (debugging)
    System.out.println("---Added Manga--- ");
    System.out.println(mangaDao.getMangaByTitle(title));
  }

  // get manga by title
  public void getMangaByTitle() {
    System.out.println("Enter Manga Title:");
    String title = scanner.nextLine();

    Manga foundManga = mangaDao.getMangaByTitle(title);

    if (foundManga != null) {
      System.out.println(foundManga);
    } else {
      System.out.println("No manga found with title " + title);
    }

  }

  // update manga
  public void updateManga() {
    System.out.println("Enter Title Of Manga To Update: ");
    System.out.println("Enter new values to update to leave empty");
    String mangaTitle = scanner.nextLine();

    // checking for manga entry
    Manga mangaUpdate = mangaDao.getMangaByTitle(mangaTitle);

    if (mangaUpdate == null) {
      System.out.println("Manga Not Found");
      return;

    } else {
      System.out.println("Manga Details: ");
      System.out.println(mangaUpdate); // prints manga details

      // user enters new fields or leaves empty

      System.out.println("Enter Title (leave empty to leave as before)");
      String newTitle = scanner.nextLine();
      if (!newTitle.isBlank()) {
        mangaUpdate.setTitle(newTitle);
      }

      System.out.println("Enter Publication YEAR (leave empty to leave as before)");
      String newPublicationYear = scanner.nextLine();
      if (!newPublicationYear.isBlank()) {
        mangaUpdate.setPublicationYear(Integer.parseInt(newPublicationYear));
      }

      Status status = getStatus(mangaUpdate.getStatus());
      if (status != mangaUpdate.getStatus()) {
        mangaUpdate.setStatus(status);
      }

      System.out.println("Enter New Mangaka Name (leave empty to leave as before)");
      String newMangaka = scanner.nextLine();

      if (!newMangaka.isBlank()) {
        mangaUpdate.setMangakaName(newMangaka);
      }

      boolean updated = mangaDao.updateManga(mangaUpdate);
      if (updated) {
        System.out.println("Manga Updated");
      } else {
        System.out.println("Error Updating");
      }

    }
  }

  // delete manga
  public void deleteManga() {
    System.out.println("Enter Manga Title To Delete: ");
    String mangaTitleToDelete = scanner.nextLine();

    boolean deleted = mangaDao.deleteManga(mangaTitleToDelete);

    if (deleted) {
      System.out.println("Manga " + mangaTitleToDelete + " Deleted Successfully");
    } else {
      System.out.println("No manga found with: " + mangaTitleToDelete);
    }
  }

  // helper method for getting status
  // used in addManga and updateManga
  private Status getStatus(Status currentStatus) {
    System.out.println("Pick Status: ");
    System.out.println("1. COMPLETED");
    System.out.println("2. ONGOING");
    System.out.println("3. HIATUS");
    System.out.println("4. CANCELLED");

    while (true) {
      String input = scanner.nextLine();
      if (input.isBlank()) {
        return currentStatus;
      }
      int statusChoice = Integer.parseInt(input);

      if (statusChoice == 1) {
        return Status.COMPLETED;
      } else if (statusChoice == 2) {
        return Status.ONGOING;
      } else if (statusChoice == 3) {
        return Status.HIATUS;
      } else if (statusChoice == 4) {
        return Status.CANCELLED;
      } else {
        System.out.println("Invalid Choice, Default Choice: Completed");
        return Status.COMPLETED;
      }
    }
  }

}
