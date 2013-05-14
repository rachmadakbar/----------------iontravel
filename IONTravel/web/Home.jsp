<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ION Travel</title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="favicon.ico">
        <link rel="stylesheet" href="css/mystyle.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <script type="text/javascript" src="js/jquery-1.6.js" ></script>
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-replace.js"></script>  
        <script type="text/javascript" src="js/Forum_400.font.js"></script>
        <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="js/tms-0.3.js"></script>
        <script type="text/javascript" src="js/tms_presets.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
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
    <body id="page1">
        <div class="body6">
            <div class="body1">
                <div class="body5">
                    <div class="main">
                        <!-- header -->
                        <header>
                            <h1><a href="index.html" id="logo">ION Travel</a></h1>
                            <nav>
                                <ul id="top_nav">
                                    <li class="active"><a href="Home.jsp"><img src="images/icon_1.gif" alt=""></a></li>
                                    <li><a href="About.jsp"><img src="images/icon_2.gif" alt=""></a></li>
                                    <li id="end"><a href="Contact_Us.jsp"><img src="images/icon_3.gif" alt=""></a></li>
                                </ul>
                            </nav>
                            <nav>
                                <ul id="menu">
                                    <li><a href="Hotel.jsp">Hotel</a></li>
                                    <li><a href="Transportation.jsp">Transportasi</a></li>
                                    <li><a href="Town.jsp">Kota</a></li>
                                    <li><a href="Promo.jsp">Promo</a></li>
                                </ul>
                            </nav>
                        </header><div class="ic">More Website Templates  @ TemplateMonster.com - August 1st 2011!</div>
                        <!-- / header -->
                        <!-- content -->
                        <article id="content">
                            <div class="slider_bg">
                                <div class="slider">
                                    <ul class="items">
                                        <li>
                                            <img src="images/img1.jpg" alt="">
                                            <div class="banner">
                                                <strong>Italian<span>Fettuccine</span></strong>
                                                <b>Dish of the Day</b>
                                                <p>
                                                    <span>Lorem ipsum dolamet consectetur<br>
                                                        adipisicing elit, sed do eiusmod tempor aliqua enim ad minim veniam, quis nosinci- didunt ut labore et dolore.</span>
                                                </p>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="images/img2.jpg" alt="">
                                            <div class="banner">
                                                <strong>succulent<span>meat</span></strong>
                                                <b>Dish of the Day</b>
                                                <p>
                                                    <span>Lorem ipsum dolamet consectetur <br>
                                                        adipisicing elit, sed do eiusmod tempor aliqua enim ad minim veniam, quis nosinci- didunt ut labore et dolore.</span>
                                                </p>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="images/img3.jpg" alt="">
                                            <div class="banner">
                                                <strong>French-Style<span>Tartlet</span></strong>
                                                <b>Dish of the Day</b>
                                                <p>
                                                    <span>Lorem ipsum dolamet consectetur <br>
                                                        adipisicing elit, sed do eiusmod tempor aliqua enim ad minim veniam, quis nosinci- didunt ut labore et dolore.</span>
                                                </p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="wrap">
                                <section class="cols">
                                    <div class="box">
                                        <div id="home_box">
                                            <h2>Pencarian <span>Kota</span></h2>
                                            <form action="Search_Result.jsp" method="get">
                                                <div id="home_box_content">
                                                    <p class="pad_bot1">Mencari paket menuju kota tertentu? Masukkan nama kota yang ingin Anda kunjungi.</p>
                                                    <input type="text" name="key">
                                                </div>
                                                <input type="submit" class="button1" id="home_button" value="Cari">
                                            </form>
                                        </div>
                                    </div>
                                </section>
                                <section class="cols pad_left1">
                                    <div class="box">
                                        <div id="home_box">
                                            <h2>Registrasi</h2>
                                            <div id="home_box_content">
                                                <p class="pad_bot1">Belum terdaftar sebagai customer? Mendaftarlah sebagai customer untuk mengakses promo-promo istimewa ION Travel!</p>
                                            </div>
                                            <form action="Register" name="Register">
                                            <input type="submit" class="button1" id="home_button" value="Daftar" name="Daftar">
                                            </form>
                                        </div>
                                    </div>
                                </section>
                                <section class="cols pad_left1">
                                    <div class="box" >
                                        <div id="home_box">
                                            <h2>Log<span>in</span></h2>
                                            <form action="SignIn" name="login">
                                                <div id="home_box_content">
                                                    <ul>		
                                                        <li><label>Username</label></li>
                                                        <li><input type="text" name="username"></li>
                                                        <li><label>Password</label></li>
                                                        <li><input type="password" name="password"></li>
                                                        <li style="color:#A80002"><c:if test="${not empty signinstatus}">${signinstatus}</c:if></li>
                                                    </ul>
                                                </div>
                                                <input type="submit" class="button1" id="home_button" value="Login" name="Login">
                                            </form>	
                                        </div>
                                    </div>
                                </section>
                            </div>
                        </article>
                    </div>
                </div>
            </div>
        </div>
        <div class="body2">
            <div class="main">
                <article id="content2">
                    <section class="wrapper" id="bg">
                        <div class="wrapper">
                            <div id="pack_title">
                                <h2>PROMO PAKET</h2>
                            </div>

                            <div id="pack_box">
                                <div id="pack">
                                    <img src="images/pack1.jpg" />
                                    <h3>Depok - Jaya Wijaya</h3>
                                    <article>
                                        6 - 7 April 2013 </br>
                                        Bus, 01.00 - 22.00 WIB 
                                    </article>
                                    <a href="#" class="button1" onClick="document.getElementById('######').submit()">Book</a>
                                </div>
                                <div id="pack">
                                    <img src="images/pack1.jpg" />
                                    <h3>Depok - Jaya Wijaya</h3>
                                    <article>
                                        6 - 7 April 2013 </br>
                                        Bus, 01.00 - 22.00 WIB 
                                    </article>
                                    <a href="#" class="button1" onClick="document.getElementById('######').submit()">Book</a>
                                </div>							
                                <div id="pack">
                                    <img src="images/pack1.jpg" />
                                    <h3>Depok - Jaya Wijaya</h3>
                                    <article>
                                        6 - 7 April 2013 </br>
                                        Bus, 01.00 - 22.00 WIB 
                                    </article>
                                    <a href="#" class="button1" onClick="document.getElementById('######').submit()">Book</a>
                                </div>							
                                <div id="pack">
                                    <img src="images/pack1.jpg" />
                                    <h3>Depok - Jaya Wijaya</h3>
                                    <article>
                                        6 - 7 April 2013 </br>
                                        Bus, 01.00 - 22.00 WIB 
                                    </article>
                                    <a href="#" class="button1" onClick="document.getElementById('######').submit()">Book</a>
                                </div>
                            </div>
                        </div>
                        <div class="wrapper">
                            <a href="#" class="button1" style="float:right; margin-top:15px" onClick="document.getElementById('######').submit()">More...</a>
                        </div>
                    </section>
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
