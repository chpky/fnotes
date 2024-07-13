package com.chpky.fnotes.repository;

import com.chpky.fnotes.model.User;
import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUserRepository implements UserRepository {
    private final Path path;

    public FileUserRepository(Path path) {
        this.path = path;
    }

    @Override
    public List<User> findAll() throws Exception {
        List<String[]> users;
        try (
                InputStream is = Files.newInputStream(path);
                CSVReader reader = new CSVReader(new InputStreamReader(is))
        ) {
            users = reader.readAll();
        }
        return users.stream()
                .map(array -> new User(array[0], array[1], array[2],array[3]))
                .toList();
    }
}
