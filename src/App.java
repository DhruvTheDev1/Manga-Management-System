import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // MangaDAO mangaDAO = new MangaDaoImpl();
        // Manga MonsterManga = new Manga("Monster", 1994, Status.COMPLETED, 1);

        // mangaDAO.addManga(MonsterManga);

        // System.out.println("Added");

        // mangaDAO.addManga(new Manga("Wanted!", 1998, Status.COMPLETED, 1));

        // System.out.println("added");

        // print results
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
    }
}
