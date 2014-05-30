package jp.co.jjs.java_seminar.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.jjs.java_seminar.dao.AccountDAO;

/**
 * Servlet implementation class LoginQuery
 */
@WebServlet("/loginquery")
public class LoginQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginQuery() {
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
            HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        AccountDAO adao = new AccountDAO();
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        Calendar cal = Calendar.getInstance();
        session.setAttribute("year", cal.get(Calendar.YEAR));
        session.setAttribute("month", cal.get(Calendar.MONTH + 1));
        int result = adao.login(id, pass);
        if(result > 0){
            session.setAttribute("user_number", result);
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        }
        else{
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
        }
        dispatcher.forward(request, response);

    }
}
