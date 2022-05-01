package Multithread.User;

public class Chase extends User {

    public Chase() {

    }
    public Chase(String message) {
        super.setMessage(message);
        super.run();
    }
}
