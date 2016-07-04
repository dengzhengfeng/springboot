package org.dzf.service.school;

import java.util.List;

import org.dzf.domain.school.Book;

public interface BookService {
	public void saveBook(Book book);
	public List<Book> findBook(String bookName);
}
