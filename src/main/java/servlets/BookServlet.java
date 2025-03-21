package servlets;

import com.google.gson.Gson;
import dao.BookDAO;
import entities.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO = new BookDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookDAO.findAll(Book.class);
        String json = new Gson().toJson(books);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Gson().fromJson(request.getReader(), Book.class);
        bookDAO.save(book);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}

