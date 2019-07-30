<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>
	<h2 align="center">게시글 목록</h2>


	<div class="container">
		<table class="table table-hover">
			<tr>
				<th>No</th>
				<th>Subject</th>
				<th>Writer</th>
				<th>Date</th>
			</tr>
			<c:forEach var="l" items="${list}">
				<tr onclick="location.href='/detail/${l.bno}'">
					<!-- 이 부분 수정! -->
					<td>${l.bno}</td>
					<td>${l.subject}</td>
					<td>${l.writer}</td>
					<td>${l.reg_date}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<center><button class="btn btn-primary" onclick="location.href='/insert'">글쓰기</button></center>

	<%@ include file="bootstrap.jsp"%>


</body>
</html>