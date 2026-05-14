package Interfacegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.Empire;

public class EmpirePanel extends JPanel {

    private Empire empire;
    private Image background;

    private JLabel foodLabel;
    private JLabel woodLabel;
    private JLabel ironLabel;
    private JLabel manaLabel;
    private JLabel buildingsLabel;
    private JLabel unitsLabel;

    public EmpirePanel(Empire empire) {
        this.empire = empire;
        background = loadImage("/images/game_background.jpg");

        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("CIVILIZATIONS", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 52));
        title.setForeground(new Color(255, 210, 90));
        title.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(2, 3, 18, 18));
        grid.setOpaque(false);

        foodLabel = new JLabel();
        woodLabel = new JLabel();
        ironLabel = new JLabel();
        manaLabel = new JLabel();
        buildingsLabel = new JLabel();
        unitsLabel = new JLabel();

        grid.add(resourceCard("COMIDA", foodLabel, "/images/food.png"));
        grid.add(resourceCard("MADERA", woodLabel, "/images/wood.png"));
        grid.add(resourceCard("HIERRO", ironLabel, "/images/iron.png"));
        grid.add(resourceCard("MANÁ", manaLabel, "/images/mana.png"));
        grid.add(infoCard("EDIFICIOS", buildingsLabel, "/images/farm.png"));
        grid.add(infoCard("EJÉRCITO", unitsLabel, "/images/sword.png"));

        add(grid, BorderLayout.CENTER);

        refresh();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                refresh();
            }
        });
    }

    public void refresh() {
        foodLabel.setText(String.valueOf(empire.getFood()));
        woodLabel.setText(String.valueOf(empire.getWood()));
        ironLabel.setText(String.valueOf(empire.getIron()));
        manaLabel.setText(String.valueOf(empire.getMana()));

        buildingsLabel.setText(
            "<html><center>" +
            "Granjas: " + empire.getFarms() + "<br>" +
            "Carpinterías: " + empire.getCarpentries() + "<br>" +
            "Herrerías: " + empire.getSmithies() + "<br>" +
            "Torres mágicas: " + empire.getMagicTowers() + "<br>" +
            "Iglesias: " + empire.getChurches() +
            "</center></html>"
        );

        unitsLabel.setText(
            "<html><center>" +
            "Espadachines: " + empire.getSwordsmen() + "<br>" +
            "Lanceros: " + empire.getSpearmen() + "<br>" +
            "Ballestas: " + empire.getCrossbows() + "<br>" +
            "Cañones: " + empire.getCannons() + "<br>" +
            "Magos: " + empire.getMagicians() +
            "</center></html>"
        );

        repaint();
        revalidate();
    }

    private JPanel resourceCard(String title, JLabel valueLabel, String imagePath) {
        JPanel panel = baseCard();

        JLabel titleLabel = title(title);
        JLabel icon = new JLabel(loadIcon(imagePath, 90, 90), SwingConstants.CENTER);

        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 34));
        valueLabel.setForeground(Color.WHITE);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(icon, BorderLayout.CENTER);
        panel.add(valueLabel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel infoCard(String title, JLabel textLabel, String imagePath) {
        JPanel panel = baseCard();

        JLabel titleLabel = title(title);
        JLabel icon = new JLabel(loadIcon(imagePath, 65, 65), SwingConstants.CENTER);

        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 17));
        textLabel.setForeground(Color.WHITE);

        JPanel center = new JPanel(new BorderLayout());
        center.setOpaque(false);
        center.add(icon, BorderLayout.NORTH);
        center.add(textLabel, BorderLayout.CENTER);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);

        return panel;
    }

    private JPanel baseCard() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBackground(new Color(15, 15, 12, 220));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 137, 35), 3),
            BorderFactory.createEmptyBorder(14, 14, 14, 14)
        ));
        return panel;
    }

    private JLabel title(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 25));
        label.setForeground(new Color(255, 210, 90));
        return label;
    }

    private ImageIcon loadIcon(String path, int width, int height) {
        URL url = getClass().getResource(path);
        if (url == null) return null;

        Image img = new ImageIcon(url).getImage();
        Image resized = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resized);
    }

    private Image loadImage(String path) {
        URL url = getClass().getResource(path);
        if (url == null) return null;
        return new ImageIcon(url).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }

        g.setColor(new Color(0, 0, 0, 120));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}