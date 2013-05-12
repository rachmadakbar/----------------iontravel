<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Registration</title>
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
    <body id="page5">
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
                                <li><a href="index.html">Home</a></li>
                                <li><a href="Cuisine.html">Cuisine</a></li>
                                <li><a href="Wine.html">Wine List</a></li>
                                <li><a href="CookBook.html">CookBook</a></li>
                                <li><a href="Contacts.html">Contacts</a></li>
                            </ul>
                        </nav>
                    </header><div class="ic">More Website Templates  @ TemplateMonster.com - August 1st 2011!</div>
                    <!-- / header -->
                    <!-- content -->
                    <article id="content">
                        <div class="wrap">
                            <div class="box">
                                <div>
                                    <h2 class="letter_spacing">Customer <span>Registration</span></h2>
                                    <p class="letter_spacing">All fields must be filled, and we'll make sure to keep secure your data.</p>
                                    <form id="ContactForm" action="Register" method="get">
                                        <div id="signupform">
                                            <table>
                                                <tr  id="input_signup">
                                                    <td><span>Username:</span></td>
                                                    <td><input type="text" name="id"><c:if test="${not empty usernameError}">${usernameError}</c:if></td>
                                            </tr><tr  id="input_signup">
                                            <td><span>Password:</span></td>
                                            <td><input type="text" class="input"name="pwd"><c:if test="${not empty passwordError}">${passwordError}</c:if></td>								
                                    </tr><tr  id="input_signup">
                                    <td><span>Repeat Password:</span></td>
                                    <td><input type="text" class="input"name="pwd2"></td>								
                                </tr><tr  id="input_signup">
                                    <td><span>Fullname:</span></td>
                                    <td><input type="text" class="input"name="name"><c:if test="${not empty nameError}">${nameError}</c:if></td>								
                            </tr><tr  id="input_signup">
                            <td><span>E-mail:</span></td>
                            <td><input type="text" class="input"name="email"><c:if test="${not empty emailError}">${emailError}</c:if></td>								
                    </tr><tr  id="input_signup">
                    <td><span>Contact Number:</span></td>
                    <td><input type="text" class="input"name="phone"><c:if test="${not empty phoneError}">${phoneError}</c:if></td>
            </tr><tr  id="input_signup">
            <td><span>Address:</span></td>
            <td><input type="text" class="input"name="addr"><c:if test="${not empty addressError}">${addressError}</c:if></td>
    </tr><tr  id="input_signup">
    <td><span>Paypal Account:</span></td>
    <td><input type="text" class="input" name="paypal"></td>
</tr><tr  id="input_signup">
    <td><span>Location:</span></td>
    <td>
        <select name="location">
            <option value="Ambon">Ambon</option>
            <option value="Ambon">Ambon</option>
            <option value="Ambon">Ambon</option>
            <option value="Ambon">Ambon</option>
            <option value="Ambon">Ambon</option>
            <option value="Ambon">Ambon</option>
        </select>
    </td>	
</tr>
</table>
<p class="letter_spacing">Username, Fullname, and IDNumber cannot be changed. Make sure to check before submitting.</p>
<input type="submit" class="button1" value="Daftar" name="Daftar">
</div>
</form>
</div>
</div>
</div>
</article>
</div>
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
<script type="text/javascript"> Cufon.now();</script>
</body>
</html>