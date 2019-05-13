package bookmall.vo;

public class cartVo {
	private Long book_no;
	private Long member_no;
	private int amount;
	private String bookname;
	private int bookprice;
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBookprice() {
		return bookprice;
	}
	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}
	@Override
	public String toString() {
		return "cartVo [book_no=" + book_no + ", member_no=" + member_no + ", amount=" + amount + ", bookname="
				+ bookname + ", bookprice=" + bookprice + "]";
	}
	

	
	
	
	
}
