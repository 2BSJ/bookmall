package bookmall.vo;

public class ordersVo {
	private Long no;
	private String ordernum;
	private int price;
	private String destination;
	private Long member_no;
	private String membername;
	private String memberphone;
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	@Override
	public String toString() {
		return "ordersVo [no=" + no + ", ordernum=" + ordernum + ", price=" + price + ", destination=" + destination
				+ ", member_no=" + member_no + ", membername=" + membername + ", memberphone=" + memberphone + "]";
	}
	

	
	
}
