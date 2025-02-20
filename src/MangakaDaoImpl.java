import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MangakaDaoImpl implements MangakaDAO {

  // returns mangaka id or 0 if not found (mangaka does not exist)
  @Override
  public int getMangakaId(String name) {
    String getMangakaId = "SELECT idmangaka FROM mangaka WHERE name = ?";
    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(getMangakaId)) {

      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        int mangakaId = rs.getInt("idmangaka"); // retrieves mangaka id
        return mangakaId;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    // meaning mangaka name does not exist
    return 0; // MangaDaoImpl will call createMangaka
  }

  @Override
  public int createMangaka(String name) {
    String query = "INSERT INTO mangaka(name) VALUES (?)";

    try (Connection connection = DatabaseConnection.getConnection();
        // new mangakaid should be made available for retrieval
        PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

      statement.setString(1, name); // sets name based on MangaDaoImpl
      statement.executeUpdate();

      ResultSet getId = statement.getGeneratedKeys(); // gets newly generated keys
      if (getId.next()) {
        int newId = getId.getInt(1); // gets the new mangaka id
        return newId;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return 0; // should not technically reach this point
  }

}
