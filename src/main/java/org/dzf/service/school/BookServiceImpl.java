package org.dzf.service.school;

import java.util.List;

import javax.annotation.Resource;

import org.dzf.domain.school.Book;
import org.dzf.domain.school.BookRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service(value = "BookService")
public class BookServiceImpl implements BookService{
	@Resource(name = "bookRepository")
	private BookRepository bookRepository;

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> findBook(String bookName) {
		Pageable pageable = new PageRequest(0,5);
		return bookRepository.queryBook(bookName,pageable);
	}
	
}
