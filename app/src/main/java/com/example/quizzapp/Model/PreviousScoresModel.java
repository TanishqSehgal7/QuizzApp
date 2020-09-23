package com.example.quizzapp.Model;

public class PreviousScoresModel {
    private String CategoryNameForScores;
//    private int CategoryPhotoForScores;
    private String PreviousScore;


    public PreviousScoresModel(){
    }

    public PreviousScoresModel(String categoryNameForScores,String previousScore){
        CategoryNameForScores=categoryNameForScores;
//        CategoryPhotoForScores=categoryPhotoForScores;
        PreviousScore=previousScore;
    }

    public String getPreviousScore() {
        return PreviousScore;
    }

    public void setPreviousScore(String previousScore) {
        PreviousScore = previousScore;
    }

//    public int getCategoryPhoto() {
//        return CategoryPhotoForScores;
//    }
//
//    public void setCategoryPhoto(int categoryPhoto) {
//        CategoryPhotoForScores = categoryPhoto;
//    }

    public String getCategoryNameForScores() {
        return CategoryNameForScores;
    }

    public void setCategoryNameForScores(String categoryName) {
        CategoryNameForScores = categoryName;
    }
}
