package servlets;

import com.google.gson.Gson;
import dao.BorrowDAO;
import entities.Borrow;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/borrows")
public class BorrowServlet extends HttpServlet {
    private BorrowDAO borrowDAO = new BorrowDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Borrow> borrows = borrowDAO.findAll(Borrow.class);
        String json = new Gson().toJson(borrows);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Borrow borrow = new Gson().fromJson(request.getReader(), Borrow.class);
        borrowDAO.save(borrow);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
