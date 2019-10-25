<#import "spring.ftl" as spring />
<!doctype html>
<html lang="en">
<head>
    <title>S<@spring.message 'sign_up'/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>

    <script src="js/jquery.min.js"></script>
    <script type="application/x-javascript">
        addEventListener("load",
            function() { setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){ window.scrollTo(0,1); }
    </script>

</head>
<body>

<#--animate for callbacks_container-->
<script src="js/responsiveslides.min.js"></script>
<script>
    $(function () {
        $("#slider").responsiveSlides({
            auto: true,
            nav: true,
            speed: 500,
            namespace: "callbacks",
            pager: true
        });
    });
</script>

<div class="banner-bg banner-bg1">
    <div class="container">
        <div class="header">
            <div class="logo">
                <img src="images/logo.png" alt=""/>
                <form method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="text"  name="firstName" placeholder="First Name">
                    <br>
                    <input type="text" name="lastName" placeholder="Last Name">
                    <br>
                    <input type="text" name="login" placeholder="Login">
                    <br>
                    <input type="password" name="password" placeholder="Password">
                    <br>
                    <br/>
                    <input type="submit" value="SignUp">
                </form>
            </div>
            <div class="top-nav">
                <label class="mobile_menu" for="mobile_menu">
                    <span>Menu</span>
                </label>
                <input id="mobile_menu" type="checkbox">
                <ul class="nav">
                    <li class="dropdown1"><a href="/signIn"><@spring.message 'sign_in'/></a></li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="caption">
        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li><h1>HANDMADE BICYCLE</h1></li>
                    <li><h1>SPEED BICYCLE</h1></li>
                    <li><h1>MOUINTAIN BICYCLE</h1></li>
                </ul>
                <p>You <span>create</span> the <span>journey,</span> we supply the <span>parts</span></p>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="container wrap">
        <div class="logo2">
            <a href="/index"><img src="images/logo2.png" alt=""/></a>
        </div>
    </div>
</div>
</body>
</html>

