package Multithread.User;

import javax.crypto.SecretKey;

public class Box extends Message {

    int n;
    boolean valueSet = false;

    public Box(User user, String message, SecretKey sk) throws Exception {
        super.display(user, message, sk);
    }

    synchronized int get() {
        while(!valueSet)
            try {
                System.out.println("Wait Got: ");
                wait();

            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet)
            try {
                System.out.println("Wait Put: ");
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}
