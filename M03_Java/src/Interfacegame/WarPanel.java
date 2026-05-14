package Interfacegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.DatabaseManager;
import core.Empire;

public class WarPanel extends JPanel {

    private Empire empire;
    private Random random = new Random();

    private int battleNumber = 0;

    private int enemyUnits = 34;
    private int enemyAttack = 2100;
    private int enemyDefense = 2700;

    private JLabel yourInfo;
    private JLabel enemyInfo;
    private JLabel result;

    public WarPanel(Empire empire) {
        this.empire = empire;

        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(12, 21, 27));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("BATALLA", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 42));
        title.setForeground(new Color(255, 210, 90));
        add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(1, 3, 20, 20));
        center.setBackground(new Color(12, 21, 27));

        yourInfo = new JLabel("", SwingConstants.CENTER);
        enemyInfo = new JLabel("", SwingConstants.CENTER);

        center.add(team("TU EJÉRCITO", yourInfo, new Color(25, 60, 100)));
        center.add(vsPanel());
        center.add(team("ENEMIGO", enemyInfo, new Color(110, 30, 30)));

        add(center, BorderLayout.CENTER);

        result = new JLabel("Prepara tu ejército y pulsa iniciar batalla", SwingConstants.CENTER);
        result.setFont(new Font("Serif", Font.BOLD, 26));
        result.setForeground(Color.WHITE);

        JButton button = new JButton("INICIAR BATALLA");
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(100, 70, 25));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(e -> startBattle());

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(new Color(32, 25, 17));
        bottom.setBorder(BorderFactory.createLineBorder(new Color(200, 135, 45), 3));
        bottom.add(result, BorderLayout.CENTER);
        bottom.add(button, BorderLayout.SOUTH);

        add(bottom, BorderLayout.SOUTH);

        refresh();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {
                refresh();
            }
        });
    }

    private void startBattle() {
        refresh();

        battleNumber++;

        int yourUnits = empire.getTotalUnits();
        int yourAttack = empire.getTotalAttack();
        int yourDefense = empire.getTotalDefense();

        if (yourUnits <= 0) {
            result.setText("No tienes unidades. Crea ejército antes de luchar.");
            return;
        }

        int yourPower = yourAttack + yourDefense + random.nextInt(800);
        int enemyPower = enemyAttack + enemyDefense + random.nextInt(800);

        empire.loseUnitsAfterBattle();

        int woodReward = 0;
        int ironReward = 0;

        if (yourPower >= enemyPower) {
            woodReward = 800 + random.nextInt(700);
            ironReward = 400 + random.nextInt(500);

            empire.addBattleReward(woodReward, ironReward);

            result.setText(
                "Batalla " + battleNumber +
                " - ¡VICTORIA! +" + woodReward +
                " madera, +" + ironReward + " hierro"
            );

            DatabaseManager.saveEmpire(empire);
            DatabaseManager.saveBattle("Civilization", result.getText(), woodReward, ironReward);
        } else {
            result.setText(
                "Batalla " + battleNumber +
                " - Derrota. Has perdido unidades."
            );

            DatabaseManager.saveEmpire(empire);
            DatabaseManager.saveBattle("Enemy", result.getText(), 0, 0);
        }

        enemyUnits += 5;
        enemyAttack += 350;
        enemyDefense += 300;

        refresh();
    }

    private void refresh() {
        yourInfo.setText(
            "<html><center>" +
            "Unidades: " + empire.getTotalUnits() + "<br>" +
            "Ataque: " + empire.getTotalAttack() + "<br>" +
            "Defensa: " + empire.getTotalDefense() +
            "</center></html>"
        );

        enemyInfo.setText(
            "<html><center>" +
            "Unidades: " + enemyUnits + "<br>" +
            "Ataque: " + enemyAttack + "<br>" +
            "Defensa: " + enemyDefense +
            "</center></html>"
        );

        repaint();
        revalidate();
    }

    private JPanel team(String title, JLabel info, Color color) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(color);
        panel.setBorder(BorderFactory.createLineBorder(new Color(200, 135, 45), 3));

        JLabel t = new JLabel(title, SwingConstants.CENTER);
        t.setFont(new Font("Serif", Font.BOLD, 26));
        t.setForeground(new Color(255, 210, 90));

        info.setFont(new Font("Arial", Font.BOLD, 22));
        info.setForeground(Color.WHITE);

        panel.add(t, BorderLayout.NORTH);
        panel.add(info, BorderLayout.CENTER);

        return panel;
    }

    private JPanel vsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(12, 21, 27));

        JLabel swords = new JLabel("⚔", SwingConstants.CENTER);
        swords.setFont(new Font("Serif", Font.BOLD, 95));
        swords.setForeground(Color.WHITE);

        JLabel vs = new JLabel("VS", SwingConstants.CENTER);
        vs.setFont(new Font("Arial", Font.BOLD, 30));
        vs.setForeground(new Color(255, 210, 90));

        panel.add(swords, BorderLayout.CENTER);
        panel.add(vs, BorderLayout.SOUTH);

        return panel;
    }
}