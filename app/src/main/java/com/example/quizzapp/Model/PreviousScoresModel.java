package com.example.quizzapp.Model;

public class PreviousScoresModel {
    private String CategoryName;
//    private int CategoryPhotoForScores;
    private String PreviousScore;


    public PreviousScoresModel(){
    }

    public PreviousScoresModel(String CategoryName, String PreviousScore){
        this.CategoryName=CategoryName;
        this.PreviousScore=PreviousScore;

    }

    public String getPreviousScore() {
        return PreviousScore;
    }

    public void setPreviousScore(String previousScore) {
        PreviousScore = previousScore;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryName() {
        return CategoryName;
    }
}


