<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh Sách Phim</title>
</head>
<style>
.hinh {
	width: 160px;
	height: 200px;
}
.a{
	width: 160px;
	height: 200px;
	text-align: center;
	padding: 5px;
	margin: 10px;
	float: left;
}
.b{
	clear: both;
}
</style>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<c:forEach var="dm" items="${categories }">
		<li>Tên DM: ${dm.ten}</li>
		<div class="w3-container">
			<table border="1" class="w3-table w3-striped">
				<tr>
					<th>Mã</th>
					<th>Tiên</th>
					<th>Ngày Khởi Chiếu</th>
					<th>Thời Gian Phim</th>
					<th>Mô Tả</th>
					
				</tr>
				<c:forEach var="f" items="${dm.films }">
					<tr>
						<td>${f.idFilm}</td>
						<td>${f.ten}</td>
						<td>${f.ngayKhoiChieu}</td>
						<td>${f.thoiGianPhim}</td>
						<td>${f.moTa}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:forEach>
	
	
	<c:forEach var="c" items="${categories}">
		
		<h3>${c.ten}</h3>
		
		<c:forEach var="f" items="${c.films}">
			<div class="a">
				<img alt="" class="hinh" src="images/${f.url}"><br/>
				<strong>${f.ten}</strong><br/>
			</div>
		</c:forEach>
		<div class="b"></div>
	</c:forEach>

</body>
</html>