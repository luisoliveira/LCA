<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>LCAAdvocacia</title>
		
		<link type="text/css" href="js/jquery-ui/css/ui-lightness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />	
		<link type="text/css" href="css/main.css" rel="stylesheet" />	
		<link type="text/css" href="css/menu.css" rel="stylesheet" />
		
		<script type="text/javascript" src="js/jquery-ui/js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui/js/jquery-ui-1.8.16.custom.min.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		
		<script type="text/javascript"> 
		$(document).ready(function(){
			
			$("ul.subnav").parent().append("<span></span>"); //Only shows drop down trigger when js is enabled - Adds empty span tag after ul.subnav
			
			$("ul.topnav li span").click(function() { //When trigger is clicked...
				
				//Following events are applied to the subnav itself (moving subnav up and down)
				$(this).parent().find("ul.subnav").slideDown('fast').show(); //Drop down the subnav on click

				$(this).parent().hover(function() {
				}, function(){	
					$(this).parent().find("ul.subnav").slideUp('slow'); //When the mouse hovers out of the subnav, move it back up
				});

				//Following events are applied to the trigger (Hover events for the trigger)
				}).hover(function() { 
					$(this).addClass("subhover"); //On hover over, add class "subhover"
				}, function(){	//On Hover Out
					$(this).removeClass("subhover"); //On hover out, remove class "subhover"
			});

		});
		</script>

		
</head> 
<body>
	<div id="header">
		
		<img src="img/logoAM.png" id="logo"></img>
		<h2 id="title">Gerenciamento de Processos</h2>  
      
		<ul class="topnav">
		    <li><a href="index.jsp">Home</a></li>
		    <li>
		        <a href="#">Cadastros</a>
		        <ul class="subnav">
		            <li><a href="#">Abastecimento</a></li>
		            <li><a href="#">Manutenção</a></li>
		        </ul>
		    </li>
		    <li>
		        <a href="#">Relatorios</a>
		        <ul class="subnav">
		            <li><a href="#">Abastecimento</a></li>
		            <li><a href="#">Menutenção</a></li>
		        </ul>
		    </li>
		   
		</ul>
 	</div>
 	 
 	<div id="content">
 	
 		
 	
 	</div>

</body>
</html>