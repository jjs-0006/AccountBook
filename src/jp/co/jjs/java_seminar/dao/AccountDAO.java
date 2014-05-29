package jp.co.jjs.java_seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccountDAO {
    private DataSource ds;
    public static int type_count = 10;

    public AccountDAO() {
        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext
                    .lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/crud");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    // 目標達成を判定する関数
   public void judgeGoal(ArrayList<Integer> moneylist, int y, int m,
           int user_number){
       int date = y * 10000 + m * 100;


   }

    // 目標を設定する関数
    public void setGoal(ArrayList<Integer> moneylist, int y, int m,
            int user_number) {
        String sql = "";
        /* INSERTかUPDATEかの判定 */
        int date = y * 10000 + m * 100;
        int flag = 0; // 判定用変数 1/UPDATE 2/INSERT
        sql += "SELECT COUNT(DATA_NUMBER) FROM GOAL WHERE DATE > " + date
                + "AND DATE < " + (date + 100) + " AND USER_NUMBER = "
                + user_number;
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                if (rs.getInt(1) > 0) {
                    flag = 1;
                } else {
                    flag = 2;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* 判定結果で処理を分ける */
        if (flag == 1) {
            // UPDATE
            for (int i = 0; i < type_count; i++) {
                String upsql = "UPDATE DATA SET TYPE MONEY=" + moneylist.get(i)
                        + "WHERE USER_NUMBER=" + user_number + "AND DATE > "
                        + date + "AND DATE < " + (date + 100)
                        + " AND TYPE_NUMBER=" + i;

                try (Connection con = ds.getConnection();
                        PreparedStatement ps = con.prepareStatement(upsql)) {
                    ps.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } else if (flag == 2) {
            // INSERT
            for (int i = 0; i < type_count; i++) {
                String insql = "INSERT INTO DATA(USER_NUMBER,TYPE_NUMBER,DATE,MONEY,RANK,SUB_MONEY)"
                        + "VALUES("
                        + user_number
                        + ","
                        + i
                        + ","
                        + date
                        + ","
                        + moneylist.get(i) + "," + "0,0)";
                try (Connection con = ds.getConnection();
                        PreparedStatement ps = con.prepareStatement(insql)) {

                    ps.execute();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } else {
            // 結果がとれなかった時
        }
    }
}
