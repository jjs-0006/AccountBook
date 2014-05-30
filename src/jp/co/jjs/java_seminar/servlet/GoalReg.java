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
import jp.co.jjs.java_seminar.javabeans.Goal;

/**
 * Servlet implementation class Goal
 */
@WebServlet("/goal")
public class GoalReg extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoalReg() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("WEB-INF/jsp/goal.jsp");
        HttpSession session = request.getSession();
        int year = (int)session.getAttribute("year");
        int month = (int)session.getAttribute("month");
        int user_number = 1;
        ArrayList<Goal> goallist = new ArrayList<>();
        AccountDAO adao = new AccountDAO();
        goallist = adao.getGoal(year, month, user_number);
        System.out.println(goallist.get(0).getMoney());
        request.setAttribute("goallist", goallist);
        dispatcher.forward(request, response);

    }

}
