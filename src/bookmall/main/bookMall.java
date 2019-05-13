package bookmall.main;

import bookmall.test.bookDaoTest;
import bookmall.test.cartDaoTest;
import bookmall.test.categoryDaoTest;
import bookmall.test.memberDaoTest;
import bookmall.test.ordersDaoTest;

public class bookMall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//메인만 실행시키시면 입력부터 출력까지 됩니다.
		
		categoryDaoTest.insertTest();//----끝
		bookDaoTest.insertTest(); //----끝
		memberDaoTest.insertTest(); //----끝
		ordersDaoTest.insertTest(); //----끝
		cartDaoTest.insertTest(); //----끝
		
 
		
		System.out.println("==================카테고리===================");
		categoryDaoTest.getListTest();
		System.out.println("\n==================서적===================");
		bookDaoTest.getListTest();
		System.out.println("\n==================회원===================");
		memberDaoTest.getListTest();
		System.out.println("\n==================주문===================");
		ordersDaoTest.getListTest();
		System.out.println("\n==================카트==================="); //카트 유저부분 1로 고쳐줘야함
		cartDaoTest.getListTest();
		//ordersDaoTest.getListTest();
	}

}
