package com.virna.projectfirebase;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Title {
    private String key, title, notes;

    public Title() {
    }

    public Title(String key, String title, String notes) {
        this.key = key;
        this.title = title;
        this.notes = notes;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
