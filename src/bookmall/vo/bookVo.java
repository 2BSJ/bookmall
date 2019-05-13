package bookmall.vo;

public class bookVo {
	private Long no;
	private String name;
	private int price;
	private Long category_no;
	private String categoryName;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "bookVo [no=" + no + ", name=" + name + ", price=" + price + ", category_no=" + category_no
				+ ", categoryName=" + categoryName + "]";
	}
	

	
	
}

