package entities;

import java.sql.Time;
import java.util.Date;

public class Event {

    private int id;
    private int typeOfClass;   //other 0, rest go in order?
    // University Courses 80%, Seminars 60%, Certification Preparation Classes 75%,
    // Certification 100%, Technical Training 90%, Other 30%.
    private String nameOfClass;
    private int costOfClass;
    private int startDate;
    private int endDate;
    private int timeOfClass;
    private String about;
    private String justification;
    private int employeeID;
    private int managerID;
    //not given grading reference table, assume employees won't either;
    private String gradeDescription;
    private int gradingFormat;
    private String finalGrade;
    private boolean approved;
    private String fullForm;
    private String gradeOrPresentation;
    //todo attachments

    public Event(){};
    public Event(int id, int type, String name, int cost, int start, int end, int time,
                 String about, String justification, int employee, int manager,
                 String gradeDescription, int gradingFormat, String finalGrade, boolean approved,
                 String fullForm, String gradeOrPresentation){
        this.id = id;
        this.typeOfClass = type;
        this.nameOfClass = name;
        this.costOfClass = cost;
        this.startDate = start;
        this.endDate = end;
        this.timeOfClass = time;
        this.about = about;
        this.justification = justification;
        this.employeeID = employee;
        this.managerID = manager;
        this.gradeDescription = gradeDescription;
        this.gradingFormat = gradingFormat;
        this.finalGrade = finalGrade;
        this.approved = approved;
        this.fullForm = fullForm;
        this.gradeOrPresentation = gradeOrPresentation;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeOfClass() {
        return this.typeOfClass;
    }

    public void setTypeOfClass(int type) {
        this.typeOfClass = type;
    }

    public String getNameOfClass() {
        return this.nameOfClass;
    }

    public void setNameOfClass(String name) {
        this.nameOfClass = name;
    }

    public int getCostOfClass() {
        return this.costOfClass;
    }

    public void setCostOfClass(int cost) {
        this.costOfClass = cost;
    }

    public int getStartDate() {
        return this.startDate;
    }

    public void setStartDate(int start) {
        this.startDate = start;
    }

    public int getEndDate() {
        return this.endDate;
    }

    public void setEndDate(int end) {
        this.endDate = end;
    }

    public int getTimeOfClass() {
        return this.timeOfClass;
    }

    public void setTimeOfClass(int time) {
        this.timeOfClass = time;
    }

    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getJustification() {
        return this.justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public int getEmployee() {
        return this.employeeID;
    }

    public void setEmployee(int employee) {
        this.employeeID = employee;
    }

    public int getManager() {
        return this.managerID;
    }

    public void setManager(int manager) {
        this.managerID = manager;
    }

    public String getGradeDescription() {
        return this.gradeDescription;
    }

    public void setGradeDescription(String gradeDescription) {
        this.gradeDescription = gradeDescription;
    }

    public int getGradingFormat() {
        return this.gradingFormat;
    }

    public void setGradingFormat(int gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public String getFinalGrade() {
        return this.finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setFullForm(String form) {
        this.fullForm = form;
    }

    public String getFullForm(){ return this.fullForm; }

    public void setGradeOrPresentation(String grade) {
        this.gradeOrPresentation = grade;
    }

    public String getGradeOrPresentation(){ return this.gradeOrPresentation; }
}
