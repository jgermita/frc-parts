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
        
        
        <br><br>
        
        <div>
            
            <%
                
                partsbean.setCategory(request.getParameter("cat"));
            %>
            </div>
            
    </body>
</html>
