package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanBookTest {
    private LoanBook loanBook;

    @BeforeEach void setUp() {}

    @AfterEach void tearDown(){
        loanBook = null;
        assertNull(loanBook);
    }

    //"id_book=1, startDate=2022-05-23, endDate=null, ssn='123456789 0 "

    @Test void create_new_loan_book_with_all_correct_parameters(){
        loanBook = new LoanBook(1,"123456789");
        assertEquals("id_book=1, startDate=2022-05-23, endDate=null, ssn='123456789 0", loanBook.toString());
    }

    @Test void create_new_loan_book_with_empty_ssn_number(){
        loanBook = new LoanBook(1,"");
        assertEquals("id_book=1, startDate=2022-05-23, endDate=null, ssn=' 0",loanBook.toString());
    }

    @Test void create_new_loan_book_with_null_ssn_number(){
        loanBook = new LoanBook(1,null);
        assertEquals("id_book=1, startDate=2022-05-23, endDate=null, ssn='null 0",loanBook.toString());
    }

    @Test void set_id_for_loan_book(){
        loanBook = new LoanBook(0,"123456789");
        loanBook.setId(2);
        assertEquals("id_book=0, startDate=2022-05-23, endDate=null, ssn='123456789 2",loanBook.toString());
    }

    @Test void get_id_for_loan_book(){
        loanBook = new LoanBook(0,"123456789");
        assertEquals(0,loanBook.getId());
    }

    @Test void get_id_for_loan_book_after_setting_it(){
        loanBook = new LoanBook(1,"123456789");
        loanBook.setId(3);
        assertEquals(3,loanBook.getId());
    }

    @Test void get_id_of_the_book(){
        loanBook = new LoanBook(9,"123456789");
        assertEquals(9,loanBook.getId_book());
    }

    @Test void get_start_date_of_loan_book(){
        loanBook = new LoanBook(1,"123456789");
        assertEquals("2022-05-23",loanBook.getStartDate().toString());
    }

    @Test void get_end_date_of_loan_book(){
        loanBook = new LoanBook(2,"123456789");
        assertNull(loanBook.getEndDate());
    }

    @Test void get_ssn_from_loan_book(){
        loanBook = new LoanBook(1,"123456789");
        assertEquals("123456789",loanBook.getSsn());
    }
}