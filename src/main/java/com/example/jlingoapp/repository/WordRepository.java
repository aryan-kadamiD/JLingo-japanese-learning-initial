package com.example.jlingoapp.repository;

import com.example.jlingoapp.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    // Spring generates all the standard methods (save, findAll, delete) automatically!

    // Custom search: Spring will actually write the logic for this just based on the name!
    List<Word> findByCategory(String category);
}