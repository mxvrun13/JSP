<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function fileDown(orgFile, downFile) {
		frm.orgFile.value = orgFile;
		frm.downFile.value = downFile;
		frm.submit();
	}
</script>
<title>File List</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>파일 목록</h1>
		</div>
		<div>
			<table border="1">
				<c:forEach var="file" items="${files }">
					<tr>
						<td width="70" align="center">내용</td>
						<td width="300"><textarea rows="7" cols="100" id="subject"
								name="suject">${file.subject }</textarea></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td style="cursor:pointer;" onclick="fileDown('${file.fileName }', '${file.downFile }')">${file.fileName }<input type="hidden"
							value="${file.downFile }"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div>
		<form id="frm" name="frm" action="fileDownload.do" method="post">
			<input type="hidden" id="orgFile" name="orgFile">
			<input type="hidden" id="downFile" name="downFile">
		</form>
	</div>
</body>
</html>