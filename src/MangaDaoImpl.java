import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MangaDaoImpl implements MangaDAO {

  @Override
  public void addManga(Manga manga) {
    String addManga = "INSERT INTO manga(title, publicationYear, status, mangakaID) VALUES(?, ?, ?, ?)";

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(addManga)) {
      statement.setString(1, manga.getTitle());
      statement.setInt(2, manga.getPublicationYear());
      statement.setString(3, manga.getStatus().toString());
      statement.setInt(4, manga.getMangakaID());

      statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
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

}
