package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guestbook.dao.GuestBookDao;
import guestbook.domain.Article;
import guestbook.domain.GuestBookListView;
import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.domain.Member;
import member.domain.MemberListView;

public class GuestBookListService {

	private GuestBookListService() {}
	private static GuestBookListService service = new GuestBookListService();
	public static GuestBookListService getInstance() {
		return service;
	}
	
	public GuestBookListView getPage(int pageNum) {
		
		GuestBookListView listView = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			// 현재 페이지 번호
			int currentPage = pageNum;

			// 페이지 당 표현할 개수
			final int COUNT_PER_PAGE = 5;

			// 항목 가져오기 : limit index
			int index = (currentPage - 1) * COUNT_PER_PAGE;

			// List<Member> 구하기
			List<Article> list = GuestBookDao.getInstance().selectList(conn, index, COUNT_PER_PAGE);

			// 전체 회원의 수 구하기
			int totalCount = GuestBookDao.getInstance().selectTotalCount(conn);

			listView = new GuestBookListView(totalCount, COUNT_PER_PAGE, currentPage, list);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listView;
	}
	
	
}
