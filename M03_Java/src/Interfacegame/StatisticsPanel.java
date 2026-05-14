package Interfacegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import core.Empire;

public class StatisticsPanel extends JPanel {

    public StatisticsPanel(Empire empire) {
        setLayout(new BorderLayout());
        setBackground(new Color(38, 45, 55));

        JLabel title = new JLabel("Estadísticas", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 34));
        title.setForeground(new Color(245, 200, 100));
        add(title, BorderLayout.NORTH);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 16));
        area.setBackground(new Color(25, 31, 38));
        area.setForeground(Color.WHITE);

        area.setText(
            "********** EMPIRE STATS **********\n\n" +
            "Recursos:\n" +
            "Comida: " + empire.getFood() + "\n" +
            "Madera: " + empire.getWood() + "\n" +
            "Hierro: " + empire.getIron() + "\n" +
            "Maná: " + empire.getMana() + "\n\n" +
            "Tecnología:\n" +
            "Ataque: 0\n" +
            "Defensa: 0\n\n" +
            "Edificios:\n" +
            "Granjas: 0\n" +
            "Carpinterías: 0\n" +
            "Herrerías: 0\n" +
            "Torres mágicas: 0\n" +
            "Iglesias: 0\n"
        );

        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}