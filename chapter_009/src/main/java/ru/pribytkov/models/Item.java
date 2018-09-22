package ru.pribytkov.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty("Number")
    private long id;

    @JsonProperty("Description")
    private String desc;

    @JsonProperty("Created")
    private boolean created;

    @JsonProperty("Done")
    private boolean done;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", created=" + created +
                ", done=" + done +
                '}';
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item(long id, String desc, boolean created, boolean done) {
        this.id = id;
        this.desc = desc;
        this.created = created;
        this.done = done;
    }


}
