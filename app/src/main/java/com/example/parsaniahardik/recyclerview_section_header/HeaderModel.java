package com.example.parsaniahardik.recyclerview_section_header;

public class HeaderModel implements MainActivity.ListItem{

    String header;

    public void setheader(String header) {
        this.header = header;
    }

    @Override
    public boolean isHeader() {
        return true;
    }

    @Override
    public String getName() {
        return header;
    }
}
