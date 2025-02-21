import java.util.List;

public interface MangaDAO {
  public boolean addManga(Manga manga);

  public List<Manga> getAllMangas();

  public Manga getMangaByTitle(String title);

  public boolean deleteManga(String mangaTitle);

public boolean updateManga(Manga manga);

}
