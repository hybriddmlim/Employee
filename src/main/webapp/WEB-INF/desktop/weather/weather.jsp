<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>weather.jsp</title>
</head>
<body>
	<hr>
	<h1>날씨 정보 조회 결과</h1>
	<hr>
${requestScope.weather.current.temperature}<br>


${requestScope.weather.forecasts[1].low} <br>

</body>
</html>