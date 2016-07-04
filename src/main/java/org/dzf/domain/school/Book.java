package org.dzf.domain.school;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "bookdoc")
public class Book {
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type="pg-uuid")
	private UUID id;
	@Column(length=64)
	private String name;//书名
	@Column(length=128)
	private String publisher;//出版社
	@Temporal(TemporalType.DATE)
	private Date publisher_year;//出版时间
	@Temporal(TemporalType.DATE)
	private Date createtime;//创建时间
	
	@ManyToOne
	private Student student;
	
	@PrePersist
	protected void onCreate() {
		createtime = new Date();
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublisher_year() {
		return publisher_year;
	}
	public void setPublisher_year(Date publisher_year) {
		this.publisher_year = publisher_year;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
