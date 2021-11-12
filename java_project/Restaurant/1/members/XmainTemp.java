package members;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;

public class XmainTemp {
	public static void main(String[] args) {

		MembersDao memDao = MembersDao.getInstance();
		List<Members> list = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

//			System.out.println("추가");
//			Members newMem = new Members("카리나", "010-9999-4204");
//			System.out.println("1= "+memDao.insertMember(conn, newMem));
//			
//			conn.commit();

//			System.out.println("추가");
//			Members newMem = new Members("카리나", "010-0000-4204");
//			System.out.println("1= "+memDao.insertMember(conn, newMem));
//			
//			conn.commit();

			System.out.println("전체출력");
			list = memDao.selectAllMembers(conn);
			System.out.println("----------------------------------------------");
			System.out.println("회원번호\t이름\t연락처\t\t방문횟수\t회원등급");
			System.out.println("----------------------------------------------");
			for (Members mem : list) {
				System.out.println(mem);
			}

			System.out.println("이름으로 출력");
			System.out.println("----------------------------------------------");
			System.out.println("회원번호\t이름\t연락처\t\t방문횟수\t회원등급");
			System.out.println("----------------------------------------------");
			list = memDao.selectByName(conn, "카리나");
			for (Members mem : list) {
				System.out.println(mem);
			}

			System.out.println("번호로 출력");
			System.out.println("----------------------------------------------");
			System.out.println("회원번호\t이름\t연락처\t\t방문횟수\t회원등급");
			System.out.println("----------------------------------------------");
			list = memDao.selectByPhone(conn, "4204");
			for (Members mem : list) {
				System.out.println(mem);
			}

			System.out.println("수정");
			memDao.updateMember(conn, 1, "테스트", "테스트");

			conn.commit();

			System.out.println("삭제");
			memDao.deleteMember(conn, 1);

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
