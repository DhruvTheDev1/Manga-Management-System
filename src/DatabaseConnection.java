import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private static final String URL = "";
  private static final String USER = "";
  private static final String PASSWWORD = "";

  public DatabaseConnection() {
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection();
  }

}
