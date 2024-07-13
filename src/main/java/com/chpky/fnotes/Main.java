package com.chpky.fnotes;

import com.chpky.fnotes.front.Front;
import com.chpky.fnotes.front.LoginFront;
import com.chpky.fnotes.front.NotesFront;
import com.chpky.fnotes.front.session.UserSession;
import com.chpky.fnotes.repository.FileNotesRepository;
import com.chpky.fnotes.repository.FileUserRepository;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        new Front(
               new LoginFront(
                       new FileUserRepository(
                               Path.of("users.csv")
                       )
               ),
                new NotesFront(
                        new FileNotesRepository(
                                Path.of("notes.csv")
                        )
                )
        ).start(UserSession.INSTANCE);
    }
}