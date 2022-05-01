package Generics;


public class Generic<T extends Number> {
    T[] objects;

    public Generic(T[] obj) {
        this.objects = obj.clone();
    }

    public double calculateAverage() {
        double average = 0;
        for (T o : objects) {
            average = average + o.doubleValue();
        }
        average = average/this.objects.length;
        return average;
    }

    public void displayAverage() {
        System.out.println(calculateAverage());
    }
}
