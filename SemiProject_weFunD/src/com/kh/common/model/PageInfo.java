package com.kh.common.model;

public class PageInfo {

	private int listCount; // 현재 일반게시판의 게시글 총갯수 => BOARD로 부터 조회 COUNT(*)활용(STATUS = 'Y')
	private int currentPage; // 현재 페이지 (즉, 사용자가 요청한 페이지) => request.getParameter("cpage");
	private int pageLimit; // 페이지하단에 보여질 페이징바의 최대 갯수 => 10개로 고정
	private int boardLimit; // 한 페이지에 보여질 게시글의 쵀대 갯수 => 10개로 고정
	private int maxPage; // 가장 마지막 페이지가 몇번 페이지 인지(총페이지의 갯수)
	private int startPage; // 페이지 하단에 보여질 페이징바의 시작 수
	private int endPage; // 페이지 하단에 보여질 페이징바의 끝 수
	
	private int projectListCount; // 현재 일반게시판의 게시글 총 개수 => BOARD로부터 조회 COUNT(*)활용(STATUS='Y')
	private int projectLimit; // 한 페이지에 보여질 게시글의 최대 개수 => 10개로 고정
	public PageInfo() {
		super();
	}
	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.projectLimit = boardLimit;
		this.projectListCount = listCount;
	}
	
	
	public int getProjectListCount() {
		return projectListCount;
	}
	public void setProjectListCount(int projectListCount) {
		this.projectListCount = projectListCount;
	}
	public int getProjectLimit() {
		return projectLimit;
	}
	public void setProjectLimit(int projectLimit) {
		this.projectLimit = projectLimit;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public int getBoardLimit() {
		return boardLimit;
	}
	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "Pageinfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
}
