package com.itcase.controller;

import com.itcase.domain.Book;
import com.itcase.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean result = bookService.saveBook(book);

        Integer code = result ? Code.SAVE_OK : Code.SAVE_ERR;
        String message = result ? "保存成功" : "保存失败";
        return new Result(code, result, message);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean result = bookService.updateBook(book);
        Integer code = result ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String message = result ? "修改成功" : "修改失败";
        return new Result(code, result, message);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = bookService.deleteBookById(id);
        Integer code = result ? Code.DELETE_OK : Code.DELETE_ERR;
        String message = result ? "删除成功" : "删除失败";
        return new Result(code, result, message);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String message = book != null ? "查询用户成功" : "查询用户失败";
        return new Result(code, book, message);
    }

    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAllBook();
        Integer code = bookList != null && bookList.size() != 0 ? Code.GET_OK : Code.GET_ERR;
        String message = bookList != null && bookList.size() != 0 ? "查询全部成功" : "查询全部失败";
        return new Result(code, bookList, message);
    }
}
