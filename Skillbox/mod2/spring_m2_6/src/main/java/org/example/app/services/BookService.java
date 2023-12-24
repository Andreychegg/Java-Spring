package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final ProjectRepository<Book> bookRepo;
    private final Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    public void removeBooksByRegex(String queryRegex) {
        List<Book> booksToRemove = new ArrayList<>();

        for (Book book : bookRepo.retreiveAll()) {
            if (matchesRegex(book, queryRegex)) {
                booksToRemove.add(book);
            }
        }

        for (Book book : booksToRemove) {
            bookRepo.removeItemById(book.getId());
        }
    }

    private boolean matchesRegex(Book book, String queryRegex) {
        return matchesField(book.getAuthor(), queryRegex) ||
                matchesField(book.getTitle(), queryRegex) ||
                matchesField(book.getSize().toString(), queryRegex);
    }

    private boolean matchesField(String fieldValue, String queryRegex) {
        return fieldValue != null && fieldValue.matches(queryRegex);
    }

    public void defaultInit() {
        logger.info("default INIT in book service");
    }

    public void defaultDestroy() {
        logger.info("default DESTROY in book service");
    }
}
