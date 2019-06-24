package com.example.parsaniahardik.recyclerview_section_header;

public class ChildModel implements MainActivity.ListItem{

    String child;

    public void setChild(String child) {
        this.child = child;
    }

    @Override
    public boolean isHeader() {
        return false;
    }

    @Override
    public String getName() {
        return child;
    }
}
