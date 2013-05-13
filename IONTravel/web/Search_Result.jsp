
<%@page import="model.TempatWisataModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="helper.TemporaryObject"%>
<%@page import="helper.TemporaryObject"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Search Result</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/mystyle.css" type="text/css" media="all">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.6.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>  
<script type="text/javascript" src="js/Forum_400.font.js"></script>
<script type="text/javascript" src="js/atooltip.jquery.js"></script> 
 
<!--[if lt IE 9]>
	<script type="text/javascript" src="js/html5.js"></script>
	<style type="text/css">
		.slider_bg {behavior:url(js/PIE.htc)}
	</style>
<![endif]-->
<!--[if lt IE 7]>
	<div style='clear:both;text-align:center;position:relative'>
		<a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" alt="" /></a>
	</div>
<![endif]-->
</head>
<body id="page2">
<div class="body6">
	<div class="body1">
		<div class="main">
<!-- header -->
			<header>
				<h1><a href="index.html" id="logo">Deliccio Classic European Cuisine</a></h1>
				<nav>
					<ul id="top_nav">
						<li><a href="index.html"><img src="images/icon_1.gif" alt=""></a></li>
						<li><a href="#"><img src="images/icon_2.gif" alt=""></a></li>
						<li class="end"><a href="Contacts.html"><img src="images/icon_3.gif" alt=""></a></li>
					</ul>
				</nav>
				<nav>
					<ul id="menu">
						<li><a href="index.html">Restaurant</a></li>
						<li class="active"><a href="Cuisine.html">Cuisine</a></li>
						<li><a href="Wine.html">Wine List</a></li>
						<li><a href="CookBook.html">CookBook</a></li>
						<li><a href="Contacts.html">Contacts</a></li>
					</ul>
				</nav>
			</header><div class="ic">More Website Templates  @ TemplateMonster.com - August 1st 2011!</div>
<!-- / header -->
		</div>
	</div>
</div>
<div class="body2">
	<div class="main">
		<article id="content2">
			<div class="wrapper">
				<h2 id="titlesearch">Search <span>Result</span></h2>
				<div id="keybox">
					<h3>Keyword: <span id="keyword"><%=request.getParameter("key") %></span><br></h3>
				</div>
				<div id="allres"> 
				<!-- Iterasi ini buat tiap result-->
					<%
                                            String key = request.getParameter("key");
                                            TempatWisataModel t = new TempatWisataModel();
                                            ArrayList<TemporaryObject> list = t.getTempatWisataByKey(key);
                                            String urlimage="images/page4_img3.jpg";
                                            String lokasi="tes";
						for (int i = 0; i < list.size(); i++) {
						out.print("<div id=\"resultbox\">");
						out.print("	<a href=\"Tourism_Site_Profile.jsp?id="+list.get(i).get(0)+"\" class=\"resultbox\">");
						out.print("		<figure class=\"left marg_right1\"><img src=\""+urlimage+"\" alt=\"\"></figure>");
						out.print("		<div id=\"resultplace\">"+list.get(i).get(1)+"</div>");
						out.print("		<div id=\"resultlocation\">"+lokasi+"</div>");
						out.print("	</a>");
						out.print("</div>");
						}
					%>
				</div>
			</div>
		</article>
<!-- / content -->
	</div>
</div>
<div class="body3">
	<div class="body4">
		<div class="main">
<!-- footer -->
			<footer>
				<div class="wrapper">
					<section class="col1 pad_left1">
						<h3>Final Project of <span>Group 8</span> <br>for <span>Web Service and Application</span> course</h3>
						<a rel="nofollow" href="http://www.templatemonster.com/" target="_blank">Website Template</a> by TemplateMonster.com
					</section>
					<section class="col2 pad_left1">
						<h3>Follow Us </h3>
						<ul id="icons">
							<li><a href="#" class="normaltip" title="Facebook"><img src="images/icon1.gif" alt=""></a></li>
							<li><a href="#" class="normaltip" title="Linkedin"><img src="images/icon2.gif" alt=""></a></li>
							<li><a href="#" class="normaltip" title="Twitter"><img src="images/icon3.gif" alt=""></a></li>
							<li><a href="#" class="normaltip" title="Delicious"><img src="images/icon4.gif" alt=""></a></li>
							<li><a href="#" class="normaltip" title="Technorati"><img src="images/icon5.gif" alt=""></a></li>
						</ul>
					</section>
				</div>
				<!-- {%FOOTER_LINK} -->
			</footer>
<!-- / footer -->
		</div>
	</div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>