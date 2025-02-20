// gets mangaka id by name
// when adding a manga - user does not know mangaka's id
// e.g. adding a new manga - mangaka exists (passes id to MangaDaoImpl)
// if mangaka does not exist - creates a new mangaka entry in db and uses that id
public interface MangakaDAO {
  // e.g. Eiichiro Oda exists (passes 1)
  public int getMangakaId(String name);
  // e.g. No mangaka name - "Makoto Shinkai" - creates new mangaka entry
  public int createMangaka(String name);
}
