package bookmall.vo;

public class book_orderVo {
	private Long book_no;
	private Long order_no;
	private int amount;
	private String bookname;
	private int bookprice;
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "book_orderVo [book_no=" + book_no + ", order_no=" + order_no + ", amount=" + amount + ", bookname="
				+ bookname + ", bookprice=" + bookprice + "]";
	}
	

	
	
	
	
	
	
}
