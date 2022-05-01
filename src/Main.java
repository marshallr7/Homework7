import Generics.Generic;
import Multithread.User.Alice;
import Multithread.User.Bob;
import Multithread.User.Chase;


public class Main {

    public static void main(String[] args) throws Exception {
        Bob bob = new Bob();
        Chase chase = new Chase();
        Alice alice = new Alice("We have a meeting tomorrow at 8 am", bob);
//        Alice alice1 = new Alice("Tomorrow meeting will be held in room 100", chase);
//        alice.start();
//        alice1.start();

        Integer[] arr = {100, 1000};
        Generic<Integer> g = new Generic<>(arr);
        g.displayAverage();
        Double[] arr2 = {100.5, 1000.7};
        Generic<Double> d = new Generic<>(arr2);
        d.displayAverage();
    }
}
