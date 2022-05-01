package Multithread.User;

import javax.crypto.SecretKey;

public class Alice extends User {

    public Alice(String message, User user) throws Exception {
        super.setUserName("Alice");
        SecretKey sk = Key.generateKey(128);
        super.addKey(sk);
        user.addKey(sk);

        super.setMessage(message);

        super.fixArray();

        super.setMessage(Cryptography.encrypt(super.getFixedMessage(), sk));

        super.message(user, sk);

        super.run();
    }
}
