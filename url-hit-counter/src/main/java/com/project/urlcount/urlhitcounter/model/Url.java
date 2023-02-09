package com.project.urlcount.urlhitcounter.model;

public class Url {
    private int Count;


    public Url(int Count) {
        this.Count = Count;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int gCount) {
        this.Count = gCount;
    }

    @Override
    public String toString() {
        return "Url{" +
                "Count=" + Count +
                '}';
    }
}
