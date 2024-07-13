package com.chpky.fnotes.front;

import com.chpky.fnotes.front.session.UserSession;
import com.chpky.fnotes.repository.NotesRepository;

import javax.swing.*;
import java.util.List;

public class NotesFront implements FtBase {
    private final NotesRepository notesRepository;

    public NotesFront(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public void start(UserSession userSession) throws Exception {
        List<String> noteContent = notesRepository.getNoteContent(userSession.getUser());
        JOptionPane.showMessageDialog(null, noteContent.toString(), "Old Notes: ", JOptionPane.INFORMATION_MESSAGE);

        String note = JOptionPane.showInputDialog("Enter new note:");
        if (note != null && !note.isEmpty()) {
            notesRepository.saveNote(note, userSession.getUser().getId());
        }
    }
}
