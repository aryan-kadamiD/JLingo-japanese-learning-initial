package com.example.jlingoapp.controller;

import com.example.jlingoapp.model.Word;
import com.example.jlingoapp.repository.WordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
@CrossOrigin(origins = "*") // Allows your HTML to talk to your Java server
public class WordController {

    private final WordRepository wordRepository;

    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Word> getWordsByCategory(@PathVariable String category) {
        return wordRepository.findByCategory(category);
    }

    @PostMapping
    public Word addWord(@RequestBody Word newWord) {
        return wordRepository.save(newWord);
    }
}