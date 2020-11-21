package com.bookapp.model;

import java.util.ArrayList;

public class LibroResponse {
    private Integer count;
    private String next,previus;
    private ArrayList<Libro> results;

    public LibroResponse(Integer count, String next, String previus, ArrayList<Libro> results) {
        this.count = count;
        this.next = next;
        this.previus = previus;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevius() {
        return previus;
    }

    public void setPrevius(String previus) {
        this.previus = previus;
    }

    public ArrayList<Libro> getResults() {
        return results;
    }

    public void setResults(ArrayList<Libro> results) {
        this.results = results;
    }
}
