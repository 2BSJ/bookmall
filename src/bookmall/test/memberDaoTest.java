package bookmall.test;

import java.util.List;

import bookmall.dao.memberDao;
import bookmall.vo.memberVo;

public class memberDaoTest {

	public static void main(String[] args) {
		insertTest();
		getListTest();	
	}
	public static void insertTest() {
		memberDao dao = new memberDao();
		memberVo vo = new memberVo();
		     
		vo.setName("양승준");    
		vo.setPhone("010-9136-4365");   
		vo.setEmail("h3tmdwns@gmail.com");
		vo.setPassword("승준짱");
		dao.insert(vo);
		     
		vo.setName("장세언");    
		vo.setPhone("010-8790-0027");   
		vo.setEmail("tpdjs321@gmail.com");
		vo.setPassword("세언굿");
		dao.insert(vo);	
	}
	
	public static void getListTest() {
		memberDao dao = new memberDao();
		List<memberVo> list = dao.getList();
		
		for(memberVo vo:list)
			System.out.println("회원 이름 : " + vo.getName() + ", 연락처 :" + vo.getPhone()+ ", 이메일 :" + vo.getEmail() + ", 비밀번호 :" + vo.getPassword());
		
	}

}
