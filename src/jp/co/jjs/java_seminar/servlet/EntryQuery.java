package jp.co.jjs.java_seminar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.jjs.java_seminar.dao.AccountDAO;

/**
 * Servlet implementation class EntryQuery
 */
@WebServlet("/entryquery")
public class EntryQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryQuery() {
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
        RequestDispatcher dispatcher;
        AccountDAO adao = new AccountDAO();
        String id = request.getParameter("id");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        if(!pass1.equals(pass2)){
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/entry.jsp");
            request.setAttribute("message", "パスワードを2回入力してください");
        }
        int result = adao.entry(id, pass1);
        if(result == 1){
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/entry.jsp");
            request.setAttribute("message", "すでに登録されているIDです");
        }
        else{
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
        }
        dispatcher.forward(request, response);

    }

}
