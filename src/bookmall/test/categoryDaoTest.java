package bookmall.test;

import java.util.List;

import bookmall.dao.categoryDao;
import bookmall.vo.categoryVo;

public class categoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		getListTest();	
	} 
	public static void insertTest() {
		categoryDao dao = new categoryDao();
		categoryVo vo = new categoryVo();
		
		vo.setNo(1L);
		vo.setName("시집");
		dao.insert(vo);
		
		vo.setNo(2L);
		vo.setName("소설");
		dao.insert(vo);
		
		vo.setNo(3L);
		vo.setName("위인전");
		dao.insert(vo);	
	}
	
	public static void getListTest() {
		categoryDao dao = new categoryDao();
		List<categoryVo> list = dao.getList();
		
		for(categoryVo vo:list)
			System.out.println("카테고리 이름 :" + vo.getName());
		
	}

}
