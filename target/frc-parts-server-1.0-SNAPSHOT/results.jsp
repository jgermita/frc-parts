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
        <title>frcparts - search results</title>
        
    </head>
    <body>
        <center>
            <a href="index.jsp"><img src="https://github.com/jgermita/frc-parts/raw/master/partslogo_small.png"></a>
	
        <br><br>
        <div><form action="results.jsp" method="post"> 
                <input type="text" name="query" value="" autocomplete="off">
                <input type="submit" value="Search"> 
        </form> </div> <br>
        
        </center>
        <div>
            <jsp:setProperty property="*" name="partsbean"/> 
            <%= partsbean.toTable() %>
            </div>
            
    </body>
</html>
