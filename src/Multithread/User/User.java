package Multithread.User;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

abstract class User extends Thread implements Runnable {

    private final HashSet<SecretKey> keys = new HashSet<>();
    private List<String> message = new ArrayList<>();
    private List<String> fixedMessage = new ArrayList<>();
    private String name;


    public void run() {
        try {
            for(int i = 2; i > 0; i--) {

                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + " interrupted.");
        }
    }

    public void message(User user, SecretKey sk) throws Exception {
        String message;
        if (user.keys.contains(sk)) {
            message = Cryptography.decrypt(this.message, sk);
        } else {
            message = this.message.toString();
        }
        // message box user -> message;
        for (String word : this.fixedMessage) {
            Box boxab = new Box(user, word, sk);

        }

    }

    public void setMessage(String message) {
        this.message = List.of(message.split(" "));
    }

    public List<String> getMessage() {
        return message;
    }

    public void addKey(SecretKey s) {
        keys.add(s);
    }

    public HashSet<SecretKey> getKeys() {
        return this.keys;
    }

    public void fixArray() {
        for (int i = 0; i < this.message.size()-1; i++) {
            String s1 = this.message.get(i);
            String s2 = this.message.get(i+1);
            i++;

            fixedMessage.add(s1+ s2);
            System.out.println(s1+s2);
        }
    }

    public List<String> getFixedMessage() {
        return fixedMessage;
    }
}
