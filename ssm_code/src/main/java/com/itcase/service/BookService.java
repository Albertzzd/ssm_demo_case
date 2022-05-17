package com.itcase.service;


import com.itcase.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    /**
     * 保存
     * @param book
     * @return
     */
    public boolean saveBook(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    public boolean updateBook(Book book);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean deleteBookById(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Book getBookById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Book> getAllBook();
}
