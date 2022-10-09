<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.review.model.vo.Review, java.util.ArrayList, com.kh.review.model.vo.ReviewAttachment" %>
<% 
	Review r = (Review)request.getAttribute("r");
	ReviewAttachment rat = (ReviewAttachment)request.getAttribute("rat");
	//ArrayList<ReviewAttachment> ratList = (ArrayList<ReviewAttachment>)request.getAttribute("ratList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰수정페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style>
    .container{
		max-width: 1000px;
		min-height: 1000px;
		margin-top: 15px;
        margin-bottom: 50px;
	}
	.page-title{
		text-align: center;
		margin-bottom: 15px;
		font-weight: bold;
	}
	table>thead>tr>th{
		text-align: center;
		font-size: 18px;
	}
	.btnBlue{
		color: white;
		background-color: rgb(63, 74, 224);
	}
	.btnBlue:hover{
        color:white;
        background-color: rgb(35, 45, 182);
    }
</style>
</head>
<body>

	<%@ include file="../common/header2.jsp" %>
	
    <div class="container">
        <br>
        <h3 class="page-title">리뷰게시판</h3>

        <form enctype="multipart/form-data" action="<%=contextPath%>/update.rv" method="post">
			<input type="hidden" name="rno" value="<%=r.getReviewNo()%>">
            <table class="table table-borderless">
                <thead class="thead-light">
                    <tr>
                        <th style="text-align: center;" colspan="2">리뷰수정</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th style="width: 125px;">제목:</th>
                        <td><input type="text" name="reviewTitle" class="form-control" placeholder="글 제목" maxlength="50" value="<%=r.getReviewTitle()%>"></td>
                    </tr>
                    <tr>
                      <th>후원프로젝트:</th>
                      <td>
                        <select name="projectName" class="custom-select" style="width: 400px;" disabled>
                            <option value="<%=r.getSupportNo()%>" selected><%=r.getProjectName()%></option>
                        </select>
                      </td>
                    </tr>
                    <tr>
                      <th>별점:</th>
                      <td>
                        <select id="rate" name="rate" class="custom-select" style="width: 100px;">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                        <script>
                        	$(function(){
                        		$("#rate option").each(function(){
                        			if($(this).text() == "<%=r.getRate()%>"){
                        				$(this).attr("selected", "true");
                        			}
                        		})
                        	});
                        </script>
                      </td>
                    </tr>
                    <tr>
                        <th>사진첨부:</th>
                        <td>
                        	<% if( rat != null) { %>
                        		<img id="contentImg" src="<%=contextPath%>/<%=rat.getFilePath()+rat.getChangeName()%>" width="200"><br>
                        		<div id="contentImg-fileName"><%=rat.getOriginName()%></div>
                        		<input type="hidden" name="originFileNo" value="<%=rat.getFileNo()%>">
                        		<input type="hidden" name="originFileName" value="<%=rat.getChangeName()%>">
                        	<% } else { %>
                        		<img id="contentImg" src="./resources/img/noimage.png" width="200"><br>
                        	<% } %>
                        </td>
                    </tr>
                    <tr>
                    	<th><input type="hidden" id="checkDeleteOrigin" name="checkDeleteOrigin" value=""></th>
                    	<td><input id="reUpfile1" type="file" name="reUpfile1" onchange="loadImg(this,1)"><input type="button" value="파일 삭제" onclick="fileReset(this.form);"></td>
                    </tr>
                    <tr>
                        <th>내용:</th>
                        <td><textarea name="reviewContent" class="form-control" rows="10" placeholder="내용을 입력해주세요" style="resize: none;"><%=r.getReviewContent()%></textarea></td>
                    </tr>
                </tbody>	
            </table>

			<script>
	        	function loadImg(inputFile, num){
	        		if(inputFile.files.length == 1){
						var reader = new FileReader();

						reader.readAsDataURL(inputFile.files[0]);

						reader.onload = function(e){
							$("#contentImg").attr("src", e.target.result);
							$("#contentImg-fileName").attr("style", "display:none;");
						}
					}
	        	}
	        	
	        	function fileReset(form){
	        		$("#reUpfile1").val(""); // 새 첨부파일 삭제
	        		$("#contentImg").attr("src", "./resources/img/noimage.png"); // 디폴트 사진으로 띄우기
	        		<% if(rat != null) { %> // 원본파일이 있을 경우
	        			$("#checkDeleteOrigin").val("deleteOrigin"); // 원본파일 삭제
	        			$("#contentImg-fileName").attr("style", "display:none;"); // 원본 파일 이름 숨기기
	        		<% } %>
	        		
	        	}
            </script>
            <hr>

            <div align="center">
                <a href="<%=contextPath%>/detail.rv?rno=<%=r.getReviewNo()%>" class="btn btn-secondary">돌아가기</a>
                <button type="submit" class="btn btnBlue">작성완료</button>
            </div>

        </form>

    </div>
    
    <%@ include file="../common/footer.jsp" %>
</body>
</html>