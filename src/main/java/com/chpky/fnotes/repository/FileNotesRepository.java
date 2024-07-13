package com.chpky.fnotes.repository;

import com.chpky.fnotes.model.User;
import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileNotesRepository implements NotesRepository {
    private final Path path;

    public FileNotesRepository(Path path) {
        this.path = path;
    }

    @Override
    public void saveNote(String newNote, String id) throws Exception {
        Files.writeString(path, id + "," + newNote + "\n", StandardOpenOption.APPEND);

    }

    @Override
    public List<String> getNoteContent(User user) throws Exception {
        List<String[]> notes;
        try (
                InputStream is = Files.newInputStream(path);
                CSVReader reader = new CSVReader(new InputStreamReader(is))
        ) {
            notes = reader.readAll();
        }
        List<String> finedFamilyList = Arrays.asList(user.getFamily().split("\\|"));
        return notes
                .stream()
                .filter(array -> finedFamilyList.contains(array[0]))
                .map(array -> array[1])
                .toList();
    }
}
