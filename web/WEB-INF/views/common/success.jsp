<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function() {
			const successCode = "${ requestScope.successCode }";
			
			let successMessage = "";
			let movePath = "";
			
			switch(successCode){
			case "registMember" : 
				successMessage = "회원 가입에 성공하였습니다.";
				movePath = "${ pageContext.servletContext.contextPath }";
				break;
			case "updateMember" : 
				successMessage = "회원 정보 수정에 성공하였습니다.";
				movePath = "${ pageContext.servletContext.contextPath }";
				break;
			case "deleteMember" : 
				successMessage = "회원 탈퇴에 성공하였습니다.";
				movePath = "${ pageContext.servletContext.contextPath }";
				break;
			case "insertNotice" : 
				successMessage = "공지사항 등록에 성공하였습니다.";
				movePath = "${ pageContext.servletContext.contextPath }/notice/list";
				break;
			case "updateNotice" : 
				successMessage = "공지사항 수정에 성공하였습니다.";
				movePath = "${ pageContext.servletContext.contextPath }/notice/list";
				break;
			}
			
			alert(successMessage);
			location.href = movePath;
		})();
	</script>
</body>
</html>