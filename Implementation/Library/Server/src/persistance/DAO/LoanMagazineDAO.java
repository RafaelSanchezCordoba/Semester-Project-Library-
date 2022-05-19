package persistance.DAO;

import model.LibraryUser;
import model.LoanMagazine;
import model.Magazine;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LoanMagazineDAO {
    void addLoanMagazine(LoanMagazine loanMagazine) throws SQLException;
    ArrayList<Magazine> getAvailableMagazineList() throws SQLException;
    LibraryUser getLibraryUser(String ssn)throws SQLException;
}
