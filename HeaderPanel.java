import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HeaderPanel extends Panel{
    JLabel logoLabel;
    Label logoTitle;

    public HeaderPanel()
    {
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        setBackground(new Color(200,230,250));

        logoTitle = new Label("JLingo-Japanese Learning Tool");
        logoTitle.setFont(new Font("Arial",Font.BOLD,30));

        ImageIcon logo = new ImageIcon("JLingoLogo.png");
        Image scaledImage = logo.getImage().getScaledInstance(800, 350,Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaledImage);
        logoLabel = new JLabel(scaledLogo);

        add(logoLabel);
        add(logoTitle);
    }

}