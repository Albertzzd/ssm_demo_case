
import com.itcase.config.SpringConfig;
import com.itcase.domain.Book;
import com.itcase.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testGetBook() {
        Book book = bookService.getBookById(1);
        System.out.println(book);
    }

    @Test
    public void testGetAllBook() {
        List<Book> bookList = bookService.getAllBook();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void testSaveBook(){
        Book book = new Book();
        book.setType("编程");
        book.setName("MySQL高级");
        book.setDescription("MySQL数据库的高级应用开发");

        boolean result = bookService.saveBook(book);
        System.out.println(result);
    }
}
