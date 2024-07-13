package com.chpky.fnotes.repository;

import com.chpky.fnotes.model.User;

import java.util.List;

public interface NotesRepository {
    void saveNote(String note, String username) throws Exception;
    List<String> getNoteContent(User user) throws Exception;
}
