package ua.org.best_lviv.best;

/**
 * Created by Volodymyr on 29.01.2018.
 */

public class Person {
    private String name;
    private String number;

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
