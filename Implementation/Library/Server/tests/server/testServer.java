package server;

import model.LibraryUser;
import persistance.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class testServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException, SQLException
  {

    Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
    LibraryUserDAOImplementation libraryUserDAO =  LibraryUserDAOImplementation.getInstance();
    // BookDAOImplementation bookDAO = BookDAOImplementation.getInstance();
    //MagazineDAOImplementation magazineDAO = MagazineDAOImplementation.getInstance();
    //AdapterBookDAO adapterBookDAO = new AdapterBookDAO(bookDAO);
    //AdapterMagazineDAO adapterMagazineDAO = new AdapterMagazineDAO(magazineDAO);

    LibraryUserStorage libraryUserStorage = LibraryUserStorageTest.getInstance();
    MagazineStorage magazineStorage = MagazineStorageTest.getInstance();
    BookStorage bookStorage = BookStorageTest.getInstance();

    RemoteBook book = new Communicator(magazineStorage, bookStorage,
        libraryUserStorage);
    RemoteMagazine magazine = new Communicator(magazineStorage, bookStorage,
        libraryUserStorage);
    RemoteLibraryUser libraryUser = new Communicator(magazineStorage,
        bookStorage, libraryUserStorage);

    registry.bind("book", book);
    registry.bind("magazine", magazine);
    registry.bind("libraryUser", libraryUser);


    System.out.println("server.Server running on " + Registry.REGISTRY_PORT);
  }
}