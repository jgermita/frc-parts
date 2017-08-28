<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>TODO supply a title</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        <jsp:useBean id="partsbean" scope="session" class="com.frcparts.PartsDbHandler" />
        <jsp:setProperty name="partsbean" property="contents" />
        <div><jsp:getProperty name="partsbean" property="contents" /></div>
    </body>
</html>
