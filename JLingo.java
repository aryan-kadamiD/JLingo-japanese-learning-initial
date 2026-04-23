import java.awt.*;
import java.awt.event.*;

// import javax.swing.*;

// Main JLingo 
public class JLingo extends Frame implements ActionListener {

    Button vocabBtn, chartBtn;
    Panel mainMenu;        // panel for main menu
    VocabPanel vocabPanel; 
    ChartPanel chartPanel;
    HeaderPanel headerPanel;

    CardLayout cardLayout;
    Panel mainContainer;   // container to switch between panels

    public JLingo() {
        setTitle("JLingo - Japanese Learning Tool");
        setSize(600, 300);
        setLayout(new BorderLayout());

        // header
        headerPanel = new HeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        // Container to switch panels
        cardLayout = new CardLayout();
        mainContainer = new Panel();
        mainContainer.setLayout(cardLayout);

        // ===== Main Menu Panel =====
        mainMenu = new Panel();
        mainMenu.setBackground(new Color(240, 248, 255));
        mainMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));

        vocabBtn = new Button("Vocabulary Section");
        vocabBtn.setFont(new Font("Arial",Font.PLAIN,20));
        chartBtn = new Button("Hiragana-Katakana Chart");
        chartBtn.setFont(new Font("Arial", Font.PLAIN, 20));

        mainMenu.add(vocabBtn);
        mainMenu.add(chartBtn);

        vocabBtn.addActionListener(this);
        chartBtn.addActionListener(this);

        // Vocabulary Panel
        vocabPanel = new VocabPanel();
        // Chart Panel
        chartPanel = new ChartPanel();

        // Back button setting
        vocabPanel.setBackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainContainer, "Menu"); // return to main menu
            }
        });
        chartPanel.setBackButtonListener(e -> cardLayout.show(mainContainer, "Menu"));


        // Add panels to container
        mainContainer.add(mainMenu, "Menu");
        mainContainer.add(vocabPanel, "Vocab");
        mainContainer.add(chartPanel, "Chart");

        add(mainContainer, BorderLayout.CENTER);

        // Window closing logic
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vocabBtn) {
            cardLayout.show(mainContainer, "Vocab"); // show vocabulary panel
        } else if (e.getSource() == chartBtn) {
            cardLayout.show(mainContainer, "Chart");
        }
    }

    public static void main(String[] args) {
        new JLingo();
    }
}
