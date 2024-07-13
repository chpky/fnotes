package com.chpky.fnotes.front;

import com.chpky.fnotes.front.session.UserSession;
import com.chpky.fnotes.model.User;
import com.chpky.fnotes.repository.UserRepository;

import javax.swing.*;
import java.util.NoSuchElementException;

public class LoginFront implements FtBase {
    private final UserRepository userRepository;

    public LoginFront(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void start(UserSession session) throws Exception {
        String username = JOptionPane.showInputDialog("Username:");
        String password = JOptionPane.showInputDialog("Password:");
        User user = null;
        try {
            user = userRepository.findAll()
                    .stream()
                    .filter(u -> u.IsSameUser(username, password))
                    .findFirst()
                    .orElseThrow();
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
            start(session);
        }
        session.setUser(user);
    }
}
