package Interfacegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.Empire;

public class ResourcesPanel extends JPanel {

    private Empire empire;

    private JLabel foodLabel;
    private JLabel woodLabel;
    private JLabel ironLabel;
    private JLabel manaLabel;

    public ResourcesPanel(Empire empire) {
        this.empire = empire;

        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(12, 21, 27));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("RECURSOS DEL REINO", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 42));
        title.setForeground(new Color(255, 210, 90));
        add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(2, 2, 20, 20));
        grid.setBackground(new Color(12, 21, 27));

        foodLabel = new JLabel();
        woodLabel = new JLabel();
        ironLabel = new JLabel();
        manaLabel = new JLabel();

        grid.add(resource("Comida", foodLabel, "/images/food.png"));
        grid.add(resource("Madera", woodLabel, "/images/wood.png"));
        grid.add(resource("Hierro", ironLabel, "/images/iron.png"));
        grid.add(resource("Maná", manaLabel, "/images/mana.png"));

        add(grid, BorderLayout.CENTER);

        refresh();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                refresh();
            }
        });
    }

    public void refresh() {
        foodLabel.setText(String.valueOf(empire.getFood()));
        woodLabel.setText(String.valueOf(empire.getWood()));
        ironLabel.setText(String.valueOf(empire.getIron()));
        manaLabel.setText(String.valueOf(empire.getMana()));
    }

    private JPanel resource(String name, JLabel amountLabel, String image) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(32, 25, 17));
        panel.setBorder(BorderFactory.createLineBorder(new Color(200, 135, 45), 3));

        JLabel title = new JLabel(name, SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 26));
        title.setForeground(new Color(255, 210, 90));

        JLabel icon = new JLabel(loadIcon(image), SwingConstants.CENTER);

        amountLabel.setFont(new Font("Arial", Font.BOLD, 32));
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(title, BorderLayout.NORTH);
        panel.add(icon, BorderLayout.CENTER);
        panel.add(amountLabel, BorderLayout.SOUTH);

        return panel;
    }

    private ImageIcon loadIcon(String path) {
        URL url = getClass().getResource(path);

        if (url == null) {
            System.out.println("No se encontró: " + path);
            return null;
        }

        Image img = new ImageIcon(url).getImage();
        Image resized = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        return new ImageIcon(resized);
    }
}