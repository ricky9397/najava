package temFroject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDAO {
	// 싱글톤
	private OrderDAO() {
	}
	static private OrderDAO dao = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return dao;
	}
	
	ArrayList<Product> getOrderList(Connection conn){
		
		ArrayList<Product> list = null;
		
		// 데이터 베이스의 Dept테이블 이용 select 결과를 -> list 저장
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from product";
			
			// 결과 받아오기
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			// 데이터를 Dept 객체로 생성 -> list에 저장
			while(rs.next()) {
				
				Product menuList = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(menuList);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return list;
	} 
	
	
	int insert(Connection conn, Order order) {

		int result = 0;
		// 전달받은 Dept 객체의 데이터로 Dept 테이블에 저장 -> 결과
		PreparedStatement pstmt = null;


		try {

			String sql = "insert into iorder values (1, 1, ?, 1, sysdate, 3, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, order.getIcod());
			pstmt.setInt(2, order.getCount());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}
	
//	int Order(Connection con, Order order) {
//	    
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		
//	    try {
//	    	String sql = "INSERT INTO order VALUES (?, ?, ?, ?, ?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, order.getId());
//			pstmt.setString(2, order.getPw());
//
//			
//			result = pstmt.executeUpdate();
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if(pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return result;
//		
//	}
}
