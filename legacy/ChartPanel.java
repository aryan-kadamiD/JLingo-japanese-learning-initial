import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class ChartPanel extends Panel {
    
    private JButton backButton;

    public ChartPanel(){
        setLayout(new BorderLayout());
        setBackground(new Color(245,250,255));

        JLabel title = new JLabel("Hiragana and Katakana", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        JTabbedPane tabPane = new JTabbedPane();
        tabPane.setFont(new Font("Arial", Font.PLAIN,18));

        // Hiragana Table
         String[] columns = {"Hiragana", "Romanji"};
        String[][] hiraData = {
            {"あ", "a"}, {"い", "i"}, {"う", "u"}, {"え", "e"}, {"お", "o"},
            {"か", "ka"}, {"き", "ki"}, {"く", "ku"}, {"け", "ke"}, {"こ", "ko"},
            {"さ", "sa"}, {"し", "shi"}, {"す", "su"}, {"せ", "se"}, {"そ", "so"},
            {"た", "ta"}, {"ち", "chi"}, {"つ", "tsu"}, {"て", "te"}, {"と", "to"},
            {"な", "na"}, {"に", "ni"}, {"ぬ", "nu"}, {"ね", "ne"}, {"の", "no"},
            {"は", "ha"}, {"ひ", "hi"}, {"ふ", "fu"}, {"へ", "he"}, {"ほ", "ho"},
            {"ま", "ma"}, {"み", "mi"}, {"む", "mu"}, {"め", "me"}, {"も", "mo"},
            {"や", "ya"}, {"ゆ", "yu"}, {"よ", "yo"},
            {"ら", "ra"}, {"り", "ri"}, {"る", "ru"}, {"れ", "re"}, {"ろ", "ro"},
            {"わ", "wa"}, {"を", "wo"}, {"ん", "n"}
        };
        JTable hiraTable = new JTable(hiraData, columns);
        styleKanaTable(hiraTable);
        tabPane.addTab("Hiragana", new JScrollPane(hiraTable));

        // Katakana Table
        String[][] kataData = {
            {"ア", "a"}, {"イ", "i"}, {"ウ", "u"}, {"エ", "e"}, {"オ", "o"},
            {"カ", "ka"}, {"キ", "ki"}, {"ク", "ku"}, {"ケ", "ke"}, {"コ", "ko"},
            {"サ", "sa"}, {"シ", "shi"}, {"ス", "su"}, {"セ", "se"}, {"ソ", "so"},
            {"タ", "ta"}, {"チ", "chi"}, {"ツ", "tsu"}, {"テ", "te"}, {"ト", "to"},
            {"ナ", "na"}, {"ニ", "ni"}, {"ヌ", "nu"}, {"ネ", "ne"}, {"ノ", "no"},
            {"ハ", "ha"}, {"ヒ", "hi"}, {"フ", "fu"}, {"ヘ", "he"}, {"ホ", "ho"},
            {"マ", "ma"}, {"ミ", "mi"}, {"ム", "mu"}, {"メ", "me"}, {"モ", "mo"},
            {"ヤ", "ya"}, {"ユ", "yu"}, {"ヨ", "yo"},
            {"ラ", "ra"}, {"リ", "ri"}, {"ル", "ru"}, {"レ", "re"}, {"ロ", "ro"},
            {"ワ", "wa"}, {"ヲ", "wo"}, {"ン", "n"}
        };

        JTable kataTable = new JTable(kataData, columns);
        styleKanaTable(kataTable);
        tabPane.addTab("Katakana", new JScrollPane(kataTable));

        add(tabPane, BorderLayout.CENTER);

        // ====== Bottom Panel (Back Button) ======
        JPanel bottomPanel = new JPanel();
        backButton = new JButton("Back");
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Reusable table styling
    private void styleKanaTable(JTable table) {
        table.setFont(new Font("MS Gothic", Font.PLAIN, 22)); // Supports Japanese text
        table.setRowHeight(30);
        table.setEnabled(false); // read-only
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
    }

     // To link with JLingo’s back button logic
    public void setBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}

