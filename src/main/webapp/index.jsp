<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
	
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
	
    <link rel="shortcut icon" href="/favicon.ico" />
    <meta name="viewport" content="width=device-width">
    <jsp:useBean id="partsbean" scope="application" class="com.frcparts.PartsDbHandler" />
    
    <head>
		
        <title>frcparts</title>
		
		<div class="pure-u-1-6"></div>
		<div class="pure-u-1-3"><jsp:include page="header.html" /></div>
		<div class="pure-u-1-6"></div>
        
    </head>
    
    <body>
        
    </body>
    
	
	<center>
		This page was last updated at: <%= partsbean.getCacheTimestamp() %> UTC
	</center>
	
	<jsp:include page="footer.html" />
	
</html>
