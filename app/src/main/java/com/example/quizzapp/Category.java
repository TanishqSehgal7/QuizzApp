package com.example.quizzapp;

public class Category {

    private String CategoryName;
    private int CategoryPhoto;

    public Category(){
    }

    public Category(String categoryName, int categoryPhoto) {
        CategoryName = categoryName;
        CategoryPhoto=categoryPhoto;
    }

    public int getCategoryPhoto() {
        return CategoryPhoto;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryPhoto(int categoryPhoto) {
        CategoryPhoto = categoryPhoto;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
