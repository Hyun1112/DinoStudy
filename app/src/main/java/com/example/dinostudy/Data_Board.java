package com.example.dinostudy;

public class Data_Board {

    private String documentID;
    private String title;
    private String contents;
    private String category;
    private String date;

    public Data_Board() {
    }

    public Data_Board(String documentID, String title, String contents, String category) {
        this.documentID = documentID;
        this.title = title;
        this.contents = contents;
        this.category = category;
        this.date = date;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data_Board{" +
                "documentID='" + documentID + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
