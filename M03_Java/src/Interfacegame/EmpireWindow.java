package Interfacegame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import core.Empire;

public class EmpireWindow extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JTextArea logArea;

    private Empire empire;

    public EmpireWindow(Empire empire) {
        this.empire = empire;

        setTitle("Civilizations - M03");
        setSize(1280, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(8, 14, 18));

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setOpaque(false);

        createPanels();

        add(new MenuPanel(cardLayout, contentPanel), BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setBackground(new Color(20, 20, 20));
        logArea.setForeground(Color.WHITE);
        logArea.setRows(5);
        logArea.setText("Juego iniciado...\n");

        add(new JScrollPane(logArea), BorderLayout.SOUTH);
    }

    private void createPanels() {
        contentPanel.removeAll();

        contentPanel.add(new EmpirePanel(empire), "empire");
        contentPanel.add(new ResourcesPanel(empire), "resources");
        contentPanel.add(new BuildingsPanel(empire), "buildings");
        contentPanel.add(new ArmyPanel(empire), "army");
        contentPanel.add(new WarPanel(empire), "war");

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void refreshWindow() {
        createPanels();
    }

    public void addLog(String text) {
        logArea.append(text + "\n");
    }
}