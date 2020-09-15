<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>요청처리 과정에서 에러가 발생하였습니다..</h2>
	<hr>
	
	<p>에러 타입: <%=exception.getClass().getName() %></p>
	<p>에러 메시지: <%=exception.getMessage() %></p>
	
	<h3>StackTraceElements</h3>
	<%
	StackTraceElement[] elements = exception.getStackTrace();
	
	if (elements != null) {
		for (StackTraceElement element : elements) {
			out.println("<p>" + element.toString() + "</p>");
		}
	}
	%>
</body>
</html>