package Multithread.User;

public class Bob extends User {

    public Bob() {

    }

    public Bob(String message) {
        super.setMessage(message);
        super.run();
    }

}
