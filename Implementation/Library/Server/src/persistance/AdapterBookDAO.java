package persistance;

import model.Book;
import model.Genre;
import model.GenreList;
import server.BookStorage;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdapterBookDAO implements BookStorage {
  private BookDAO bookDAO;
  
  public AdapterBookDAO(BookDAO bookDAO) {
    this.bookDAO = bookDAO;
  }
  
  @Override public void addBook(Book book) throws SQLException, RemoteException {
    try
    {
      bookDAO.addBook(book);
    }
    catch (SQLException e)
    {
      throw new RemoteException(e.getMessage(), e);
    }
  }

  @Override public void removeBook(int id) throws SQLException, RemoteException {
    try
    {
      bookDAO.removeBook(id);
    }
    catch (SQLException e)
    {
      throw new RemoteException(e.getMessage(), e);
    }
  }

  @Override public ArrayList<Book> getBookList() throws SQLException, RemoteException {
    try
    {
      return bookDAO.getBookList();
    }
    catch (SQLException e)
    {
      throw new RemoteException(e.getMessage(), e);
    }
  }

  @Override public GenreList getGenreList()
      throws SQLException, RemoteException
  {
    return bookDAO.getGenreList();
  }
}
