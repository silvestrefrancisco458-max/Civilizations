import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Civilization civilization = new Civilization();

        int option;
        do {
            System.out.println("\n===== CIVILIZATIONS =====");
            System.out.println("1. Ver estadísticas");
            System.out.println("2. Crear granja");
            System.out.println("3. Crear herrería");
            System.out.println("4. Crear carpintería");
            System.out.println("5. Crear espadachines");
            System.out.println("6. Crear lanceros");
            System.out.println("6. Crear lanceros");
            System.out.println("7. Crear ballestas");
            System.out.println("8. Crear cañones");
            System.out.println("9. Crear torre mágica");
            System.out.println("10. Crear iglesia");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                civilization.printStats();
            } else if (option == 2) {
                civilization.newFarm();
            } else if (option == 3) {
                civilization.newSmithy();
            } else if (option == 4) {
                civilization.newCarpentry();
            } else if (option == 5) {
                System.out.print("Cantidad de espadachines: ");
                int n = sc.nextInt();
                civilization.newSwordsman(n);
            } else if (option == 6) {
                System.out.print("Cantidad de lanceros: ");
                int n = sc.nextInt();
                civilization.newSpearman(n);
            } else if (option == 7) {
                System.out.print("Cantidad de ballestas: ");
                int n = sc.nextInt();
                civilization.newCrossbow(n);
            } else if (option == 8) {
                System.out.print("Cantidad de cañones: ");
                int n = sc.nextInt();
                civilization.newCannon(n);
            } else if (option == 9) {
                civilization.newMagicTower();
            } else if (option == 10) {
                civilization.newChurch();
            } else if (option == 0) {
                System.out.println("¡Salir del Juego!");
                break;
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (option != 0);

        sc.close();
    }
}