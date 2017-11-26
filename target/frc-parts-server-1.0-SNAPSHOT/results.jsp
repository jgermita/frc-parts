<%-- 
    Document   : results
    Created on : Nov 22, 2017, 10:54:00 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
    <link rel="shortcut icon" href="/favicon.ico" />
    <meta name="viewport" content="width=device-width">
    <jsp:useBean id="partsbean" scope="application" class="com.frcparts.PartsDbHandler" />
    
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	

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
		
	<script> 
		$(function(){
			$("#header").load("header.html"); 
			$("#footer").load("footer.html"); 
		});
	</script> 
</html>
