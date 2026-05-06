import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/civilizations";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveCivilization(Civilization civilization) {
        String sql = "INSERT INTO civilizations " + 
                "(food, wood, iron, mana, farm, smithy, carpentry, magic_tower, church, technology_attack, technology_defense)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, civilization.getFood());
            ps.setInt(2, civilization.getWood());
            ps.setInt(3, civilization.getIron());
            ps.setInt(4, civilization.getMana());
            ps.setInt(5, civilization.getFarm());
            ps.setInt(6, civilization.getSmithy());
            ps.setInt(7, civilization.getCarpentry());
            ps.setInt(8, civilization.getMagicTower());
            ps.setInt(9, civilization.getChurch());
            ps.setInt(10, civilization.getTechnologyAttack());
            ps.setInt(11, civilization.getTechnologyDefense());

            ps.executeUpdate();
            System.out.println("Civilización guardada en la base de datos.");

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}