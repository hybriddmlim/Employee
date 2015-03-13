<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>
	<hr>
	<h1>날씨 정보 조회</h1>
	<hr>

<!-- 	<form action="/Employee/desktop/weather/show" method="post"> -->
<!-- /Employee/desktop/weather/show 와 맵핑된 method로 값을 전달하겠다는 것이다.-->


<c:url var="url" value="/desktop/weather/show"/>
	<form action="${pageScope.url}" method="post"> <!-- Emloyee의 하드코딩을 하지않고 나중ㅇ ㅔ프로젝트가 바뀌어도 수정하지 않아도 좋도록 만든다. -->
		Location : 
		<select name="city"><!--  name 은 파라미터 이름이다. -->
			<option value="서울" label="@서울" />
			<option value="인천" label="@인천" />
			<option value="경기" label="@경기" selected="selected" /><!-- selected 는 default 값으로 설정된다. -->
			<option value="대전" label="@대전" />
			<option value="부산" label="@부산" />
		</select> 
		<input type="submit" value="조회" />

	</form>

</body>
</html>