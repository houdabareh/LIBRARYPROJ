package servlets;

import com.google.gson.Gson;
import dao.MagazineDAO;
import entities.Magazine;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet("/magazines")
public class MagazineServlet extends HttpServlet {
    private MagazineDAO magazineDAO = new MagazineDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Magazine> magazines = magazineDAO.findAll();
        String json = new Gson().toJson(magazines);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Magazine magazine = new Gson().fromJson(request.getReader(), Magazine.class);
        magazineDAO.save(magazine);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}

