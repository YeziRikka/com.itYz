package com.itYz.controller;

import com.itYz.pojo.Book;
import com.itYz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERROR , flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERROR , flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERROR , flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        int i = 1/0;
        Book book = bookService.getById(id);
        Integer Code = book != null ? com.itYz.controller.Code.SELECT_OK : com.itYz.controller.Code.SAVE_ERROR;
        String msg = book != null ? "数据查询成功" : "数据查询失败，请重试";
        return new Result(Code,book,msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        Integer Code = bookList != null ? com.itYz.controller.Code.SELECT_OK : com.itYz.controller.Code.SAVE_ERROR;
        String msg = bookList != null ? "数据查询成功" : "数据查询失败，请重试";
        return new Result(Code,bookList,msg);
    }
}
