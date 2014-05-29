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

import jp.co.jjs.java_seminar.javabeans.Data;
import jp.co.jjs.java_seminar.javabeans.Goal;

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

    // 指定した月のデータを取得
    public ArrayList<Data> getData(int y, int m, int user_number) {
        ArrayList<Data> datalist = new ArrayList<>();
        int date = y * 10000 + m * 100;
        int i = 0;
        String sql = "SELECT * FROM DATA,TYPE_MASTER WHERE DATE > " + date
                + "AND DATE < " + (date + 100) + " AND USER_NUMBER = "
                + user_number;
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Data data = new Data();
                    data.setData_number(rs.getInt("DATA_NUMBER"));
                    data.setUser_number(rs.getInt("USER_NUMBER"));
                    data.setType_number(rs.getInt("TYPE_NUMBER"));
                    data.setTypeName(rs.getString("TYPE_NAME"));
                    data.setDate(rs.getInt("DATE"));
                    data.setMoney(rs.getInt("MONEY"));
                    data.setNote(rs.getString("NOTE"));
                    datalist.add(i, data);
                    i++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datalist;

    }

    // 一定期間のデータを取得する関数 今月から指定した期間(月単位)のデータを取得
    public ArrayList<Data> getTermData(int sy, int sm, int ey, int em,
            int user_number) {
        ArrayList<Data> datalist = new ArrayList<>();
        int startdate = sy * 10000 + sm * 100;
        int enddate = ey * 10000 + em * 100;
        int i = 0;
        String sql = "SELECT * FROM DATA,TYPE_MASTER WHERE DATE > " + startdate
                + "AND DATE < " + enddate + " AND USER_NUMBER = " + user_number;
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Data data = new Data();
                    data.setData_number(rs.getInt("DATA_NUMBER"));
                    data.setUser_number(rs.getInt("USER_NUMBER"));
                    data.setType_number(rs.getInt("TYPE_NUMBER"));
                    data.setTypeName(rs.getString("TYPE_NAME"));
                    data.setDate(rs.getInt("DATE"));
                    data.setMoney(rs.getInt("MONEY"));
                    data.setNote(rs.getString("NOTE"));
                    datalist.add(i, data);
                    i++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datalist;

    }

    // データを登録する関数
    public void setData(int y, int m, int d, int user_number, int type_number,
            int money, String note) {
        int date = y * 10000 + m * 100 + d;
        String sql = "INSERT INTO DATA (USER_NUMBER,TYPE_NUMBER,DATE,MONEY,NOTE) VALUES("
                + user_number
                + ","
                + type_number
                + ","
                + date
                + ","
                + money
                + "," + note + ")";
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // データを修正する関数
    public void revData(int user_number, int data_number,
            int type_number, int money, String note) {
        String sql = "UPDATE DATA SET TYPE_NUMBER=" + type_number + ",money="
                + money + ",note='" + note + "' WHERE USER_NUMBER="
                + user_number + " AND DATA_NUMBER=" + data_number;
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // データを消去する関数
    public void delData(int user_number, int data_number) {
        String sql = "DELETE FROM DATA WHERE USER_NUMBER="
                + user_number + " AND DATA_NUMBER=" + data_number;
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 目標を取得する関数
    public ArrayList<Goal> getGoal(int y, int m, int user_number) {
        ArrayList<Goal> goallist = new ArrayList<>();
        int date = y * 10000 + m * 100;
        int i = 0;
        String sql = "SELECT * FROM GOAL,TYPE_MASTER WHERE DATE > " + date
                + "AND DATE < " + (date + 100) + " AND USER_NUMBER = "
                + user_number;
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Goal goal = new Goal();
                    goal.setData_number(rs.getInt("DATA_NUMBER"));
                    goal.setUser_number(rs.getInt("USER_NUMBER"));
                    goal.setType_number(rs.getInt("TYPE_NUMBER"));
                    goal.setTypeName(rs.getString("TYPE_NAME"));
                    goal.setDate(rs.getInt("DATE"));
                    goal.setMoney(rs.getInt("MONEY"));
                    goal.setRank(rs.getInt("RANK"));
                    goal.setSub_money(rs.getInt("SUB_MONEY"));
                    goallist.add(i, goal);
                    i++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goallist;
    }

    // 目標達成を更新する関数
    public void judgeGoal(ArrayList<Integer> moneylist,
            ArrayList<Integer> goallist, int y, int m, int user_number) {
        int date = y * 10000 + m * 100;
        ArrayList<Integer> sublist = new ArrayList<>();
        for (int i = 0; i < type_count; i++) {
            int sub = goallist.get(i) - moneylist.get(i);
            int rank = 0;
            sublist.set(i, sub);
            // ランクの判定
            if (sub < 10000) {
                rank = 1;
            } else {
                rank = 2;
            }
            String sql = "UPDATE GOAL SET RANK=" + rank + ",SUB=" + sub
                    + "WHERE DATE > " + date + "AND DATE < " + (date + 100)
                    + " AND USER_NUMBER = " + user_number;
            try (Connection con = ds.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

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
                String upsql = "UPDATE GOAL SET TYPE MONEY=" + moneylist.get(i)
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
                String insql = "INSERT INTO GOAL(USER_NUMBER,TYPE_NUMBER,DATE,MONEY,RANK,SUB_MONEY)"
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


