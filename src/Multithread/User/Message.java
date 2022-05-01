package Multithread.User;

import javax.crypto.SecretKey;
import javax.swing.*;

public abstract class Message {

    public void display(User user, String message, SecretKey sk) throws Exception {
        JOptionPane.showMessageDialog(null,
                Cryptography.decrypt(message, sk),
                user.getName() + " test",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
