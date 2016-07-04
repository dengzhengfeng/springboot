package org.dzf.domain.school;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository(value="bookRepository")
public interface BookRepository extends JpaRepository<Book,UUID>{
	@Query("select a from Book a where name like %:name%")
	public List<Book> queryBook(@Param("name")String name,Pageable pageable);
}
