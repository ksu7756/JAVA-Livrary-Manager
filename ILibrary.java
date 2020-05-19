package library;

import java.util.Scanner;

public interface ILibrary { // 도서관 운용 인터페이스

	// 필수 기능 구현용 추상 메소드

	public void bookResister(); // 책 등록

	public void bookList(); // 책 목록

	public void clientsList(); // 회원 목록

	public void clientsResister(); // 회원 등록

	public void run(); // 실행

	public void loan(); // 대출

	public void bookReturn(); // 반납

	public void exit(); // 종료

}
