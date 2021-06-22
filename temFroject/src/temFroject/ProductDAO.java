package temFroject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {

	private ProductDAO() {
	}

	static private ProductDAO dao = new ProductDAO();

	public static ProductDAO getInstance() {
		return dao;
	}


	ArrayList<Product> getProductList(Connection conn) {

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
			while (rs.next()) {

				Product d = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));

				list.add(d);
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

			if (stmt != null) {
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


}