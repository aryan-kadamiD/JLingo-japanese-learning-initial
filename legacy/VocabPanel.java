import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.awt.Font;

public class VocabPanel extends Panel implements ActionListener {

    private final String fileName = "vocabulary.txt"; // file to save/load

    Label wordLabel, meaningLabel;
    TextField wordField, meaningField;
    Button addBtn, updateBtn, deleteBtn, saveBtn, backBtn;
    List vocabList;
    ActionListener backListener;

    public VocabPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 255, 250));

        // Top Panel: input fields
        Panel inputPanel = new Panel(new GridLayout(2, 2, 10, 10));
        wordLabel = new Label("Word:");
            wordLabel.setFont(new Font("MS Gothic", Font.PLAIN, 20));
        wordField = new TextField(20);
            wordField.setFont(new Font("MS_Gothic", Font.PLAIN, 20));
        meaningLabel = new Label("Meaning:");
            meaningLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        meaningField = new TextField(20);
            meaningField.setFont(new Font("MS_Gothic", Font.PLAIN, 20));

        inputPanel.add(wordLabel);
        inputPanel.add(wordField);
        inputPanel.add(meaningLabel);
        inputPanel.add(meaningField);

        add(inputPanel, BorderLayout.NORTH);

        // Center Panel: list of words
        vocabList = new List();
            vocabList.setFont(new Font("MS Gothic", Font.PLAIN, 18));
        add(vocabList, BorderLayout.CENTER);

        // Bottom Panel: action buttons
        Panel buttonPanel = new Panel(new FlowLayout());
        addBtn = new Button("Add");
                addBtn.setFont(new Font("MS Gothic", Font.BOLD, 20));
        updateBtn = new Button("Update");
                updateBtn.setFont(new Font("MS Gothic", Font.BOLD, 20));
        deleteBtn = new Button("Delete");
                deleteBtn.setFont(new Font("MS Gothic", Font.BOLD, 20));
        saveBtn = new Button("Save");
                saveBtn.setFont(new Font("MS Gothic", Font.BOLD, 20));
        backBtn = new Button("Back");
                backBtn.setFont(new Font("MS Gothic", Font.BOLD, 20));

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(saveBtn);
        buttonPanel.add(backBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button listeners
        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        backBtn.addActionListener(this);

        // Load vocabulary at startup
        loadVocabulary();
    }

    public void setBackButtonListener(ActionListener listener) {
        this.backListener = listener;
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBtn) {      // Add btn
            String word = wordField.getText().trim();
            String meaning = meaningField.getText().trim();
            if (!word.isEmpty() && !meaning.isEmpty()) {
                vocabList.add(word + " - " + meaning);
                wordField.setText("");
                meaningField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter both word and meaning.");
            }
        } else if (e.getSource() == updateBtn) {        //update btn
            int index = vocabList.getSelectedIndex();
            if (index != -1) {
                String word = wordField.getText().trim();
                String meaning = meaningField.getText().trim();
                if (!word.isEmpty() && !meaning.isEmpty()) {
                    vocabList.replaceItem(word + " - " + meaning, index);
                    wordField.setText("");
                    meaningField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both word and meaning.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select a word to update.");
            }
        } else if (e.getSource() == deleteBtn) {        //for delete btn
            int index = vocabList.getSelectedIndex();
            if (index != -1) {
                vocabList.remove(index);
            } else {
                JOptionPane.showMessageDialog(null, "Select a word to delete.");
            }
        } else if (e.getSource() == saveBtn) {
            saveVocabulary();
        } else if (e.getSource() == backBtn && backListener != null) {
            backListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Back"));
        }
    }

    // Load vocabulary from file
    private void loadVocabulary() {
        File file = new File(fileName);
        if (!file.exists()) return;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    vocabList.add(line);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading vocabulary: " + ex.getMessage());
        }
    }

    // Save vocabulary to file
    private void saveVocabulary() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String item : vocabList.getItems()) {
                writer.println(item);
            }
            JOptionPane.showMessageDialog(null, "Vocabulary saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving vocabulary: " + ex.getMessage());
        }
    }
}
