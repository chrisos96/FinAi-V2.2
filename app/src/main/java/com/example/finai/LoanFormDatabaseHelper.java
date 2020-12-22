package com.example.finai;

public class LoanFormDatabaseHelper {

    String loan_id;
    int gender;
    int married;
    int dependents;
    int education;
    int self_employed;
    int applicant_income;
    int co_applicant_income;
    int loan_amount;
    int credit_history;
    int property_area;



    public LoanFormDatabaseHelper() {

    }

    public LoanFormDatabaseHelper(String Loan_id, int Gender, int Married, int Dependants, int Education, int Self_employed, int Applicant_income, int Co_Applicant_income, int Loan_amount, int Credit_history, int Property_area) {

        this.loan_id = Loan_id;
        this.gender = Gender;
        this.married = Married;
        this.dependents = Dependants;
        this.education = Education;
        this.self_employed = Self_employed;
        this.applicant_income = Applicant_income;
        this.co_applicant_income = Co_Applicant_income;
        this.loan_amount = Loan_amount;
        this.credit_history = Credit_history;
        this.property_area = Property_area;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getMarried() {
        return married;
    }

    public void setMarried(int married) {
        this.married = married;
    }

    public int getDependents() {
        return dependents;
    }

    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getSelf_employed() {
        return self_employed;
    }

    public void setSelf_employed(int self_employed) {
        this.self_employed = self_employed;
    }

    public int getApplicant_income() {
        return applicant_income;
    }

    public void setApplicant_income(int applicant_income) {
        this.applicant_income = applicant_income;
    }

    public int getCo_applicant_income() {
        return co_applicant_income;
    }

    public void setCo_applicant_income(int co_applicant_income) {
        this.co_applicant_income = co_applicant_income;
    }

    public int getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(int loan_amount) {
        this.loan_amount = loan_amount;
    }

    public int getCredit_history() {
        return credit_history;
    }

    public void setCredit_history(int credit_history) {
        this.credit_history = credit_history;
    }

    public int getProperty_area() {
        return property_area;
    }

    public void setProperty_area(int property_area) {
        this.property_area = property_area;
    }


}
