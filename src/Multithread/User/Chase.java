package Multithread.User;

public class Chase extends User {

    public Chase() {
        super.setUserName("Chase");
    }
    public Chase(String message) {
        super.setMessage(message);
        super.run();
    }
}
