<%-- 
    Document   : results
    Created on : Nov 22, 2017, 10:54:00 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <jsp:useBean id="partsbean" scope="session" class="com.frcparts.PartsDbHandler" />
    
    
    
    <head>
        <title>frcparts - category - <%= request.getParameter("cat") %></title>
        
    </head>
    <body>
        <center>
            <a href="index.jsp"><img src="https://github.com/jgermita/frc-parts/raw/gh-pages/partslogo_small.png"></a>
	<br>
        </center>
        
        <br><br>
        <div><form action="results.jsp" method="post"> 
                <input type="text" name="query" value="" autocomplete="off">
                <input type="submit" value="Search"> 
        </form> </div> <br>
        
        
        <br><br>
        
        <div>
            
            <%= partsbean.getCategory(request.getParameter("cat")) %>
            </div>
            
    </body>
</html>
