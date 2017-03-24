package uk.co.gruar.moctracker;

/**
 * Created by Andrew on 17/03/2017.
 */

public class Track {
    private long id;
    private String name;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        // TODO: 19/03/2017 Setting up list needs sorting out
        return name + " " + description;
    }
}
