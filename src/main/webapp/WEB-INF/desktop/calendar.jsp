<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>calendar.jsp</title>

<script type="text/javascript">
	var year;
	var month;
	var date;

	function changeListener() {
// 		alert(this.value);
		var calc = new Date(year.value, (month.value - 1) + 1, 1);
		calc.setDate(calc.getDate()-1);
// 		alert("date = " + calc.toLocaleDateString());
		
		var options="";
		for (var i=0; i<calc.getDate(); i++) {
			options += "<option> " + (i+1)  +"일</option>\n";
		}
		
		
		date.innerHTML = options;//안의 option child를 오버라이드를 한것과 같은 개념이다.
		result.innerHTML = options;
		
	};

	window.onload = function() {
		year = document.querySelector("select[name=year]");
		month = document.querySelector("select[name=month]");
		date = document.querySelector("select[name=date]");
		

		year.onchange = changeListener;
		month.onchange = changeListener;

	};
</script>

</head>
<body>
	<hr>
	<h1>Calendar</h1>
	<hr>


	<input name="year" type="range" min="2000" max="2100" value="2015" />
	<br>
	<input name="year" type="number" min="2000" max="2100" value="2015" />
	<br>

	<hr>

	<%
		Date current = new Date();
		pageContext.setAttribute("current", current);

		Date calc = new Date(current.getYear(), current.getMonth() + 1, 1);
		calc.setDate(calc.getDate() - 1);
		pageContext.setAttribute("calc", calc);
		
		Date calc2 = new Date(current.getYear(), current.getMonth(), 1);
		pageContext.setAttribute("calc2",calc2);
		
		
	%>


	<select name="year">
		<c:forEach var="year" begin="2000" end="2020">

			<c:if test="${year ==  current.year + 1900}">
				<option value="${year}" selected="selected">${year}년도</option>
			</c:if>

			<c:if test="${year !=  current.year + 1900}">
				<option value="${year}">${year}년도</option>
			</c:if>

		</c:forEach>

	</select>

	<select name="month">
		<c:forEach var="month" begin="1" end="12">
			<c:if test="${month == current.month +1}">
				<option value="${month}" selected="selected">${month}월</option>
			</c:if>
			<c:if test="${month !=current.month + 1}">
				<option value="${month}">${month}월</option>
			</c:if>
		</c:forEach>
	</select>


	<select name="date">
		<c:forEach var="date" begin="1" end="${calc.date}">
			<c:if test="${date == current.date}">
				<option value="${date}" selected="selected">${date}월</option>
			</c:if>
			<c:if test="${date !=current.date + 1}">
				<option value="${date}">${date}월</option>
			</c:if>
		</c:forEach>
	</select>
	
	
<div id = "result" style="border: 1px solid red; height: 200px; width: 200px">
	<table style="border: 1px solid black; border-collapse: collapse; height: 200px;width: 200px">	
		<c:forEach var="date" begin="1" end="${calc.date}" varStatus="status">
			<c:if test="${status.index % 7 == 0}"><tr></c:if>
			<td>${pageScope.date}</td>
			<c:if test="${status.index % 7 == (7-1)}"></tr></c:if>
		</c:forEach>
	</table>
</div>
	


</body>
</html>