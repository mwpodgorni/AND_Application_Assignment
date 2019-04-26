package com.example.myproject.Stories.model;

public class Story {
    private String mName;
    private int mIconId;
    private Page[]pages;

    public Story(String name, int iconId) {
        pages = new Page[7];
        mName = name;
        mIconId = iconId;
    }
    public void setPage(int pageNumber, Page page){
        pages[pageNumber]=page;
    }
    public Page getPage(int pageNumber) {
        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }
    public String getName() {
        return mName;
    }
    public int getIconId() {
        return mIconId;
    }
}
