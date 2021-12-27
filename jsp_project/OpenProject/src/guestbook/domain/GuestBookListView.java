package guestbook.domain;

import java.util.List;

public class GuestBookListView {

	private int pageTotalCount; // 페이지 개수
	private int totalCount; // 전체 행의 개수(회원의 수)
	private int countPerPage; // 한 페이지에 출력할 행의 개수
	private int currentPage; // 현재 페이지 번호
	private List<Article> list; // 출력할 데이터 항목 리스트

	public GuestBookListView(int totalCount, int countPerPage, int currentPage, List<Article> list) {
		this.totalCount = totalCount;
		this.countPerPage = countPerPage;
		this.currentPage = currentPage;
		this.list = list;
		calTotalPageCount();
	}

	private void calTotalPageCount() {

		pageTotalCount = totalCount / countPerPage;

		if (totalCount % countPerPage > 0) {
			pageTotalCount++;
		}

	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Article> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "GuestBookListView [pageTotalCount=" + pageTotalCount + ", totalCount=" + totalCount + ", countPerPage="
				+ countPerPage + ", currentPage=" + currentPage + ", list=" + list + "]";
	}

	

}
