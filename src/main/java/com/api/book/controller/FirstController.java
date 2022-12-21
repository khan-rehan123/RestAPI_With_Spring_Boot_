package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.api.book.entites.Books;
import com.api.book.services.BookServices;

@RestController
public class FirstController {

	@Autowired
	private BookServices bookServices;
	/*
	 * @RequestMapping(value = "/home",method = RequestMethod.GET)
	 * 
	 * @ResponseBody //
	 */
//	@PostMapping("/books")
//	public Books getBook() {
//		
//		Books book= new Books();
//		book.setId(121);
//		book.setName("java book");
//		book.setTitle("this java programming language book");
//		
//		return book;
//	}

	// get all book
	@GetMapping("/books/")
	public ResponseEntity<List<Books>> getBooks() {

		List<Books> list = bookServices.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	// get single book
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getBook(@PathVariable("id") int id) {

		Books book = this.bookServices.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));

	}

	// add books
	@PostMapping("/books")
	public ResponseEntity<Books> addingBook(@RequestBody Books book) {
		try {
			Books b = this.bookServices.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// delete book by id
	@DeleteMapping("/books/{bookId}")
	public void deleteBooks(@PathVariable("bookId") int bookId) {
		this.bookServices.deleteBook(bookId);

	}

	/* update Books by Id */
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Books> updateBooks(@RequestBody Books book, @PathVariable("bookId") int bookId) {
		try {
			this.bookServices.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		

	}
}
