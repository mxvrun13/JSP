<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<script type="text/javascript">
	function getRecord(n) {
		frm.bId.value=n;
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div><h1>공지사항 목록</h1></div>
		<div>
			<table border="1">
				<tr>
					<th width="70">번호</th><th width="300">제목</th><th width="150">작성자</th><th width="150">작성일</th><th width="70">조회수</th>
				</tr>
				<c:forEach var="board" items="${boards }"> <!-- boards = boardlist의 setattri~ -->
					<tr onmouseover="this.style.background='lightpink'" onmouseout="this.style.background='white'"
						onclick="getRecord(${board.bId })"> <!-- vo의 변수명과 일치 -->
						<td align="center">${board.bId }</td><td>${board.bTitle }</td><td align="center">${board.bWriter }</td><td align="center">${board.bDate }</td><td align="center">${board.bHit }</td>
					</tr>
				</c:forEach>
			</table>
		</div><br>
		<div>
			<button type="button" onclick="location.href='home.do'">홈 가기</button> &nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='insertForm.do'">새 글 작성</button>
		</div>
		<div>
			<form id="frm" name="frm" action="boardSelect.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
		</div>
	</div>
</body>
</html>