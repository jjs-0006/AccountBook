package jp.co.jjs.java_seminar.javabeans;

import java.io.Serializable;

public class Data implements Serializable{
    private int data_number;
    private int user_number;
    private int type_number;
    private String typeName;
    private int date;
    private int money;
    private String note;

    public int getData_number() {
        return data_number;
    }
    public void setData_number(int table_number) {
        this.data_number = table_number;
    }
    public int getUser_number() {
        return user_number;
    }
    public void setUser_number(int user_number) {
        this.user_number = user_number;
    }
    public int getType_number() {
        return type_number;
    }
    public void setType_number(int type_number) {
        this.type_number = type_number;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

}
