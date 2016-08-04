package com.tracker.data;

/**
 * Created by Superduo on 8/4/16.
 */
public class Expenses {

    public static enum CategoryType { FITNESS, TRAVEL, FOOD, FAMILY };

    private String expenseID;
    private String expenseName;
    private String expenseAmount;
    private String expenseDate;
    private CategoryType categoryType;

   public Expenses(){
       this.expenseID = expenseID;
       this.expenseName = expenseName;
       this.expenseAmount = expenseAmount;
       this.expenseDate = expenseDate;
       this.categoryType = categoryType;
   }

    public String getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(String expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}




