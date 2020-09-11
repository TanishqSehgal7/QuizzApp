package com.example.quizzapp.Model;

public class QuestionModel {

    public String Question,Opt1,Opt2,Opt3,Opt4,CorrectAns;

    public QuestionModel(String question,String opt1,String opt2,String opt3,String opt4,String correctAns) {
        this.Question=question;
        this.Opt1=opt1;
        this.Opt2=opt2;
        this.Opt3=opt3;
        this.Opt4=opt4;
        this.CorrectAns=correctAns;
    }

    public String getCorrectAns() {
        return CorrectAns;
    }

    public void setCorrectAns(String correctAns) {
        CorrectAns = correctAns;
    }

    public String getOpt4() {
        return Opt4;
    }

    public void setOpt4(String opt4) {
        Opt4 = opt4;
    }

    public String getOpt3() {
        return Opt3;
    }

    public void setOpt3(String opt3) {
        Opt3 = opt3;
    }

    public String getOpt2() {
        return Opt2;
    }

    public void setOpt2(String opt2) {
        Opt2 = opt2;
    }

    public String getOpt1() {
        return Opt1;
    }

    public void setOpt1(String opt1) {
        Opt1 = opt1;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}
