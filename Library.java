package library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library implements ILibrary {

	private Book[] book = new Book[100000]; // 책 객체배열 생성
	private Clients[] clients = new Clients[1000]; // 회원 객체배열 생성

	private Scanner scan = new Scanner(System.in);
	private boolean run = true; // on off용  작동 변수

	@Override
	public void exit() { // 종료

		
		run = false;
		System.out.println("프로그램을 종료합니다");
	}

	@Override
	public void bookResister() { // 책 등록

		System.out.print("책이름을 입력하세요 > ");
		String bookName = scan.next().trim();
		System.out.print("책 저자를 입력하세요 > ");
		String bookWriter = scan.next().trim();

		for (int i = 0; i < book.length; i++) {

			if (book[i] == null) {
				book[i] = new Book(bookName, i, bookWriter);
				System.out.println("등록완료");
				break;
			}

		}

	}

	@Override
	public void bookList() { // 책 목록 출력

		for (int i = 0; i < book.length; i++) {
			if (book[i] != null) {
				System.out.print("No" + book[i].getBookNum() + " || " + "책이름: " + book[i].getBookname() + " || "
						+ "저자: " + book[i].getBookWriter() + " || ");
				System.out.print("대출 현황: ");
				if (book[i].getLoan() == 0) {
					System.out.println("보유중");
				} else {
					System.out.println("대출중" + " || " + "대출 날짜: " + book[i].getDate());

				}

			}

		}
	}

	@Override
	public void run() { // 실행 runnable method

		System.out.println("---------------------MINI BOOK LABRARY-----------------------");

		int selectNum;

		while (run) {

			System.out.println("-------------------------------------------------------------");
			System.out.println("1.도서 목록 || 2. 도서 등록 || 3. 회원 목록  || 4. 회원 등록 || 5. 책 대출 ");
			System.out.println("-------------------------------------------------------------");
			System.out.println("6.책 반납    ||xxxxxxxxxx||xxxxxxxxxxx||xxxxxxxxxx|| 10. 종료 ");
			System.out.println("-------------------------------------------------------------");
			System.out.print("선택 > ");

			while (true) { // InputMismatchException 오류로 인한 프로그램 강제종료를 고려한 예외처리 코드
				try {

					selectNum = scan.nextInt();
					break;

				} catch (InputMismatchException e) {

					scan = new Scanner(System.in);
					selectNum = 0;
					System.out.println("다시 입력해주세요.");
					System.out.println("선택 > ");

				}
			} // InputException end

			if (selectNum == 1) {

				bookList();

			} else if (selectNum == 2) {

				bookResister();

			} else if (selectNum == 3) {

				clientsList();

			} else if (selectNum == 4) {

				clientsResister();

			} else if (selectNum == 5) {

				loan();

			} else if (selectNum == 6) {

				bookReturn();
			} else if (selectNum == 10) {

				exit();

			}

		}

	}

	@Override
	public void clientsList() { // 회원 목록
		// TODO Auto-generated method stub

		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null) {
				System.out.print("No" + clients[i].getClientsNum() + " || " + "이름: " + clients[i].getClientsName()
						+ " || " + "나이: " + clients[i].getAge() + " || " + "전화번호: " + clients[i].getClientsCall()
						+ " || " + "대출 중인 책: ");
				if (clients[i].getLoanClientsBook() == null) {

					System.out.println("x");

				} else {

					System.out.println(clients[i].getLoanClientsBook());
				}

			}

		}

	}

	@Override
	public void clientsResister() { // 회원 등록
		// TODO Auto-generated method stub

		System.out.print("이름: ");
		String clientsName = scan.next().trim();
		System.out.print("나이: ");
		int clientsAge = scan.nextInt();
		System.out.print("전화번호: ");
		String clientsCall = scan.next().trim();

		for (int i = 0; i < clients.length; i++) {

			if (clients[i] == null) {
				clients[i] = new Clients(i, clientsName, clientsAge, clientsCall);
				break;
			}
		}
	}

	@Override
	public void loan() { // 대출
		// TODO Auto-generated method stub

		System.out.print("대출할 회원: ");

		String loanClientsName = scan.next().trim();

		if (findClients(loanClientsName) == null) {

			System.out.println("해당인원은 존재하지않습니다.");

		} else if (findClients(loanClientsName).getLoanClientsBook() != null) {

			System.out.println("미반납한 책이 있기에 대출 할수없습니다");

		} else {
			System.out.print("대출할 책 제목: ");

			String loanBook = scan.next().trim();

			if (findBook(loanBook) == null) {
				System.out.println("해당 책은 존재하지않습니다.");

			} else if (findBook(loanBook).getLoan() != 0) {
				System.out.println("현재 대출 중인 도서입니다.");
			} else {
				findClients(loanClientsName).setLoanClientsBook(loanBook);
				findBook(loanBook).setLoan(1);

				DateFormat sdNow = new SimpleDateFormat("yyyy년 MM월 dd일 mm분 ss초"); // 현재 시간이 제대로 저장되는지 확인용으로 초 단위까지 기재
				Date now = new Date();
				String sNow = sdNow.format(now); // 현재 시간 Date -> String 저장

				findBook(loanBook).setDate(sNow);
			}

		}

	}

	public Clients findClients(String c) { // Clients 배열에서 c 와 같은 Clients 객체 찾기

		Clients myClients = null;

		for (int i = 0; i < clients.length; i++) {

			if (clients[i] != null && clients[i].getClientsName().equals(c)) {

				myClients = clients[i];
				break;
			}
		}

		return myClients;

	}

	public Book findBook(String c) { // Book 배열에서 c 와 같은 Book 객체 찾기

		Book myBook = null;

		for (int i = 0; i < clients.length; i++) {

			if (book[i] != null && book[i].getBookname().equals(c)) {

				myBook = book[i];
				break;
			}
		}

		return myBook;

	}

	@Override
	public void bookReturn() { // 반납
		// TODO Auto-generated method stub
		System.out.println("반납할 책 이름: ");
		String returnBookName = scan.next().trim();

		if (findBook(returnBookName) == null) {
			System.out.println("해당 책은 도서관 책이 아닙니다.");

		} else if (findBook(returnBookName).getLoan() == 0) {

			System.out.println("해당 책은 보유 중 인 책입니다. 대출 중 인 책을 입력해주세요");

		} else if (findBook(returnBookName).getLoan() != 0) {

			findBook(returnBookName).setLoan(0);

			for (int i = 0; i < book.length; i++) {

				if (clients[i].getLoanClientsBook() != null && clients[i].getLoanClientsBook().equals(returnBookName)) {
					clients[i].setLoanClientsBook(null);

					break;
				}

			}

			System.out.println("책이 반납되었습니다.");
		}

	}

	public void test() { // test용 더미

		book[0] = new Book("더해빙", 0, "이서윤");
		book[1] = new Book("지리의힘", 1, "팀마샬");
		book[2] = new Book("1cm다이빙", 2, "태수");
		book[3] = new Book("녹나무의파수꾼", 3, "히가시노게이고");
		book[4] = new Book("오래준비해온대답", 4, "김영하");

		clients[0] = new Clients(0, "김상욱", 30, "010-8673-xxxx");
		clients[1] = new Clients(1, "김영호", 26, "010-5291-xxxx");
		clients[2] = new Clients(2, "윤상근", 27, "010-5696-xxxx");
		clients[3] = new Clients(3, "신자원", 26, "010-8692-xxxx");
		clients[4] = new Clients(4, "허선행", 26, "010-7243-xxxx");
		clients[5] = new Clients(5, "이요한", 23, "010-5640-xxxx");

	}

}
