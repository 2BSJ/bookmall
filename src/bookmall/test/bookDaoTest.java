package bookmall.test;


import java.util.List;

import bookmall.dao.bookDao;
import bookmall.vo.bookVo;

public class bookDaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();	
	} 
	public static void insertTest() {
		bookDao dao = new bookDao();
		bookVo vo = new bookVo();
		
		vo.setNo(1L);
		vo.setName("윤동주 시집");
		vo.setPrice(10000);
		vo.setCategory_no(1L);
	
		dao.insert(vo);	
		
		vo.setNo(2L);
		vo.setName("해리포터");
		vo.setPrice(30000);
		vo.setCategory_no(2L);
		
		dao.insert(vo);
		
		vo.setNo(3L);
		vo.setName("이순신은 명장");
		vo.setPrice(50000);
		vo.setCategory_no(3L);
		
		dao.insert(vo);	
	}
	
	public static void getListTest() {
		bookDao dao = new bookDao();
		List<bookVo> list = dao.getList();
		
		for(bookVo vo:list) {
			System.out.println("책 이름 : " + vo.getName() + ", 가격 :" + vo.getPrice() + ", 카테고리 :" + vo.getCategoryName());
		}
		
	}
}
