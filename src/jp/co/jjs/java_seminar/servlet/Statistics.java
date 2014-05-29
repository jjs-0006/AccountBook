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

/**
 * Servlet implementation class Statistics
 */
@WebServlet("/statistics")
public class Statistics extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statistics() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("WEB-INF/statisticst.jsp");
        AccountDAO adao = new AccountDAO();
        HttpSession session = request.getSession();
        int term = Integer.parseInt(request.getParameter("term"));
        int type_number = Integer.parseInt(request.getParameter("type_number"));
        int year = 2014;
        int month = 5;
        int user_number = 1;
        int syear = 0;
        int smonth = 0;
        if((month - term)  > 0){
            syear = year;
            smonth = month - term;
        }
        else{
            syear = year - 1;
            smonth = month - term + 12;
        }
        ArrayList<Data> datalist = adao.getTermData(syear, smonth, year, month, user_number, type_number);
        session.setAttribute("datalist", datalist);
        dispatcher.forward(request, response);

    }

}
