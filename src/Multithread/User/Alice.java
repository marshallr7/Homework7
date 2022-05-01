package Multithread.User;

import javax.crypto.SecretKey;

public class Alice extends User {

    public Alice(String message, User user) throws Exception {
        SecretKey sk = Key.generateKey(128);
        super.addKey(sk);
        user.addKey(sk);

        super.setMessage(message);
        super.setMessage(Cryptography.encrypt(super.getMessage(), sk));

        Box boxAB = new Box();
//        boxAB.put(super.getMessage());
        boxAB.get(super.getMessage(), user, sk);

        super.run();
    }
}
