package temFroject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
	private OrderDAO dao;
	private Scanner sc;
	ArrayList<Order> list = null;
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";
	
	public OrderManager(OrderDAO dao){
		this.dao = dao;
		sc = new Scanner(System.in);
	}
	
	void list() {
		// Connection 객체 생성 -> 트렌젝션 처리
		Connection conn = null;

		// 2. 연결

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			List<Product> list = dao.getOrderList(conn);

			System.out.println("-----------메뉴입니다-----------");
			System.out.println("-----------------------------");
			System.out.println("상품번호 \t 상품이름 \t 상품가격");
			System.out.println("-----------------------------");
			
			for (Product pro : list) {
				System.out.printf("%d \t %s \t %s \n", pro.getIcode(), pro.getIname(), pro.getIprice());
			}
			
			list = new ArrayList<>();
			int odercode = (int) System.nanoTime();
			
			System.out.println("-------------------------------");
			System.out.println("주문하실 메뉴번호를 입력해주세요.");
			int input = sc.nextInt();
			System.out.println("-------------------------------");
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("예시) 메뉴번호 갯수");
			String inputData = sc.nextLine();
			String[] deptData = inputData.split(" ");
			
			Order order = new Order(0, 0, Integer.parseInt(deptData[0]), 0, null, 0, Integer.parseInt(deptData[1]));
			

			int result = dao.insert(conn, order);

			if(result > 0) {
				System.out.println("입력되었습니다.");
			} else {
				System.out.println("입력 실패!!!!");
			}
//			
//			while(true) {
//				Order o = new Order();
//				System.out.println("주문하실 메뉴를 입력하세요.");
//				int num = sc.nextInt();
//				System.out.println("수량을 입력해주세요.");
//				int sum = sc.nextInt();
//				
//			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void input() {

		// Connection 객체 생성 -> 트렌젝션 처리 가능
		Connection conn = null;
		try {
			
			list = new ArrayList<>();
			int odercode = (int) System.nanoTime();
			
			System.out.println("-------------------------------");
			System.out.println("주문하실 메뉴번호를 입력해주세요.");
			int input = sc.nextInt();
			System.out.println("-------------------------------");
			
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			Order order = new Order(odercode, 0, 0, 0, null, 0, 0);
			

			int result = dao.insert(conn, order);

			if(result > 0) {
				System.out.println("입력되었습니다.");
			} else {
				System.out.println("입력 실패!!!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getStrInput(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	private int getNumInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}

	
	private int menus() {
		System.out.println("어서오세요. 아이스크림 가게 입니다.");
		return getNumInput("[1]메뉴보기 [2]장바구니 [3]주문목록보기 [3] 결제 [5]종료");
	}
	
	
	public void menu() {
		
	}

	public void run() {

		int key = 0;
		while((key = menus()) != 0) {
			switch(key) {
			case 1:
				list();
				break;
			case 2:
//				MemberJoin();
				break;
			case 3:
//				SelectMember();
				break;
			case 4:
//				munus();
				break;
			}
		}
	}
}

