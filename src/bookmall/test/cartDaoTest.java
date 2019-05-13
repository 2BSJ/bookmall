package bookmall.test;

import java.util.List;

import bookmall.dao.cartDao;
import bookmall.vo.cartVo;

public class cartDaoTest {

	public static void main(String[] args) {
		insertTest();
		getListTest();	
	}
	public static void insertTest() {
		cartDao dao = new cartDao();
		cartVo vo = new cartVo();
		
		
		vo.setBook_no(3L);
		vo.setMember_no(1L);
		vo.setAmount(3);
		
		dao.insert(vo);	

		vo.setBook_no(2L);
		vo.setMember_no(1L);
		vo.setAmount(3);
		
		dao.insert(vo);	
	}
	
	public static void getListTest() {
		cartDao dao = new cartDao();
		List<cartVo> list = dao.getList();
		
		for(cartVo vo:list)
			System.out.println("책 이름 : " + vo.getBookname() + ", 가격 :" + vo.getBookprice() + ", 수량 :" + vo.getAmount());
			//System.out.println(vo);
		
	}

}
