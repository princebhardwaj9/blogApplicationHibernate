package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BLOG")

public class Blog {

	@Id
	@Column(name="BLOGID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name="id_seq", sequenceName="id_seq", allocationSize=1, initialValue=1)	
	private int blogid;
	@Column(name="BLOGTITLE")
	private String blogtitle;
	@Column(name="BLOGDESC")
	private String blogDesc;
	@Column(name="POSTEDON")
	private LocalDate postedOn;
	
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getBlogDesc() {
		return blogDesc;
	}
	public void setBlogDesc(String blogDesc) {
		this.blogDesc = blogDesc;
	}
	public LocalDate getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}
	
}
