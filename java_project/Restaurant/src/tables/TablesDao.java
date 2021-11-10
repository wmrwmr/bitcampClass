package tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;

public class TablesDao {
	// 인스턴스 하나만 만들어 사용하도록 하는 패턴
	// 외부에서 인스턴스를 생성하지 못하도록 처리! -> 생성자의 접근제어자를 private
	private TablesDao() {
	}

	// 클래스 내부에서 인스턴스를 생성!!!, 이 인스턴스를 직접 접근 안되도록!
	private static TablesDao dao = new TablesDao();

	// 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 해주자!!! (싱글톤 패턴)
	static public TablesDao getInstance() {
		return dao;
	}
	

	
	
	
}
