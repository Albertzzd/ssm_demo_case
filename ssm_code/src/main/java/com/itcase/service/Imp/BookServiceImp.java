package com.itcase.service.Imp;

import com.itcase.Exception.BusinessException;
import com.itcase.Exception.SystemException;
import com.itcase.controller.Code;
import com.itcase.dao.BookDao;
import com.itcase.domain.Book;
import com.itcase.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        int result = bookDao.save(book);
        if(result>0){
            return  true;
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        bookDao.update(book);
        return true;
    }

    @Override
    public boolean deleteBookById(Integer id) {
        bookDao.delete(id);
        return true;
    }

    @Override
    public Book getBookById(Integer id) {
        //业务逻辑判断：传递参数的合法性（用户录入）
        if (id < 0) {
            //业务异常: 用户造成的
            throw new BusinessException(Code.BUSINESS_ERR, "用户id不能为负数");
        }

        Book book = null;
        try {
            //数据库可能有问题抛出异常
            book = bookDao.getById(id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, "当前访问人数较多,请稍后访问");
        }

        //模拟未知异常
//        int i = 1 / 0;

        return book;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = bookDao.getAll();
        return bookList;
    }
}
