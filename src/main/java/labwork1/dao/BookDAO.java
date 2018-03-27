package labwork1.dao;

import labwork1.entities.Book;
import labwork1.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends AbstractDAO<Book> {

    private static final String SELECT_BOOKS = "SELECT * FROM books WHERE categoryId = ?";

    public BookDAO() {
        super("SELECT * FROM books;",
                "INSERT INTO books (categoryId, name, author, year, numOfPages, price, description, available, image)" +
                        " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);",
                "UPDATE books SET categoryId = ?, name = ?, author = ?, year = ?, numOfPages = ?, price = ?," +
                        " description = ?, available = ?, image = ? WHERE id = ?;",
                "SELECT * FROM books WHERE id = ?",
                "DELETE FROM books WHERE id = ?",
                new String[] {"categoryId", "name", "author", "year", "numOfPages", "price", "description", "available", "image"},
                Book.class);
    }

    public List<Book> selectBooksFromCategory(int categoryId) {
        List<Book> books = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SELECT_BOOKS);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("categoryId"), rs.getString("name"),
                        rs.getString("author"), rs.getInt("year"), rs.getInt("numOfPages"),
                        rs.getFloat("price"), rs.getString("description"),
                        rs.getBoolean("available"), rs.getString("image"));
                book.setId(rs.getInt("id"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
