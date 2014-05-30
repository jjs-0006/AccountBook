package jp.co.jjs.java_seminar.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

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
        HttpSession session = request.getSession();
        int year = (int)session.getAttribute("year");
        int month = (int)session.getAttribute("month");;
        int day = Calendar.DAY_OF_MONTH;
        int user_number = 1;
        AccountDAO adao = new AccountDAO();

        ;
        if (request.getParameter("goalentry") != null) {
            adao.setData(year, month, day, user_number,
                    Integer.parseInt(request.getParameter("type_number")),
                    Integer.parseInt(request.getParameter("money")), request.getParameter("note"));
        }
        ArrayList<Data> datalist = adao.getData(year, month, user_number);
        ArrayList<Goal> goallist = adao.getGoal(year, month, user_number);
        if(request.getParameter("goalentry") != null){
            ArrayList<Integer> moneylist = new ArrayList<>();
            for(int i = 1;i < 13;i++){
                String s = request.getParameter("id" + i);
                if(s.equals("")){
                    s = "0";
                }
                moneylist.add(Integer.parseInt(s));
            }
            adao.setGoal(moneylist, year, month, user_number);
        }
        session.setAttribute("data", datalist);
        request.setAttribute("goal", goallist);
        request.setAttribute("message", message);
        session.setAttribute("year", year);
        session.setAttribute("month", month);
        session.setAttribute("day", day);
        System.out.println(datalist.get(0).getMoney());


        dispatcher.forward(request, response);
    }

}
