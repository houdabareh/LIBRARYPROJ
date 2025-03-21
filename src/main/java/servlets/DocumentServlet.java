package servlets;

import com.google.gson.Gson;
import dao.DocumentDAO;
import entities.Document;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/documents")
public class DocumentServlet extends HttpServlet {
    private DocumentDAO documentDAO = new DocumentDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Document> documents = documentDAO.findAll(Document.class);
        String json = new Gson().toJson(documents);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
