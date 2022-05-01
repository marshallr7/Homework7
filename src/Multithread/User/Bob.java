package Multithread.User;

public class Bob extends User {

    public Bob() {
        super.setUserName("Bob");
    }

    public Bob(String message) {
        super.setMessage(message);
        super.run();
    }

}
