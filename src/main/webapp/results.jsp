<%-- 
    Document   : results
    Created on : Nov 22, 2017, 10:54:00 PM
    Author     : Jeremy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <link rel="stylesheet" href="https://github.com/jgermita/frc-parts/assets/css/style.css?v=d8139605b0dd90d55894c44d25f8b60968487693">
    <meta name="viewport" content="width=device-width">
    <jsp:useBean id="partsbean" scope="session" class="com.frcparts.PartsDbHandler" />
    
    
    
    <head>
        <title>frcparts - search results</title>
        
    </head>
    <body>
        <center>
	<img src="https://github.com/jgermita/frc-parts/raw/gh-pages/partslogo_small.png">
	<br>
	<h>soon™</h>
        
        <br><br>
        
        <div>
            <jsp:setProperty property="*" name="partsbean"/> 
            <%= partsbean.toTable() %>
            </div>
            </center>
            
    </body>
</html>
