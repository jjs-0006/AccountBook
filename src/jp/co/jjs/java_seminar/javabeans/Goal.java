package jp.co.jjs.java_seminar.javabeans;

import java.io.Serializable;

public class Goal implements Serializable{
    private int data_number;
    private int user_number;
    private int type_number;
    private int date;
    private int money;
    private int rank;
    private int sub_money;

    public int getData_number() {
        return data_number;
    }
    public void setData_number(int data_number) {
        this.data_number = data_number;
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
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getSub_money() {
        return sub_money;
    }
    public void setSub_money(int sub_money) {
        this.sub_money = sub_money;
    }


}
