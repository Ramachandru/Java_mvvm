package com.ramachandran.articleapp.model;

import java.util.List;

public class Response {
    private String numFound;
    private String maxScore;
    private List<Document> docs;
    public void setNumFound(String numFound) {
        this.numFound = numFound;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    public String getNumFound() {
        return numFound;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public List<Document> getDocs() {
        return docs;
    }
}
