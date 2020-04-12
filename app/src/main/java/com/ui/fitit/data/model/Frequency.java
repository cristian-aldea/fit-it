package com.ui.fitit.data.model;

import androidx.annotation.NonNull;

public enum Frequency {

    ONCE("Once"),
    DAILY("Daily"),
    WEEKLY("Weekly");

    private final String name;

    Frequency(String s) {
        name = s;
    }

    @NonNull
    public String toString() {
        return this.name;
    }
}
