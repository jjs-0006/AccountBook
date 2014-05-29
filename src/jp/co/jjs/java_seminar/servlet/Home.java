package jp.co.jjs.java_seminar.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.jjs.java_seminar.dao.AccountDAO;
import jp.co.jjs.java_seminar.javabeans.Data;
import jp.co.jjs.java_seminar.javabeans.Goal;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("WEB-INF/jsp/home.jsp");
        // 年月日・ユーザー番号はログイン時に初期化
        String[] message = { "セーフ", "アウト" };
        int year = 2014;
        int month = 5;
        int day = 29;
        int user_number = 1;
        AccountDAO adao = new AccountDAO();
        HttpSession session = request.getSession();
  /*      String button = request.getParameter("");
        if (button.equals("登録")) {
            adao.setData(year, month, day, user_number,
                    Integer.parseInt(request.getParameter("type_number")),
                    Integer.parseInt(request.getParameter("money")), request.getParameter("note"));
        }*/
        ArrayList<Data> datalist = adao.getData(year, month, user_number);
        ArrayList<Goal> goallist = adao.getGoal(year, month, user_number);
        request.setAttribute("data", datalist);
        request.setAttribute("goal", goallist);
        request.setAttribute("message", message);
        session.setAttribute("year", year);
        session.setAttribute("month", month);
        session.setAttribute("day", day);
        System.out.println(datalist.get(0).getMoney());


        //グラフ用のデータを作成


        dispatcher.forward(request, response);
    }

}
