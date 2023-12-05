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

    @Autowired
    public BookService(BookRepository<Book> bookRepo) {
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

    public int removeBooksByRegex(String queryRegex) {
        List<Book> booksToRemove = new ArrayList<>();

        for (Book book : bookRepo.retreiveAll()) {
            if (matchesRegex(book, queryRegex)) {
                booksToRemove.add(book);
            }
        }

        for (Book book : booksToRemove) {
            bookRepo.removeItemById(book.getId());
        }

        return booksToRemove.size();
    }

    private boolean matchesRegex(Book book, String queryRegex) {
        return matchesField(book.getAuthor(), queryRegex) ||
                matchesField(book.getTitle(), queryRegex) ||
                matchesField(book.getSize(), queryRegex);
    }

    private boolean matchesField(String fieldValue, String queryRegex) {
        return fieldValue != null && fieldValue.matches(queryRegex);
    }
}