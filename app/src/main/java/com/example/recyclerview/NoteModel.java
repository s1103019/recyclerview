package com.example.recyclerview;

public class NoteModel {
    private final String title;
    private final String detail;
    public NoteModel(String title, String detail) {
        this.title = title;this.detail = detail;
    }
    public String getTitle() {return title;
    }
    public String getDetail() {return detail;}
}