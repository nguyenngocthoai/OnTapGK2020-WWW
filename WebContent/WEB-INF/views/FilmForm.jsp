<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Form</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="themFilm" method="post">
		<table>
			<tr>
				<td>Tên</td>
				<td><input type="text" name="ten"></td>
			</tr>
			<tr>
				<td>Mô tả</td>
				<td><input type="text" name="mota">
				<td>
			</tr>
			<tr>
				<td>Thời gian phim</td>
				<td><input type="text" name="thoigianphim">
				<td>
			</tr>
			<tr>
				<td>Ngày khởi chiếu</td>
				<td><input type="date" name="ngaykhoichieu">
				<td>
			</tr>
			<tr>
				<td>Url</td>
				<td><input type="text" name="url">
				<td>
			</tr>
			<tr>
				<td>Thể loại</td>
				<td><select name="idCategory">
						<c:forEach var="c" items="${categories}">
							<option value="${c.idCategory}">
								<c:out value="${c.ten}">${c.ten}</c:out>
							</option>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td><input type="submit" value="Thêm"></td>
			</tr>
		</table>
	</form>
</body>
</html>