package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://127.0.0.1:3307/civilizations";
    private static final String USER = "root";
    private static final String PASSWORD = "tuclave";

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveEmpire(Empire empire) {
        String sql = "INSERT INTO civilization " +
                "(food, wood, iron, mana, farm, smithy, carpentry, magic_tower, church, technology_attack, technology_defense) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, empire.getFood());
            ps.setInt(2, empire.getWood());
            ps.setInt(3, empire.getIron());
            ps.setInt(4, empire.getMana());

            ps.setInt(5, empire.getFarms());
            ps.setInt(6, empire.getSmithies());
            ps.setInt(7, empire.getCarpentries());
            ps.setInt(8, empire.getMagicTowers());
            ps.setInt(9, empire.getChurches());

            ps.setInt(10, 0);
            ps.setInt(11, 0);

            ps.executeUpdate();
            System.out.println("Estado guardado en MySQL");

        } catch (Exception e) {
            System.out.println("Error guardando estado: " + e.getMessage());
        }
    }

    public static void saveBattle(String winner, String report, int wood, int iron) {
        String sql = "INSERT INTO battle (winner, battle_report, waste_wood, waste_iron) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, winner);
            ps.setString(2, report);
            ps.setInt(3, wood);
            ps.setInt(4, iron);

            ps.executeUpdate();
            System.out.println("Batalla guardada en MySQL");

        } catch (Exception e) {
            System.out.println("Error guardando batalla: " + e.getMessage());
        }
    }
}
