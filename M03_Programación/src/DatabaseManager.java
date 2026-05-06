import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseManager {
    private static final String URL = "jdbc:mariadb://localhost:3306/civilizations";
    private static final String USER = "root";
    private static final String PASSWORD = "tuclave";

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveCivilization(Civilization civilization) {
        String sql = "INSERT INTO civilization " +
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

    public static void loadCivilization() {
        String sql = "SELECT * FROM civilization ORDER BY id DESC LIMIT 1";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                System.out.println("===== CIVILIZACIÓN CARGADA =====");
                System.out.println("Food: " + rs.getInt("food"));
                System.out.println("Wood: " + rs.getInt("wood"));
                System.out.println("Iron: " + rs.getInt("iron"));
                System.out.println("Mana: " + rs.getInt("mana"));
                System.out.println("Farm: " + rs.getInt("farm"));
                System.out.println("Smithy: " + rs.getInt("smithy"));
                System.out.println("Carpentry: " + rs.getInt("carpentry"));
                System.out.println("Magic Tower: " + rs.getInt("magic_tower"));
                System.out.println("Church: " + rs.getInt("church"));
                System.out.println("Technology Attack: " + rs.getInt("technology_attack"));
                System.out.println("Technology Defense: " + rs.getInt("technology_defense"));
            } else {
                System.out.println("No hay civilizaciones guardadas.");
            }

        } catch (Exception e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
}