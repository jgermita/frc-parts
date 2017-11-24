<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <link rel="stylesheet" href="https://github.com/jgermita/frc-parts/assets/css/style.css?v=d8139605b0dd90d55894c44d25f8b60968487693">
    <link rel="shortcut icon" href="/favicon.ico" />
    <meta name="viewport" content="width=device-width">
    <jsp:useBean id="partsbean" scope="application" class="com.frcparts.PartsDbHandler" />
    
    <head>
        <title>frcparts</title>
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
        
    </body>
    
    <footer>
        <center>
        This page was last updated at: <%= partsbean.getCacheTimestamp() %> UTC
        </center>
    </footer>
</html>
