package labwork1.servlets;



import labwork1.dao.BookDAO;
import labwork1.dao.CategoryDAO;
import labwork1.entities.Book;
import labwork1.entities.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.findAll();
        req.getSession().setAttribute("categories", categories);
        req.getRequestDispatcher("/views/addBook.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        int year = Integer.parseInt(req.getParameter("year"));
        int numOfPages = Integer.parseInt(req.getParameter("numOfPages"));
        float price = Float.parseFloat(req.getParameter("price"));
        String description = req.getParameter("description");
        boolean availability = Boolean.parseBoolean(req.getParameter("availability"));
        String image = req.getParameter("image");

        BookDAO bookDAO = new BookDAO();
        bookDAO.create(new Book(categoryId, name, author, year, numOfPages, price, description, availability, image));

        req.getRequestDispatcher("/views/addBook.jsp").forward(req, resp);
    }
}
