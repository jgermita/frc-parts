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
	<%
		partsbean.searchPart(request.getParameter("p"));
	%>


    <head>
        <title>frcparts - part- <%= partsbean.searched.getName() %></title>
		<jsp:include page="header.html" />
    </head>

    <body>
		<div class="pure-g">
			<div class="pure-u-1-8"></div>
			<div class="pure-u-3-4">

				<div class="pure-g">
					<div class="pure-u-1-2">
						<h1><%= partsbean.searched.getName() %></h1>
            <small>
                <a href="category.jsp?cat=<%= partsbean.searched.getCat() %>"><%= partsbean.searched.getCat() %></a> / <%= partsbean.searched.getSubcat() %>
            </small><br>
            <p>
              <%= partsbean.searched.getDesc() %>
            </p>

					</div>
					<div class="pure-u-1-2">
            <br><br>

            <table class="pure-table pure-table-horizontal pure-table-odd">
  						<tr><td><b>Vendor</b></td> <td><a href="<%= partsbean.searched.getUrl() %>"><%= partsbean.searched.getVendor() %></a></td>
  						<tr><td><b>P/N</b></td> <td><%= partsbean.searched.getPn() %></td>
              <tr><td><b>Cost(USD)</b></td> <td><%= partsbean.searched.getCost() %></td>
              <tr><td><b>Tags</b></td> <td><%= partsbean.searched.getTagsList() %></td>
              <tr><td><b>ID</b></td> <td><%= partsbean.searched.getId() %></td>
              <tr><td><b>Recommendation Source</b></td> <td><a href="<%= partsbean.searched.getSource() %>">Source</a></td>
            </table>

					</div>
				</div>

			</div>
			<div class="pure-u-1-8"></div>
		</div>

    </body>

	<jsp:include page="footer.jsp" />
</html>
