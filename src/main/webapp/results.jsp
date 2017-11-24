<%-- 
    Document   : results
    Created on : Nov 22, 2017, 10:54:00 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
    <jsp:useBean id="partsbean" scope="session" class="com.frcparts.PartsDbHandler" />
    
    
    
    <head>
        
    </head>
    <body>
        
        
        <div>
            <jsp:setProperty property="*" name="partsbean"/> 
            <%= partsbean.toTable() %>
            </div>
            
    </body>
</html>
