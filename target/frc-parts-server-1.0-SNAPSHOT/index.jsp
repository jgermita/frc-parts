<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <link rel="stylesheet" href="https://github.com/jgermita/frc-parts/assets/css/style.css?v=d8139605b0dd90d55894c44d25f8b60968487693">
    <meta name="viewport" content="width=device-width">
    <jsp:useBean id="partsbean" scope="session" class="com.frcparts.PartsDbHandler" />
    
    
    
    <head>
        <title>frcparts</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        <center>
	<img src="https://github.com/jgermita/frc-parts/raw/gh-pages/partslogo_small.png">
	<br>
	<h>soon&trade;</h><br><br>
        
        <a href="category.jsp?cat=electrical">Electrical</a>
        
        
        <br><br>
        <div><form action="results.jsp" method="post"> 
                <input type="text" name="query" value="" autocomplete="off">
                <input type="submit" value="Search"> 
        </form> </div>
        
        <footer>
            This page was last updated at: <%= partsbean.getCacheTimestamp() %>
            
        </footer>
        </center>
        
    </body>
</html>
