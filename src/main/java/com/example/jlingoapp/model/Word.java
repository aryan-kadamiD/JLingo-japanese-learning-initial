package com.example.jlingoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "words") // Naming the table in H2
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kanji;     // Added based on your goal
    private String hiragana;
    private String romaji;
    private String english;

    private String category;  // e.g., "Food", "Adjectives"
    private String type;      // e.g., "Verb", "Noun"
    private int level;        // e.g., 5 for N5, 4 for N4

    // Default Constructor (Required by JPA)
    public Word() {}

    // Full Constructor for easy creation
    public Word(String kanji, String hiragana, String romaji, String english, String category, String type, int level) {
        this.kanji = kanji;
        this.hiragana = hiragana;
        this.romaji = romaji;
        this.english = english;
        this.category = category;
        this.type = type;
        this.level = level;
    }

    // Getters and Setters (Important for Spring to read/write data)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKanji() { return kanji; }
    public void setKanji(String kanji) { this.kanji = kanji; }

    public String getHiragana() { return hiragana; }
    public void setHiragana(String hiragana) { this.hiragana = hiragana; }

    public String getRomaji() { return romaji; }
    public void setRomaji(String romaji) { this.romaji = romaji; }

    public String getEnglish() { return english; }
    public void setEnglish(String english) { this.english = english; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}