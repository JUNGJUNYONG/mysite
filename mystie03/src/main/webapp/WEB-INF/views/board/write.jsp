<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form class="board-form" method="post"
					action="/mysite03/board/write">
					
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글쓰기</th>
						</tr>

						<c:choose>
							<c:when test="${vo.title != null }">
								<tr>
									<td class="label">제목</td>
									<td><input type="text" name="title"
										value="re) ${vo.title }">
										<input type='hidden' name="oNo" value="${vo.oNo }"/>
										<input type='hidden' name="no" value="${vo.no }"/>
										</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td class="label">제목</td>
									<td><input type="text" name="title" value=""></td>
								</tr>
							</c:otherwise>
						</c:choose>
						<tr>
							<td class="label">내용</td>
							<td><textarea id="content" name="contents" ></textarea></td>
						</tr>
					</table>

					<c:choose>
						<c:when test="${no != null }">
							<div class="bottom">
								<a href="mysite03/board">취소</a> <input type="submit" value="등록">
							</div>
						</c:when>
						<c:otherwise>
							<div class="bottom">
								<a href="mysite03/board">취소</a> <input type="submit" value="등록">
							</div>

						</c:otherwise>
					</c:choose>



				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>