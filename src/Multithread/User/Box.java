package Multithread.User;

import javax.crypto.SecretKey;
import javax.swing.*;
import java.util.List;

public class Box {

    public synchronized void get(List<String> message, User user, SecretKey sk) throws Exception {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < message.size(); i++) {
            if (i % 2 == 0) {
                s1.append(message.get(i));
            } else {
                s2.append(message.get(i));
            }
        }

            JOptionPane.showMessageDialog(null,
                    Cryptography.decrypt(s1.toString(), sk),
                    user.getName(),
                    JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                Cryptography.decrypt(s2.toString(), sk),
                user.getName(),
                JOptionPane.INFORMATION_MESSAGE);
    }

    public synchronized void put() {

    }
}
