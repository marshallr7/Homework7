package Multithread.User;

import javax.crypto.SecretKey;

public class Alice extends User {

    public Alice(String message, User user) throws Exception {
        SecretKey sk = Key.generateKey(128);
        super.addKey(sk);
        user.addKey(sk);

        super.setMessage(message);

        super.fixArray();
        System.out.println(super.getFixedMessage());
        super.setMessage(Cryptography.encrypt(super.getFixedMessage(), sk));
        System.out.println(super.getFixedMessage());

        super.message(user, sk);

        super.run();
    }
}
