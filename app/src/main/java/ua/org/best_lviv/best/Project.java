package ua.org.best_lviv.best;

/**
 * Created by Volodymyr on 29.01.2018.
 */

public class Project {
    private String name;
    private String description;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
