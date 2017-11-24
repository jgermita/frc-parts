<%-- 
    Document   : results
    Created on : Nov 22, 2017, 10:54:00 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="shortcut icon" href="/favicon.ico" />
    <jsp:useBean id="partsbean" scope="application" class="com.frcparts.PartsDbHandler" />
    
    <head>
        <title>frcparts - category - <%= partsbean.getCategory() %></title>
        <center>
            <a href="index.jsp"><img src="https://github.com/jgermita/frc-parts/raw/master/partslogo_small.png"></a>
	<br>
	<h>soon&trade;</h><br><br>
        
        <a href="category.jsp?cat=electrical">Electrical</a>
        
        <br><br>
        <div>
            <form action="results.jsp" method="post"> 
                <input type="text" name="query" value="" autocomplete="off">
                <input type="submit" value="Search"> 
            </form> 
        </div>
        
        </center>
    </head>
    
    <body>
        
        <br><br>
        
        <div>
            
            <%= partsbean.getCategory(request.getParameter("cat")) %>
            
        </div>
            
    </body>
</html>
