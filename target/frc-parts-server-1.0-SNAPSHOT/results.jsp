<%-- 
    Document   : results
    Created on : Nov 22, 2017, 10:54:00 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script> 
		$(function(){
			$("#common").load("common.html"); 
			$("#header").load("header.html"); 
			$("#footer").load("footer.html"); 
		});
	</script> 
	
	<div id="common"/>

    <head>
        <title>frcparts - search results - <%= partsbean.getQuery()%><></title>
		<div id="header"/>
	</head>

	<body>

	<div>
		<jsp:setProperty property="*" name="partsbean"/> 
		<%= partsbean.getSearchListings()%>
		<jsp:setProperty property="query" value="" name="partsbean"/> 
	</div>

	</body>
	
	<footer>
        <div id="footer"/>
	</footer>
</html>
