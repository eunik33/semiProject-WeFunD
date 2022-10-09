package com.kh.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.PageInfo;
import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Review;

/**
 * Servlet implementation class ReviewListController
 */
@WebServlet("/list.rv")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ----------- 페이징 처리 ---------------
		int listCount; // 현재 게시글 총 개수 => REVIEW로부터 조회 COUNT(*)활용(STATUS='Y')
		int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지) => request.getParameter("cpage");
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 개수 => 10개로 고정
		int boardLimit; // 한 페이지에 보여질 게시글의 최대 개수 => 10개로 고정
		
		int maxPage; // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지의 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝 수
		
		// * listCount : 총 게시글 개수
		listCount = new ReviewService().selectListCount();
		
		// * currentPage : 현재페이지(== 사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		// * pageLimit : 페이징바의 페이지 최대 개수
		pageLimit = 10;
		
		// * boardLimit : 한 페이지에 보여질 게시글의 최대 개수
		boardLimit = 12;
		
		// * maxPage : 가장 마지막 페이지가 몇 번 페이지인지(총 페이지 개수)
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// *startPage : 페이지 하단에 보여질 페이징바의 시작수
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		// * endPage : 페이지 하단에 보여질 페이징바의 끝수
		endPage = startPage + pageLimit - 1;
		
		// startPage가 11이어서 endPage에는 20이 들어갔는데
		// maxPage가 13이라면???
		// => endPage값을 maxPage값으로 변경
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
				maxPage, startPage, endPage);
		
		ArrayList<Review> list = new ReviewService().selectReviewList(pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi",pi);
		
		request.getRequestDispatcher("views/review/reviewListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
