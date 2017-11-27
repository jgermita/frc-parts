<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
	
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
	<link rel="stylesheet" href="blog.css">
    <link rel="shortcut icon" href="/favicon.ico" />
    <meta name="viewport" content="width=device-width">
    <jsp:useBean id="partsbean" scope="application" class="com.frcparts.PartsDbHandler" />
    
    <head>
		
        <title>frcparts - coming soon!</title>
		<jsp:include page="header.html" />
		
    </head>
    
    <body>
		<section class="post">
			<h2>About this project</h2>
			<p class="post-meta">"What was that part that team ABCD used on their 20XX robot?"</p>
			<div class="post-description">This project is an extension the work that many FIRST teams do every year: document the common parts that they order. This project has grown into an archive of the neat and nifty parts that teams use every year. </div>
		</section>>
		 
    </body>
    
	
	
	
	<jsp:include page="footer.html" />
	
</html>
