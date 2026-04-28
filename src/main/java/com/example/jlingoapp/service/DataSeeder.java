package com.example.jlingoapp.service;

import com.example.jlingoapp.model.Word;
import com.example.jlingoapp.repository.WordRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final WordRepository wordRepository;
    private final ObjectMapper objectMapper;

    public DataSeeder(WordRepository wordRepository, ObjectMapper objectMapper) {
        this.wordRepository = wordRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (wordRepository.count() == 0) {
            System.out.println("🌱 Database is empty. Seeding from words.json...");

            try (InputStream inputStream = getClass().getResourceAsStream("/words.json")) {
                List<Word> words = objectMapper.readValue(inputStream, new TypeReference<List<Word>>(){});
                wordRepository.saveAll(words);
                System.out.println("✅ Successfully seeded " + words.size() + " words!");
            } catch (Exception e) {
                System.out.println("❌ Error seeding data: " + e.getMessage());
            }
        } else {
            System.out.println("✨ Database already contains data. Skipping seed.");
        }
    } // <-- This closes the run method
} // <-- This closes the class