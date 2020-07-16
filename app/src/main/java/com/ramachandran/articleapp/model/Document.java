package com.ramachandran.articleapp.model;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private String id;
    private String journal;
    private String eissn;
    private String publication_date;
    private String article_type;
    private String title_display;
    private List<String> author_display;
    private String score;

    public List<String> getAuthor_display() {
        return author_display;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEissn() {
        return eissn;
    }

    public void setEissn(String eissn) {
        this.eissn = eissn;
    }

    public void setAuthor_display(List<String> author_display) {
        this.author_display = author_display;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public String getScore() {
        return score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getJournal() {
        return journal;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setTitle_display(String title_display) {
        this.title_display = title_display;
    }

    public String getTitle_display() {
        return title_display;
    }
}
