package bookmall.test;

import java.util.List;

import bookmall.dao.ordersDao;
import bookmall.vo.book_orderVo;
import bookmall.vo.ordersVo;

public class ordersDaoTest {

	public static void main(String[] args) {
		insertTest();
		getListTest();	
	} 
	public static void insertTest() {
		ordersDao dao = new ordersDao();		
		
		ordersVo vo = new ordersVo();
		book_orderVo bvo = new book_orderVo();
		
//		
		vo.setNo(1L);
		vo.setOrdernum("190513001");
		vo.setPrice(50000);
		vo.setDestination("남양주 호평동 남양 마동");
		vo.setMember_no(1L);
		
		dao.insert(vo);
		
		bvo.setBook_no(1L);
		bvo.setAmount(2);
		
		dao.insert(bvo);
		
		

	}
	
	public static void getListTest() {
		ordersDao dao = new ordersDao();
		List<ordersVo> list = dao.getList();
		List<book_orderVo> blist = dao.getBookOrderList(1L);
		
		for(ordersVo vo:list)
			System.out.println("주문자 이름 :" + vo.getMembername() + ", 주문번호 : " + vo.getOrdernum() + ", 가격 :" + vo.getPrice() + ", 배송지 :" + vo.getDestination() );
		System.out.println("\n==================주문도서===================");
		for(book_orderVo bvo : blist)
			System.out.println("책 이름 : " + bvo.getBookname()+ ", 가격 :" + bvo.getBookprice() + ", 수량 :" + bvo.getAmount());
		//------------------------------------
		
	}

}
