package library;

import java.util.Date;

public class Book { // 책 정보

	// 멤버 변수 은닉
	private String bookname;
	private int bookNum;
	private String bookWriter;
	private int loan = 0;
	private String date;

	// 책 정보를 담을 생성자

	public Book(String bookname, int bookNum, String bookWriter) {
		super();
		this.bookname = bookname;
		this.bookNum = bookNum;
		this.bookWriter = bookWriter;
	}

	// get set

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public int getLoan() {
		return loan;
	}

	public void setLoan(int loan) {
		this.loan = loan;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
