import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// testing class - prints results
public class MyJDBC {
  public static void main(String[] args) {

    try {
      // url, username, password
      Connection connection = DriverManager.getConnection("", "", "");

      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery(
        "SELECT * FROM manga " +
        "JOIN mangaka ON manga.mangakaId = mangaka.idmangaka;");

      while (resultSet.next()) {
        System.out.println(resultSet.getInt("idmanga"));
        System.out.println(resultSet.getString("title"));
        System.out.println(resultSet.getInt("publicationYear"));
        System.out.println(Status.valueOf(resultSet.getString("status")));
        System.out.println(resultSet.getString("name")); 
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
