package labwork1.servlets;

import labwork1.dao.BookDAO;
import labwork1.dao.CategoryDAO;
import labwork1.entities.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        req.getSession().setAttribute("categories", categoryDAO.findAll());

        String id = req.getParameter("id");
        BookDAO bookDAO = new BookDAO();
        if (id != null) {
            List<Book> books = bookDAO.selectBooksFromCategory(Integer.valueOf(id));
            req.setAttribute("books", books);
        }

        req.getRequestDispatcher("/catalog.jsp").forward(req, resp);
    }

}
