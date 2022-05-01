package Multithread.User;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

abstract class User extends Thread implements Runnable {

    private final HashSet<SecretKey> keys = new HashSet<>();
    private List<String> message = new ArrayList<>();
    private String name;


    private String threadName;
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void message(User user, SecretKey sk) throws Exception {
        String message;
        if (user.keys.contains(sk)) {
            message = Cryptography.decrypt(this.message, sk);
        } else {
            message = this.message.toString();
        }
        // message box user -> message;
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

}
