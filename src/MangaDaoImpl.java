import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class MangaDaoImpl implements MangaDAO {
  private MangakaDAO mangakaDAO = new MangakaDaoImpl();

  @Override // adds a manga to the db
  public boolean addManga(Manga manga) {
    // get mangaka id
    int mangakaId = mangakaDAO.getMangakaId(manga.getMangakaName());
    if (mangakaId == 0) { // does not exist - creates one
      mangakaId = mangakaDAO.createMangaka(manga.getMangakaName());
    }

    String addManga = "INSERT INTO manga(title, publicationYear, status, mangakaID) VALUES(?, ?, ?, ?)";

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(addManga)) {
      statement.setString(1, manga.getTitle());
      statement.setInt(2, manga.getPublicationYear());
      statement.setString(3, manga.getStatus().toString());
      statement.setInt(4, mangakaId);

      int rowsAffected = statement.executeUpdate();
      return rowsAffected > 0;

    } catch (SQLException e) {
      if (e instanceof SQLIntegrityConstraintViolationException) {
        // duplicate entry
        System.out.println("Duplicate entry");
      } else {
        // other sql exception
        e.printStackTrace();
      }
    }
    return false;
  }

  @Override // retrieves all manga from db
  public List<Manga> getAllMangas() {
    List<Manga> mangas = new ArrayList<>();
    String getAllMangas = "SELECT * FROM manga " +
        "JOIN mangaka ON manga.mangakaId = mangaka.idmangaka";

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(getAllMangas);
        ResultSet resultSet = statement.executeQuery()) {

      while (resultSet.next()) {
        int mangaId = resultSet.getInt("idmanga");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("publicationYear");
        Status status = Status.valueOf(resultSet.getString("status"));
        int mangakaId = resultSet.getInt("mangakaid");
        String mangakaName = resultSet.getString("name");

        mangas.add(new Manga(mangaId, title, year, status, mangakaId, mangakaName));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return mangas;
  }

  @Override
  public Manga getMangaByTitle(String title) {

    List<Manga> getMangaByTitle = getAllMangas();

    for (Manga manga : getMangaByTitle) {
      if (manga.getTitle().equalsIgnoreCase(title)) {
        return manga;
      }
    }
    return null;
  }

  @Override // deletes manga
  public boolean deleteManga(String mangaTitle) {

    Manga deleteByTitle = getMangaByTitle(mangaTitle);
    if (deleteByTitle != null) {
      int mangaToDeleteId = deleteByTitle.getId();

      String deleteQuery = "DELETE FROM manga WHERE idmanga = ?";

      try (Connection connection = DatabaseConnection.getConnection();
          PreparedStatement pDelete = connection.prepareStatement(deleteQuery)) {

        pDelete.setInt(1, mangaToDeleteId);
        int rowsAffected = pDelete.executeUpdate();
        return rowsAffected > 0;

      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
    return false;

  }

  @Override // update manga
  public boolean updateManga(Manga manga) {
    String updateQuery = "UPDATE manga SET title = ?, publicationYear = ?, Status = ?, mangakaId = ? WHERE idmanga =?";

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateQuery)) {

      statement.setString(1, manga.getTitle());
      statement.setInt(2, manga.getPublicationYear());
      statement.setString(3, manga.getStatus().toString());

      int mangakaId = mangakaDAO.getMangakaId(manga.getMangakaName());
      if (mangakaId == 0) {
        mangakaId = mangakaDAO.createMangaka(manga.getMangakaName());
      }

      statement.setInt(4, mangakaId);
      statement.setInt(5, manga.getId());

      int rowsAffected = statement.executeUpdate();
      return rowsAffected > 0;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  } // end of method

}
