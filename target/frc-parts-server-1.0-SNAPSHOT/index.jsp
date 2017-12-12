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
		<jsp:include page="header.html" />

    </head>

	<div class="pure-g" style="padding-top: 10px">
	<div class="pure-u-1-8"></div>
	<div class="pure-u-3-4">
    <body>
		<img class="pure-img" src="https://i.imgur.com/YebEVKt.jpg">

<br><br>
        <right><small>
			Cache was last updated at: <%= partsbean.getCacheTimestamp() %> UTC
		</small></right>
    </body>
	</div>
	<div class="pure-u-1-8"></div>

	</div>




	<jsp:include page="footer.jsp" />

</html>
