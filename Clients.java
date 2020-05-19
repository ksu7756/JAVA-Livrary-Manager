package library;

public class Clients { // 회원 정보

	// 멤버변수 은닉
	private int clientsNum;
	private String clientsName;
	private int age;
	private String clientsCall;
	private String loanClientsBook;

	// 회원 정보를 담을 생성자

	public Clients(int clientsNum, String clientsName, int age, String clientsCall) {
		super();
		this.clientsNum = clientsNum;
		this.clientsName = clientsName;
		this.age = age;

		this.clientsCall = clientsCall;
	}

	// get set

	public int getClientsNum() {
		return clientsNum;
	}

	public void setClientsNum(int clientsNum) {
		this.clientsNum = clientsNum;
	}

	public String getClientsName() {
		return clientsName;
	}

	public void setClientsName(String clientsName) {
		this.clientsName = clientsName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClientsCall() {
		return clientsCall;
	}

	public void setClientsCall(String clientsCall) {
		this.clientsCall = clientsCall;
	}

	public String getLoanClientsBook() {
		return loanClientsBook;
	}

	public void setLoanClientsBook(String loanClientsBook) {
		this.loanClientsBook = loanClientsBook;
	}

}
