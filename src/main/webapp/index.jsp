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
    
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script> 
		$(function(){
			$("#header").load("header.html"); 
			$("#footer").load("footer.html"); 
		});
	</script> 
	
	
    <head>
        <title>frcparts</title>
        <div id="header"/>
    </head>
    
    <body>
        
    </body>
    
    <footer>
        <div id="footer"/>
    </footer>
</html>
