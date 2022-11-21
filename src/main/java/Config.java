public class Config {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/flatdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static String getDbConnection() {
        return DB_CONNECTION;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getDbPassword() {
        return DB_PASSWORD;
    }
}
