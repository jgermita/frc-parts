<%-- 
    Document   : results
    Created on : Nov 22, 2017, 10:54:00 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
	<link rel="stylesheet" href="blog.css">
    <link rel="shortcut icon" href="/favicon.ico" />
    <meta name="viewport" content="width=device-width">
    <jsp:useBean id="partsbean" scope="application" class="com.frcparts.PartsDbHandler" />
    

    <head>
        <title>frcparts - search results - <%= partsbean.getQuery()%><></title>
		<jsp:include page="header.html" />
	</head>

	<body>

		<div class="pure-g">
			<div class="pure-u-1-6"></div>
			<div class="pure-u-2-3">
				<h1>Search Results:</h1>

				<jsp:setProperty property="*" name="partsbean"/> 
				<%= partsbean.getSearchListings()%>
				<jsp:setProperty property="query" value="" name="partsbean"/> 
			</div>
			<div class="pure-u-1-6"></div>
		</div>

	</body>
	
	<jsp:include page="footer.html" />
</html>
