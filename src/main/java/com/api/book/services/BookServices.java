package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entites.Books;

@Component
public class BookServices {
	
	@Autowired
	private BookRepository bookRepository;
//	public static List<Books> list=new ArrayList<>();
//	
//	static {
//		
//		  list.add(new Books(121,"software engineering","geven king")); list.add(new
//		  Books(122,"computer graphics","rehan khan")); list.add(new
//		  Books(123,"Java ","jemsh ghosling"));
//		 
//	}
	
	//get add books
	public List<Books> getAllBooks(){
		List<Books> book=(List<Books>) this.bookRepository.findAll();
		return book;
	}
	
	//get single book by id
	public Books getBookById(int id) {
		Books book=null;
		try {
//		book=list.stream().filter(e->e.getId()==id).findFirst().get();\
			book=this.bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
		return book;
	}
	
	//adding the book
	public Books addBook(Books b) {
		Books result=bookRepository.save(b);
		return result;
	}

	/*
	 * public void deleteBook(int bookId) { list.stream().filter(book->{
	 * if(book.getId()!=0) { return true; }else { return false; }
	 * 
	 * }).collect(Collectors.toList());
	 * 
	 * }
	 */
	
	//delete books
	public void deleteBook(int pid) {
//		list=list.stream().filter(book->book.getId()!=0).collect(Collectors.toList());
		bookRepository.deleteById(pid);
	}

	public void updateBook(Books book, int bookId) {
//		list=list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setName(book.getName());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepository.save(book);
				
	}
	
	
	

}
