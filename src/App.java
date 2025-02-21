import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // MangaDAO mangaDAO = new MangaDaoImpl();
        // Manga MonsterManga = new Manga("Monster", 1994, Status.COMPLETED, 1);

        // mangaDAO.addManga(MonsterManga);

        // System.out.println("Added");

        // mangaDAO.addManga(new Manga("Wanted!", 1998, Status.COMPLETED, 1));

        // System.out.println("added");

        // print results - debugging

        MangaDAO mangaDAO = new MangaDaoImpl();

        List<Manga> mangaList = mangaDAO.getAllMangas();
        for (Manga manga : mangaList) {
        System.out.println("ID: " + manga.getId());
        System.out.println("Title " + manga.getTitle());
        System.out.println("Year " + manga.getPublicationYear());
        System.out.println("Status: " + manga.getStatus());
        System.out.println("Mangaka: " + manga.getMangakaID());
        System.out.println("Mangaka Name: " + manga.getMangakaName());
        System.out.println("-------------------");

        }

        // adding by mangaka name
        // MangaDAO mangaDAO = new MangaDaoImpl();
        // mangaDAO.addManga(new Manga("The Garden of Words", 2013, Status.COMPLETED,
        // "Makoto Shinkai"));

        // existing mangaka
        // MangaDAO mangaDAO = new MangaDaoImpl();
        // mangaDAO.addManga(new Manga("Romance Dawn", 1996, Status.COMPLETED, "Eiichiro
        // Oda"));

        // adding by mangaka name
        // MangaDAO mangaDAO = new MangaDaoImpl();
        // mangaDAO.addManga(new Manga("A Silent Voice", 2013, Status.COMPLETED,
        // "Yoshitoki Oima"));

        // MangaDaoImpl mangaDao = new MangaDaoImpl();

        // Test getMangaByTitle
        // String titleToSearch = "Wanted!";
        // Manga foundManga = mangaDao.getMangaByTitle(titleToSearch);

        // if (foundManga != null) {
        // System.out.println("Manga Found:");
        // System.out.println("ID: " + foundManga.getId());
        // System.out.println("Title: " + foundManga.getTitle());
        // System.out.println("Publication Year: " + foundManga.getPublicationYear());
        // System.out.println("Status: " + foundManga.getStatus());
        // System.out.println("Mangaka ID: " + foundManga.getMangakaID());
        // System.out.println("Mangaka Name: " + foundManga.getMangakaName());
        // } else {
        // System.out.println("No manga found with title: " + titleToSearch);
        // }

        // delete manga by title

        // MangaDaoImpl mangaDao = new MangaDaoImpl();
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the title of the manga to delete: ");
        // String title = scanner.nextLine();

        // boolean deleted = mangaDao.deleteManga(title);
        // if (deleted) {
        // System.out.println("Manga deleted successfully!");
        // } else {
        // System.out.println("No manga found with that title.");
        // }

        // update manga test
        // ask for title - identify manga, if not found exit
        // show details - ask for new values or leave empty to not update
        // testing
    //     MangaDAO mangaDAO = new MangaDaoImpl();
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.println(mangaDAO.getAllMangas());

    //     System.out.print("Enter title");
    //     String mangaTitle = scanner.nextLine();

    //     Manga mangaToUpdate = mangaDAO.getMangaByTitle(mangaTitle);

    //     if (mangaToUpdate == null) {
    //         System.out.println("Manga not found");
    //     } else {
    //         System.out.println("Manga Details:");
    //         System.out.println(mangaToUpdate);

    //         System.out.print("Enter new title or empty to leave ");
    //         String newTitle = scanner.nextLine();
    //         if (!newTitle.isBlank()) {
    //             mangaToUpdate.setTitle(newTitle);
    //         }

    //         System.out.print("Enter new publication year or empty to leave ");
    //         String year = scanner.nextLine();
    //         if (!year.isBlank()) {
    //             mangaToUpdate.setPublicationYear(Integer.parseInt(year));
    //         }
    //     }

    //     System.out.print("Enter new status or empty to leave");
    //     String status = scanner.nextLine();
    //     if (!status.isBlank()) {
    //         mangaToUpdate.setStatus(Status.valueOf(status.toUpperCase()));
    //     }

    //     System.out.print("Enter new mangaka name or empty to leave ");
    //     String newMangaka = scanner.nextLine();
    //     if (!newMangaka.isBlank()) {
    //         mangaToUpdate.setMangakaName(newMangaka);
    //     }

    //     boolean updated = mangaDAO.updateManga(mangaToUpdate);

    //     if (updated) {
    //         System.out.println("Manga updated");
    //     } else {
    //         System.out.println("Error updating");
    //     }
    //     scanner.close();

    }

}
