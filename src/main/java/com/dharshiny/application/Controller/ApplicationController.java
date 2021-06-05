package com.dharshiny.application.Controller;

import java.util.ArrayList;
import java.util.List;

import com.dharshiny.application.Exception.ResourceNotFoundException;
import com.dharshiny.application.Model.BookModel;
import com.dharshiny.application.Repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path= "/saveBook")
    public BookModel saveBook(@RequestBody BookModel book ){
        return bookRepository.save(book);
    }
    
    @PostMapping(path = "/editBook/bookId={id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable(value="id") String bid, 
            @RequestBody BookModel bookDetails) throws  ResourceNotFoundException{
        
                BookModel book=bookRepository.findById(bid).orElseThrow(
                    () -> new ResourceNotFoundException("Book not found on :: " + bid));
                book.setQuantity(bookDetails.getQuantity());
                book.setBookName(bookDetails.getBookName());
                book.setGenre(bookDetails.getGenre());

                final BookModel updatedBook = bookRepository.save(book);
                return ResponseEntity.ok(updatedBook);

       
    }

    @PostMapping(path = "/deleteBook/bookId={id}")
    public  String deleteBook(@PathVariable(value="id") String bid)throws ResourceNotFoundException{
        
        BookModel book=bookRepository.findById(bid).orElseThrow(
                    () -> new ResourceNotFoundException("Book not found on :: " + bid));

        bookRepository.delete(book);
        return "Deleted Successfully";
    }

    @GetMapping("/getBooks")
    public List<BookModel> getAllBooks(){
        List<BookModel> books=new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @PostMapping("getByType/id={genre}")
    public List<BookModel> getBookByGenre(@PathVariable(value="genre") String genre){
        List<BookModel> books=new ArrayList<>();
        bookRepository.findAll().forEach((book) -> {if(genre.equals(book.getGenre())) {books.add(book);}});
        return books;
    }
}